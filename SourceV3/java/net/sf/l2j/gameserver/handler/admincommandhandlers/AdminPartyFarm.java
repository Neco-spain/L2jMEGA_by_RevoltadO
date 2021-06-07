package net.sf.l2j.gameserver.handler.admincommandhandlers;
	
import java.util.ArrayList;
import java.util.logging.Logger;
	
import net.sf.l2j.commons.concurrent.ThreadPool;

import net.sf.l2j.gameserver.data.SpawnTable;
import net.sf.l2j.gameserver.events.PartyFarm;
import net.sf.l2j.gameserver.handler.IAdminCommandHandler;
import net.sf.l2j.gameserver.model.L2Spawn;
import net.sf.l2j.gameserver.model.actor.Player;
	
	
	public class AdminPartyFarm implements IAdminCommandHandler
	{
		public static L2Spawn _monster;
		private static final String[] ADMIN_COMMANDS =
		{
			"admin_ptfarm"
	
		};
		
		protected static final Logger _log = Logger.getLogger(AdminPartyFarm.class.getName());
		public static boolean _bestfarm_manual = true;
		public static boolean _arena_manual = false;
	
		@Override
		public boolean useAdminCommand(String command, Player activeChar)
		{
			
	
			
			if (command.startsWith("admin_ptfarm"))
				if (PartyFarm._started)
				{
					_log.info("----------------------------------------------------------------------------");
					_log.info("[Party Farm]: Event Finished.");
					_log.info("----------------------------------------------------------------------------");
					PartyFarm._aborted = true;
					unSpawnMonsters();
					finishEventPartyFarm();
	
					activeChar.sendMessage("SYS: Voce Finalizou o Party Farm Manualmente..");
				}
				else
				{
					_log.info("----------------------------------------------------------------------------");
					_log.info("[Party Farm]: Event Started.");
					_log.info("----------------------------------------------------------------------------");
					initEventPartyFarm();
					_bestfarm_manual = true;
					activeChar.sendMessage("SYS: Voce ativou o Best Farm Manualmente..");
				}
			return true;
		}
	
	
	
		/**
		 * 
		 */
		protected static ArrayList<L2Spawn> monsters = new ArrayList<>();
		
		private static void unSpawnMonsters()
		{
			for (L2Spawn s : monsters)
			{
				if (s == null)
				{
					monsters.remove(s);
					return;
				}
				
				s.getNpc().deleteMe();
				s.setRespawnState(false);
				SpawnTable.getInstance().deleteSpawn(s, true);
	
			}
			
		}
	
	
	
		private static void initEventPartyFarm()
		{
			ThreadPool.schedule(new Runnable()
			{
				@Override
				public void run()
				{
	
					PartyFarm.bossSpawnMonster();
				}
			}, 1L);
		}
	
		private static void finishEventPartyFarm()
		{
			ThreadPool.schedule(new Runnable()
			{
				@Override
				public void run()
				{
	
					PartyFarm.Finish_Event();
	
				}
			}, 1L);
		}
	
		@Override
		public String[] getAdminCommandList()
		{
			return ADMIN_COMMANDS;
		}
	}