package net.sf.l2j.gameserver.network.serverpackets;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.data.NpcTable;
import net.sf.l2j.gameserver.instancemanager.CursedWeaponsManager;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.model.group.Party;
import net.sf.l2j.gameserver.model.itemcontainer.Inventory;
import net.sf.l2j.gameserver.model.location.Location;
import net.sf.l2j.gameserver.model.zone.ZoneId;
import net.sf.l2j.gameserver.skills.AbnormalEffect;

public class CharInfo extends L2GameServerPacket
{
	private final Player _activeChar;
	private final Inventory _inv;

	public CharInfo(Player cha)
	{
		_activeChar = cha;
		_inv = _activeChar.getInventory();
	}

	@Override
	protected final void writeImpl()
	{
		boolean gmSeeInvis = false;
		boolean tournament_observer = false;
		boolean tournament_pt = false;
		boolean tournament_start = false;
		boolean Olympiad_start = false;
		boolean Olympiad_observer = false;
		boolean tournament_zone = false;
		
		Party party = _activeChar.getParty();
		if (_activeChar.getClan() != null)
		{
			Player tmp = getClient().getActiveChar();
			if (tmp != null)
			{
				if ((tmp.getClan() == null) || ((_activeChar.getAllyId() != 0) && (tmp.getAllyId() != 0) && (_activeChar.getAllyId() == tmp.getAllyId())) || (_activeChar.getClanId() == 0) || (tmp.getClanId() == 0) || (_activeChar.getClanId() != tmp.getClanId()))
				{
				}
			}
		}
		if (_activeChar.getAppearance().getInvisible())
		{
			
			Player tmp = getClient().getActiveChar();
			if (tmp != null)
			{
				if ((_activeChar.isArenaProtection()) && (tmp.isArenaObserv()))
				{
					tournament_observer = true;
				}
				else if ((_activeChar.isArenaProtection()) && (party != null) && (!tmp.isArenaAttack()) && (tmp.isInArenaEvent()) && (party.getMembers().contains(tmp)))
				{
					tournament_pt = true;
				}
				else if ((_activeChar.isArenaProtection()) && (tmp.isArenaAttack()) && (!tmp.inObserverMode()))
				{
					tournament_start = true;
				}
				else if ((_activeChar.isInsideZone(ZoneId.TOURNAMENT)) && (!_activeChar.isGM()) && (tmp.isInsideZone(ZoneId.TOURNAMENT)) && (!tmp.inObserverMode()))
				{
					tournament_zone = true;
				}
				else if ((_activeChar.isGM()) && (tmp.isGM()))
				{
					gmSeeInvis = true;
				}
			}
		}
		
		if (_activeChar.isOlympiadProtection())
		{
			Player tmp = getClient().getActiveChar();
			if (tmp != null)
			{
				if ((tmp.isOlympiadProtection()) && (!tmp.inObserverMode()))
				{
					Olympiad_start = true;
				}
				else if ((tmp.inObserverMode()) && (!tmp.isArenaObserv()))
				{
					Olympiad_observer = true;
				}
			}
		}

		writeC(0x03);
		writeD(_activeChar.getX());
		writeD(_activeChar.getY());
		writeD(_activeChar.getZ());
		writeD(_activeChar.getHeading());
		writeD(_activeChar.getObjectId());
		writeS(_activeChar.getName());
		writeD(_activeChar.getRace().ordinal());
		writeD(_activeChar.getAppearance().getSex().ordinal());

		if (_activeChar.getClassIndex() == 0)
			writeD(_activeChar.getClassId().getId());
		else
			writeD(_activeChar.getBaseClass());
		writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_HAIRALL));
		writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_HEAD));
		writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_RHAND));
		writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_LHAND));
		writeD(_activeChar.visual_gloves > 0 ? _activeChar.visual_gloves : _inv.getPaperdollItemId(Inventory.PAPERDOLL_GLOVES));
		writeD(_activeChar.visual_chest > 0 ? _activeChar.visual_chest : _inv.getPaperdollItemId(Inventory.PAPERDOLL_CHEST));
		writeD(_activeChar.visual_legs > 0 ? _activeChar.visual_legs :_inv.getPaperdollItemId(Inventory.PAPERDOLL_LEGS));
		writeD(_activeChar.visual_gloves > 0 ? _activeChar.visual_gloves :_inv.getPaperdollItemId(Inventory.PAPERDOLL_FEET));
		writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_BACK));
		writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_RHAND));
		writeD(_activeChar.visual_boots > 0 ? _activeChar.visual_boots : _inv.getPaperdollItemId(Inventory.PAPERDOLL_HAIR));
		writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_FACE));

		// c6 new h's
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeD(_inv.getPaperdollAugmentationId(Inventory.PAPERDOLL_RHAND));
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeD(_inv.getPaperdollAugmentationId(Inventory.PAPERDOLL_LHAND));
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);
		writeH(0x00);

		writeD(_activeChar.getPvpFlag());
		writeD(_activeChar.getKarma());

		writeD(_activeChar.getMAtkSpd());
		writeD(_activeChar.getPAtkSpd());

		writeD(_activeChar.getPvpFlag());
		writeD(_activeChar.getKarma());

		int _runSpd = _activeChar.getStat().getBaseRunSpeed();
		int _walkSpd = _activeChar.getStat().getBaseWalkSpeed();
		int _swimSpd = _activeChar.getStat().getBaseSwimSpeed();
		writeD(_runSpd); // base run speed
		writeD(_walkSpd); // base walk speed
		writeD(_swimSpd); // swim run speed
		writeD(_swimSpd); // swim walk speed
		writeD(_runSpd);
		writeD(_walkSpd);
		writeD(_activeChar.isFlying() ? _runSpd : 0); // fly run speed
		writeD(_activeChar.isFlying() ? _walkSpd : 0); // fly walk speed
		writeF(_activeChar.getStat().getMovementSpeedMultiplier()); // run speed multiplier
		writeF(_activeChar.getStat().getAttackSpeedMultiplier()); // attack speed multiplier

		if (_activeChar.getMountType() != 0)
		{
			writeF(NpcTable.getInstance().getTemplate(_activeChar.getMountNpcId()).getCollisionRadius());
			writeF(NpcTable.getInstance().getTemplate(_activeChar.getMountNpcId()).getCollisionHeight());
		}
		else
		{
			writeF(_activeChar.getCollisionRadius());
			writeF(_activeChar.getCollisionHeight());
		}

		writeD(_activeChar.getAppearance().getHairStyle());
		writeD(_activeChar.getAppearance().getHairColor());
		writeD(_activeChar.getAppearance().getFace());

		if (gmSeeInvis)
			writeS("Invisible");
		else if (((_activeChar.isDead()) && (!_activeChar.isInArenaEvent())))
			writeS("");
		else
			writeS(_activeChar.getTitle());

		writeD(_activeChar.getClanId());
		writeD(_activeChar.getClanCrestId());
		writeD(_activeChar.getAllyId());
		writeD(_activeChar.getAllyCrestId());

		writeD(0);

		writeC(_activeChar.isSitting() ? 0 : 1); // standing = 1 sitting = 0
		writeC(_activeChar.isRunning() ? 1 : 0); // running = 1 walking = 0
		writeC(_activeChar.isInCombat() ? 1 : 0);
		writeC(_activeChar.isAlikeDead() ? 1 : 0);
		
		if ((gmSeeInvis) || (tournament_pt) || (tournament_start) || (tournament_observer) || (Olympiad_start) || (Olympiad_observer) || (tournament_zone))
			writeC(0);
		else
			writeC(_activeChar.getAppearance().getInvisible() ? 1 : 0); // invisible = 1 visible =0

		writeC(_activeChar.getMountType()); // 1 on strider 2 on wyvern 0 no mount
		writeC(_activeChar.getStoreType().getId()); // 1 - sellshop

		writeH(_activeChar.getCubics().size());
		for (int id : _activeChar.getCubics().keySet())
			writeH(id);
		
		if (((_activeChar.isDead()) && (!_activeChar.isInArenaEvent())))
			writeC(0);
		else
			writeC(_activeChar.isInPartyMatchRoom() ? 1 : 0);
		
		if (gmSeeInvis)
			writeD((_activeChar.getAbnormalEffect() | AbnormalEffect.STEALTH.getMask()));
		else
			writeD(_activeChar.getAbnormalEffect());

		writeC(_activeChar.getRecomLeft());
		writeH(_activeChar.getRecomHave()); // Blue value for name (0 = white, 255 = pure blue)
		writeD(_activeChar.getClassId().getId());

		writeD(_activeChar.getMaxCp());
		writeD((int) _activeChar.getCurrentCp());
		writeC(_activeChar.isMounted() ? 0 : _activeChar.getEnchantEffect());

		if (_activeChar.getTeam() == 1)
			writeC(0x01); // team circle around feet 1= Blue, 2 = red
		else if (_activeChar.getTeam() == 2)
			writeC(0x02); // team circle around feet 1= Blue, 2 = red
		else
			writeC(0x00); // team circle around feet 1= Blue, 2 = red

		writeD(_activeChar.getClanCrestLargeId());
		writeC(_activeChar.isNoble() ? 1 : 0); // Symbol on char menu ctrl+I
		writeC((_activeChar.isHero() || (_activeChar.isGM() && Config.GM_HERO_AURA)) ? 1 : 0); // Hero Aura

		writeC(_activeChar.isFishing() ? 1 : 0); // 0x01: Fishing Mode (Cant be undone by setting back to 0)

		Location loc = _activeChar.getFishingLoc();
		if (loc != null)
		{
			writeD(loc.getX());
			writeD(loc.getY());
			writeD(loc.getZ());
		}
		else
		{
			writeD(0);
			writeD(0);
			writeD(0);
		}

		writeD(_activeChar.getAppearance().getNameColor());

		writeD(0x00); // isRunning() as in UserInfo?

		writeD(_activeChar.getPledgeClass());
		writeD(_activeChar.getPledgeType());

		writeD(_activeChar.getAppearance().getTitleColor());

		if (_activeChar.isCursedWeaponEquipped())
			writeD(CursedWeaponsManager.getInstance().getCurrentStage(_activeChar.getCursedWeaponEquippedId()) - 1);
		else
			writeD(0x00);
	}
}