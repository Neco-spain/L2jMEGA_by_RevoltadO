package net.sf.l2j.gameserver.handler.itemhandlers;


import net.sf.l2j.Config;
import net.sf.l2j.gameserver.data.SkillTable;
import net.sf.l2j.gameserver.handler.IItemHandler;
import net.sf.l2j.gameserver.model.L2Skill;
import net.sf.l2j.gameserver.model.actor.Playable;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.model.item.instance.ItemInstance;
import net.sf.l2j.gameserver.network.serverpackets.MagicSkillUse;
import net.sf.l2j.gameserver.network.serverpackets.SocialAction;

/**
 * @author COMBATE
 *
 */
public class Visual implements IItemHandler
{
	@Override
	public void useItem(Playable playable, ItemInstance item, boolean forceUse)
	{
		if(Config.ENABLE_VISUAL_SET)
		{
			if (!(playable instanceof Player))
				
				return;
			
			Player player = (Player) playable;
			int itemId = item.getItemId();
			
			switch(itemId)
			{
				//Item_ID ItemHander Config/data/xml/item/ItemHander
				case 12500:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR1;
							itemId = Config.VISUAL_CHEST1;
							player.setVisual(player.getVisual() == 1 ? 0 : 1);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME1);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
							
							
						}
					}else{
						itemId = Config.VISUAL_HAIR1;
						itemId = Config.VISUAL_CHEST1;
						player.setVisual(player.getVisual() == 1 ? 0 : 1);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME1);
					}
					break;
					
				case 12501:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR2;
							itemId = Config.VISUAL_CHEST2;
							player.setVisual(player.getVisual() == 2 ? 0 : 2);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME2);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
							
						}
					}else{
						itemId = Config.VISUAL_HAIR2;
						itemId = Config.VISUAL_CHEST2;
						player.setVisual(player.getVisual() == 2 ? 0 : 2);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME2);
					}
					break;
				case 12502:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR3;
							itemId = Config.VISUAL_CHEST3;
							itemId = Config.VISUAL_LEGS3;
							itemId = Config.VISUAL_GLOVES3;
							itemId = Config.VISUAL_BOOTS3;
							player.setVisual(player.getVisual() == 3 ? 0 : 3);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME3);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR3;
						itemId = Config.VISUAL_CHEST3;
						itemId = Config.VISUAL_LEGS3;
						itemId = Config.VISUAL_GLOVES3;
						itemId = Config.VISUAL_BOOTS3;
						player.setVisual(player.getVisual() == 3 ? 0 : 3);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME3);
					}
					break;
				case 12503:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR4;
							itemId = Config.VISUAL_CHEST4;
							itemId = Config.VISUAL_LEGS4;
							itemId = Config.VISUAL_GLOVES4;
							itemId = Config.VISUAL_BOOTS4;
							player.setVisual(player.getVisual() == 4 ? 0 : 4);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME4);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR4;
						itemId = Config.VISUAL_CHEST4;
						itemId = Config.VISUAL_LEGS4;
						itemId = Config.VISUAL_GLOVES4;
						itemId = Config.VISUAL_BOOTS4;
						player.setVisual(player.getVisual() == 4 ? 0 : 4);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME4);
					}
				case 12504:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR5;
							itemId = Config.VISUAL_CHEST5;
							itemId = Config.VISUAL_LEGS5;
							itemId = Config.VISUAL_GLOVES5;
							itemId = Config.VISUAL_BOOTS5;
							player.setVisual(player.getVisual() == 5 ? 0 : 5);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME5);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR5;
						itemId = Config.VISUAL_CHEST5;
						itemId = Config.VISUAL_LEGS5;
						itemId = Config.VISUAL_GLOVES5;
						itemId = Config.VISUAL_BOOTS5;
						player.setVisual(player.getVisual() == 5 ? 0 : 5);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME5);
					}
					break;
				case 12505:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR6;
							itemId = Config.VISUAL_CHEST6;
							itemId = Config.VISUAL_LEGS6;
							itemId = Config.VISUAL_GLOVES6;
							itemId = Config.VISUAL_BOOTS6;
							player.setVisual(player.getVisual() == 6 ? 0 : 6);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME6);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR6;
						itemId = Config.VISUAL_CHEST6;
						itemId = Config.VISUAL_LEGS6;
						itemId = Config.VISUAL_GLOVES6;
						itemId = Config.VISUAL_BOOTS6;
						player.setVisual(player.getVisual() == 6 ? 0 : 6);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME6);
					}
					break;
				case 12506:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR7;
							itemId = Config.VISUAL_CHEST7;
							itemId = Config.VISUAL_LEGS7;
							itemId = Config.VISUAL_GLOVES7;
							itemId = Config.VISUAL_BOOTS7;
							player.setVisual(player.getVisual() == 7 ? 0 : 7);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME7);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR7;
						itemId = Config.VISUAL_CHEST7;
						itemId = Config.VISUAL_LEGS7;
						itemId = Config.VISUAL_GLOVES7;
						itemId = Config.VISUAL_BOOTS7;
						player.setVisual(player.getVisual() == 7 ? 0 : 7);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME7);
					}
					break;
				case 12507:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR8;
							itemId = Config.VISUAL_CHEST8;
							itemId = Config.VISUAL_LEGS8;
							itemId = Config.VISUAL_GLOVES8;
							itemId = Config.VISUAL_BOOTS8;
							player.setVisual(player.getVisual() == 8 ? 0 : 8);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME8);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR8;
						itemId = Config.VISUAL_CHEST8;
						itemId = Config.VISUAL_LEGS8;
						itemId = Config.VISUAL_GLOVES8;
						itemId = Config.VISUAL_BOOTS8;
						player.setVisual(player.getVisual() == 8 ? 0 : 8);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME8);
					}
					break;
				case 12508:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR9;
							itemId = Config.VISUAL_CHEST9;
							itemId = Config.VISUAL_LEGS9;
							itemId = Config.VISUAL_GLOVES9;
							itemId = Config.VISUAL_BOOTS9;
							player.setVisual(player.getVisual() == 9 ? 0 : 9);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME9);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR9;
						itemId = Config.VISUAL_CHEST9;
						itemId = Config.VISUAL_LEGS9;
						itemId = Config.VISUAL_GLOVES9;
						itemId = Config.VISUAL_BOOTS9;
						player.setVisual(player.getVisual() == 9 ? 0 : 9);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME9);
					}
					break;
				case 12509:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR10;
							itemId = Config.VISUAL_CHEST10;
							itemId = Config.VISUAL_LEGS10;
							itemId = Config.VISUAL_GLOVES10;
							itemId = Config.VISUAL_BOOTS10;
							player.setVisual(player.getVisual() == 10 ? 0 : 10);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME10);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR10;
						itemId = Config.VISUAL_CHEST10;
						itemId = Config.VISUAL_LEGS10;
						itemId = Config.VISUAL_GLOVES10;
						itemId = Config.VISUAL_BOOTS10;
						player.setVisual(player.getVisual() == 10 ? 0 : 10);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME10);
					}
					break;
				case 12510:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR11;
							itemId = Config.VISUAL_CHEST11;
							itemId = Config.VISUAL_LEGS11;
							itemId = Config.VISUAL_GLOVES11;
							itemId = Config.VISUAL_BOOTS11;
							player.setVisual(player.getVisual() == 11 ? 0 : 11);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME11);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR11;
						itemId = Config.VISUAL_CHEST11;
						itemId = Config.VISUAL_LEGS11;
						itemId = Config.VISUAL_GLOVES11;
						itemId = Config.VISUAL_BOOTS11;
						player.setVisual(player.getVisual() == 11 ? 0 : 11);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME11);
					}
					break;
				case 12511:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR12;
							itemId = Config.VISUAL_CHEST12;
							itemId = Config.VISUAL_LEGS12;
							itemId = Config.VISUAL_GLOVES12;
							itemId = Config.VISUAL_BOOTS12;
							player.setVisual(player.getVisual() == 12 ? 0 : 12);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME12);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR12;
						itemId = Config.VISUAL_CHEST12;
						itemId = Config.VISUAL_LEGS12;
						itemId = Config.VISUAL_GLOVES12;
						itemId = Config.VISUAL_BOOTS12;
						player.setVisual(player.getVisual() == 12 ? 0 : 12);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME12);
					}
					break;
				case 12512:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR13;
							itemId = Config.VISUAL_CHEST13;
							itemId = Config.VISUAL_LEGS13;
							itemId = Config.VISUAL_GLOVES13;
							itemId = Config.VISUAL_BOOTS13;
							player.setVisual(player.getVisual() == 13 ? 0 : 13);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME13);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR13;
						itemId = Config.VISUAL_CHEST13;
						itemId = Config.VISUAL_LEGS13;
						itemId = Config.VISUAL_GLOVES13;
						itemId = Config.VISUAL_BOOTS13;
						player.setVisual(player.getVisual() == 13 ? 0 : 13);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME13);
					}
					break;
				case 12513:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR14;
							itemId = Config.VISUAL_CHEST14;
							itemId = Config.VISUAL_LEGS14;
							itemId = Config.VISUAL_GLOVES14;
							itemId = Config.VISUAL_BOOTS14;
							player.setVisual(player.getVisual() == 14 ? 0 : 14);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME14);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR14;
						itemId = Config.VISUAL_CHEST14;
						itemId = Config.VISUAL_LEGS14;
						itemId = Config.VISUAL_GLOVES14;
						itemId = Config.VISUAL_BOOTS14;
						player.setVisual(player.getVisual() == 14 ? 0 : 14);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME14);
					}
					break;
				case 12518:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR15;
							itemId = Config.VISUAL_CHEST15;
							itemId = Config.VISUAL_LEGS15;
							itemId = Config.VISUAL_GLOVES15;
							itemId = Config.VISUAL_BOOTS15;
							player.setVisual(player.getVisual() == 15 ? 0 : 15);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME15);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR15;
						itemId = Config.VISUAL_CHEST15;
						itemId = Config.VISUAL_LEGS15;
						itemId = Config.VISUAL_GLOVES15;
						itemId = Config.VISUAL_BOOTS15;
						player.setVisual(player.getVisual() == 15 ? 0 : 15);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME15);
					}
					break;
				case 12519:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR16;
							itemId = Config.VISUAL_CHEST16;
							itemId = Config.VISUAL_LEGS16;
							itemId = Config.VISUAL_GLOVES16;
							itemId = Config.VISUAL_BOOTS16;
							player.setVisual(player.getVisual() == 16 ? 0 : 16);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME16);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR16;
						itemId = Config.VISUAL_CHEST16;
						itemId = Config.VISUAL_LEGS16;
						itemId = Config.VISUAL_GLOVES16;
						itemId = Config.VISUAL_BOOTS16;
						player.setVisual(player.getVisual() == 16 ? 0 : 16);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME16);
					}
					break;
				case 12520:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR17;
							itemId = Config.VISUAL_CHEST17;
							itemId = Config.VISUAL_LEGS17;
							itemId = Config.VISUAL_GLOVES17;
							itemId = Config.VISUAL_BOOTS17;
							player.setVisual(player.getVisual() == 17 ? 0 : 17);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME17);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR17;
						itemId = Config.VISUAL_CHEST17;
						itemId = Config.VISUAL_LEGS17;
						itemId = Config.VISUAL_GLOVES17;
						itemId = Config.VISUAL_BOOTS17;
						player.setVisual(player.getVisual() == 17 ? 0 : 17);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME17);
					}
					break;
				case 12521:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR18;
							itemId = Config.VISUAL_CHEST18;
							itemId = Config.VISUAL_LEGS18;
							itemId = Config.VISUAL_GLOVES18;
							itemId = Config.VISUAL_BOOTS18;
							player.setVisual(player.getVisual() == 18 ? 0 : 18);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME18);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR18;
						itemId = Config.VISUAL_CHEST18;
						itemId = Config.VISUAL_LEGS18;
						itemId = Config.VISUAL_GLOVES18;
						itemId = Config.VISUAL_BOOTS18;
						player.setVisual(player.getVisual() == 18 ? 0 : 18);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME18);
					}				
					break;
				case 12522:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR19;
							itemId = Config.VISUAL_CHEST19;
							itemId = Config.VISUAL_LEGS19;
							itemId = Config.VISUAL_GLOVES19;
							itemId = Config.VISUAL_BOOTS19;
							player.setVisual(player.getVisual() == 19 ? 0 : 19);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME19);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR19;
						itemId = Config.VISUAL_CHEST19;
						itemId = Config.VISUAL_LEGS19;
						itemId = Config.VISUAL_GLOVES19;
						itemId = Config.VISUAL_BOOTS19;
						player.setVisual(player.getVisual() == 19 ? 0 : 19);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME19);
					}										
					break;
				case 12523:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR20;
							itemId = Config.VISUAL_CHEST20;
							itemId = Config.VISUAL_LEGS20;
							itemId = Config.VISUAL_GLOVES20;
							itemId = Config.VISUAL_BOOTS20;
							player.setVisual(player.getVisual() == 20 ? 0 : 20);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME20);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR20;
						itemId = Config.VISUAL_CHEST20;
						itemId = Config.VISUAL_LEGS20;
						itemId = Config.VISUAL_GLOVES20;
						itemId = Config.VISUAL_BOOTS20;
						player.setVisual(player.getVisual() == 20 ? 0 : 20);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME20);
					}
					
					
					break;
				case 12524:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR21;
							itemId = Config.VISUAL_CHEST21;
							itemId = Config.VISUAL_LEGS21;
							itemId = Config.VISUAL_GLOVES21;
							itemId = Config.VISUAL_BOOTS21;
							player.setVisual(player.getVisual() == 21 ? 0 : 21);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME21);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR21;
						itemId = Config.VISUAL_CHEST21;
						itemId = Config.VISUAL_LEGS21;
						itemId = Config.VISUAL_GLOVES21;
						itemId = Config.VISUAL_BOOTS21;
						player.setVisual(player.getVisual() == 21 ? 0 : 21);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME21);
					}
					
					
					break;
				case 12525:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR22;
							itemId = Config.VISUAL_CHEST22;
							itemId = Config.VISUAL_LEGS22;
							itemId = Config.VISUAL_GLOVES22;
							itemId = Config.VISUAL_BOOTS22;
							player.setVisual(player.getVisual() == 22 ? 0 : 22);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME22);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR22;
						itemId = Config.VISUAL_CHEST22;
						itemId = Config.VISUAL_LEGS22;
						itemId = Config.VISUAL_GLOVES22;
						itemId = Config.VISUAL_BOOTS22;
						player.setVisual(player.getVisual() == 22 ? 0 : 22);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME22);
					}
					
					
					break;
				case 12526:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR23;
							itemId = Config.VISUAL_CHEST23;
							itemId = Config.VISUAL_LEGS23;
							itemId = Config.VISUAL_GLOVES23;
							itemId = Config.VISUAL_BOOTS23;
							player.setVisual(player.getVisual() == 23 ? 0 : 23);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME23);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR23;
						itemId = Config.VISUAL_CHEST23;
						itemId = Config.VISUAL_LEGS23;
						itemId = Config.VISUAL_GLOVES23;
						itemId = Config.VISUAL_BOOTS23;
						player.setVisual(player.getVisual() == 23 ? 0 : 23);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME23);
					}
					
					
					break;
				case 12527:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR24;
							itemId = Config.VISUAL_CHEST24;
							itemId = Config.VISUAL_LEGS24;
							itemId = Config.VISUAL_GLOVES24;
							itemId = Config.VISUAL_BOOTS24;
							player.setVisual(player.getVisual() == 24 ? 0 : 24);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME24);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR24;
						itemId = Config.VISUAL_CHEST24;
						itemId = Config.VISUAL_LEGS24;
						itemId = Config.VISUAL_GLOVES24;
						itemId = Config.VISUAL_BOOTS24;
						player.setVisual(player.getVisual() == 24 ? 0 : 24);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME24);
					}
					
					
					break;
				case 12528:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR25;
							itemId = Config.VISUAL_CHEST25;
							itemId = Config.VISUAL_LEGS25;
							itemId = Config.VISUAL_GLOVES25;
							itemId = Config.VISUAL_BOOTS25;
							player.setVisual(player.getVisual() == 25 ? 0 : 25);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME25);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR25;
						itemId = Config.VISUAL_CHEST25;
						itemId = Config.VISUAL_LEGS25;
						itemId = Config.VISUAL_GLOVES25;
						itemId = Config.VISUAL_BOOTS25;
						player.setVisual(player.getVisual() == 25 ? 0 : 25);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME25);
					}
					
					
					break;
				case 12629:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR26;
							itemId = Config.VISUAL_CHEST26;
							itemId = Config.VISUAL_LEGS26;
							itemId = Config.VISUAL_GLOVES26;
							itemId = Config.VISUAL_BOOTS26;
							player.setVisual(player.getVisual() == 26 ? 0 : 26);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME26);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR26;
						itemId = Config.VISUAL_CHEST26;
						itemId = Config.VISUAL_LEGS26;
						itemId = Config.VISUAL_GLOVES26;
						itemId = Config.VISUAL_BOOTS26;
						player.setVisual(player.getVisual() == 26 ? 0 : 26);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME26);
					}
					
					
					break;
				case 6379:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR27;
							itemId = Config.VISUAL_CHEST27;
							itemId = Config.VISUAL_LEGS27;
							itemId = Config.VISUAL_GLOVES27;
							itemId = Config.VISUAL_BOOTS27;
							player.setVisual(player.getVisual() == 27 ? 0 : 27);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME27);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR27;
						itemId = Config.VISUAL_CHEST27;
						itemId = Config.VISUAL_LEGS27;
						itemId = Config.VISUAL_GLOVES27;
						itemId = Config.VISUAL_BOOTS27;
						player.setVisual(player.getVisual() == 27 ? 0 : 27);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME27);
					}
					
					
					break;
				case 6373:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR28;
							itemId = Config.VISUAL_CHEST28;
							itemId = Config.VISUAL_LEGS28;
							itemId = Config.VISUAL_GLOVES28;
							itemId = Config.VISUAL_BOOTS28;
							player.setVisual(player.getVisual() == 28 ? 0 : 28);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME28);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR28;
						itemId = Config.VISUAL_CHEST28;
						itemId = Config.VISUAL_LEGS28;
						itemId = Config.VISUAL_GLOVES28;
						itemId = Config.VISUAL_BOOTS28;
						player.setVisual(player.getVisual() == 28 ? 0 : 28);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME28);
					}
					
					
					break;
				case 6383:
					if (Config.ENABLE_VISUAL_EFFECT)
					{
						L2Skill skill = SkillTable.FrequentSkill.MAGIC_VISUAL.getSkill();
						if (skill != null)
						{
							MagicSkillUse MSU = new MagicSkillUse(player, player, Config.ID_VISUAL_EFFECT, 1, 1, 0);
							player.sendPacket(MSU);
							player.broadcastPacket(MSU);
							player.useMagic(skill, false, false);
							itemId = Config.VISUAL_HAIR29;
							itemId = Config.VISUAL_CHEST29;
							itemId = Config.VISUAL_LEGS29;
							itemId = Config.VISUAL_GLOVES29;
							itemId = Config.VISUAL_BOOTS29;
							player.setVisual(player.getVisual() == 29 ? 0 : 29);
							playable.sendMessage("You have activated " + Config.VISUAL_NAME29);
							playable.broadcastPacket(new SocialAction(playable, Config.ID_VISUAL_SOCIAL_ACTION));
						}
					}else{
						itemId = Config.VISUAL_HAIR29;
						itemId = Config.VISUAL_CHEST29;
						itemId = Config.VISUAL_LEGS29;
						itemId = Config.VISUAL_GLOVES29;
						itemId = Config.VISUAL_BOOTS29;
						player.setVisual(player.getVisual() == 29 ? 0 : 29);
						playable.sendMessage("You have activated " + Config.VISUAL_NAME28);
					}
					
					
					break;

					
			}
		}
		else
			playable.sendMessage("Sorry, admin has disabled skins.");
	}
	
}