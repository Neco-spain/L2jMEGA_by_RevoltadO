package net.sf.l2j.gameserver.events;

import net.sf.l2j.commons.concurrent.ThreadPool;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.Announcements;
import net.sf.l2j.gameserver.data.ItemTable;
import net.sf.l2j.gameserver.data.NpcTable;
import net.sf.l2j.gameserver.data.SpawnTable;
import net.sf.l2j.gameserver.events.tournaments.Arena2x2;
import net.sf.l2j.gameserver.events.tournaments.Arena4x4;
import net.sf.l2j.gameserver.events.tournaments.Arena9x9;
import net.sf.l2j.gameserver.handler.admincommandhandlers.AdminCustom;
import net.sf.l2j.gameserver.model.L2Spawn;
import net.sf.l2j.gameserver.model.World;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.model.actor.template.NpcTemplate;
import net.sf.l2j.gameserver.network.serverpackets.CreatureSay;
import net.sf.l2j.gameserver.network.serverpackets.MagicSkillUse;

public abstract class ArenaTask
{
	public static L2Spawn _npcSpawn1;
	public static L2Spawn _npcSpawn2;
	public static int _bossHeading = 0;
	public static boolean _started = false;
	public static boolean _aborted = false;
	
	public static void SpawnEvent()
	{
		spawnNpc1();
		Announcements.ArenaAnnounce("Reward: " + ItemTable.getInstance().getTemplate(Config.ARENA_REWARD_ID).getName());
		Announcements.Announce("[Tournament]: Party Event PvP");
		Announcements.Announce("[Tournament]: Teleport in the GK to (Tournament) Zone");
		
		Announcements.Announce("[Tournament]: Duration: " + Config.TOURNAMENT_TIME + " minute(s)!");
		
		_aborted = false;
		_started = true;
		
		waiter(Config.TOURNAMENT_TIME * 60 * 1000);
		if (!_aborted)
		{
			finishEvent();
		}
	}
	
	public static void finishEvent()
	{
		Announcements.Announce("[Tournament]: Event Finished!");
		
		unspawnNpc1();
		_started = false;
		if (!AdminCustom._arena_manual)
		{
			ArenaEvent.getInstance().StartCalculationOfNextEventTime();
		}
		else
		{
			AdminCustom._arena_manual = false;
		}
		for (Player player : World.getInstance().getPlayers())
		{
			if ((player != null) && (player.isOnline()))
			{
				if (player.isArenaProtection())
				{
					ThreadPool.schedule(new Runnable()
					{
						@Override
						public void run()
						{
							if ((player.isOnline()) && (!player.isInArenaEvent()) && (!player.isArenaAttack()))
							{
								Arena4x4.getInstance().remove(player);
								Arena9x9.getInstance().remove(player);
								Arena2x2.getInstance().remove(player);
								player.setArenaProtection(false);
							}
						}
					}, 25000L);
				}
				CreatureSay cs = new CreatureSay(player.getObjectId(), 3, "[Tournament]", "Next Tournament: " + ArenaEvent.getInstance().getNextTime() + " (GMT-3).");
				player.sendPacket(cs);
			}
		}
	}
	
	public static void spawnNpc1()
	{
		NpcTemplate tmpl = NpcTable.getInstance().getTemplate(Config.ARENA_NPC);
		try
		{
			_npcSpawn1 = new L2Spawn(tmpl);
			_npcSpawn1.setLoc(loc1x(), loc1y(), loc1z(), Config.NPC_Heading);
			_npcSpawn1.setRespawnDelay(1);
			
			SpawnTable.getInstance().addNewSpawn(_npcSpawn1, false);
			
			_npcSpawn1.setRespawnState(true);
			_npcSpawn1.doSpawn(false);
			_npcSpawn1.getNpc().getStatus().setCurrentHp(9.99999999E8D);
			_npcSpawn1.getNpc().isAggressive();
			_npcSpawn1.getNpc().decayMe();
			_npcSpawn1.getNpc().spawnMe(_npcSpawn1.getNpc().getX(), _npcSpawn1.getNpc().getY(), _npcSpawn1.getNpc().getZ());
			_npcSpawn1.getNpc().broadcastPacket(new MagicSkillUse(_npcSpawn1.getNpc(), _npcSpawn1.getNpc(), 1034, 1, 1, 1));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean is_started()
	{
		return _started;
	}
	
	public static void unspawnNpc1()
	{
		if (_npcSpawn1 == null)
		{
			return;
		}
		_npcSpawn1.getNpc().deleteMe();
		_npcSpawn1.setRespawnState(false);
		SpawnTable.getInstance().deleteSpawn(_npcSpawn1, true);
	}
	
	public static void unspawnNpc2()
	{
		if (_npcSpawn2 == null)
		{
			return;
		}
		_npcSpawn2.getNpc().deleteMe();
		_npcSpawn2.setRespawnState(false);
		SpawnTable.getInstance().deleteSpawn(_npcSpawn2, true);
	}
	
	public static int loc1x()
	{
		int loc1x = Config.NPC_locx;
		return loc1x;
	}
	
	public static int loc1y()
	{
		int loc1y = Config.NPC_locy;
		return loc1y;
	}
	
	public static int loc1z()
	{
		int loc1z = Config.NPC_locz;
		return loc1z;
	}
	
	protected static void waiter(long interval)
	{
		long startWaiterTime = System.currentTimeMillis();
		int seconds = (int) (interval / 1000L);
		while ((startWaiterTime + interval > System.currentTimeMillis()) && (!_aborted))
		{
			seconds--;
			switch (seconds)
			{
				case 3600:
					if (_started)
					{
						Announcements.Announce("[Tournament]: Party Event PvP");
						Announcements.Announce("[Tournament]: Teleport in the GK to (Tournament) Zone");
						Announcements.Announce("[Tournament]: Reward: " + ItemTable.getInstance().getTemplate(Config.ARENA_REWARD_ID).getName());
						Announcements.Announce("[Tournament]: " + seconds / 60 / 60 + " hour(s) till event finish!");
					}
					break;
				case 60:
				case 120:
				case 180:
				case 240:
				case 300:
				case 600:
				case 900:
				case 1800:
					if (_started)
					{
						Announcements.Announce("[Tournament]: " + seconds / 60 + " minute(s) till event finish!");
					}
					break;
				case 1:
				case 2:
				case 3:
				case 10:
				case 15:
				case 30:
					if (_started)
					{
						Announcements.Announce("[Tournament]: " + seconds + " second(s) till event finish!");
					}
					break;
			}
			long startOneSecondWaiterStartTime = System.currentTimeMillis();
			while (startOneSecondWaiterStartTime + 1000L > System.currentTimeMillis())
			{
				try
				{
					Thread.sleep(1L);
				}
				catch (InterruptedException localInterruptedException)
				{
				}
			}
		}
	}
}
