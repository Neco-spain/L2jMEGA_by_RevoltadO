package net.sf.l2j.gameserver.handler.itemhandlers;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.handler.IItemHandler;
import net.sf.l2j.gameserver.model.actor.Playable;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.model.item.instance.ItemInstance;


/**
* @author Paulinho Souza
* @author KhayrusS
**/

public class VipItem implements IItemHandler
{
	private static final int ITEM_IDS[] = { Config.VIP_ITEM };

 @Override
 public synchronized void useItem(Playable playable,
	 ItemInstance item,boolean forceUse) {
		 if(!(playable instanceof Player))
				 return;

		 Player player = (Player)playable;
	
		 if (player.isInOlympiadMode())
				 player.sendMessage("You cannot this item in Olympics.");
		 else
		 {
				 if(playable.destroyItem("Consume", item.getObjectId(), 1, null,
								 false)) {
			    player.setVip(true);
			    player.rewardVipSkills();
			    player.setEndTime("vip", Config.VIP_DIAS);
			   
			    player.getInventory().addItem("", Config.VIP_ITEMID, 1, player, null);
			  
			    player.sendMessage("You became a VIP, you will have " +"Access privileges Npcs Vips, Your  Vip Last "+Config.VIP_DIAS+" Days.");
				   player.broadcastUserInfo();
		    }
	 }
 }

 public int[] getItemIds()
 {
		 return ITEM_IDS;
 }
}