package net.sf.l2j.gameserver.handler.voicedcommandhandlers;

import net.sf.l2j.gameserver.data.ItemTable;
import net.sf.l2j.gameserver.handler.IVoicedCommandHandler;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.network.serverpackets.NpcHtmlMessage;

/**
 * @author Anarchy

 *
 */
public class DressMe implements IVoicedCommandHandler
{
	private static final String[] VOICED_COMMANDS = { "dressme" };
	

	@Override
	public boolean useVoicedCommand(String command, Player activeChar, String target)
	{
		if (command.equals("dressme"))
		{
			sendMainWindow(activeChar);
		}
		
		return true;
	}
	
	public static void sendMainWindow(Player activeChar)
	{
		NpcHtmlMessage htm = new NpcHtmlMessage(0);
		htm.setFile("./data/html/custom/dressme/main.htm");
		htm.replace("%enabled%", activeChar.isDressMeEnabled() ? "enabled" : "disabled");
		if (activeChar.getDressMeData() == null)
		{
			htm.replace("%chestinfo%", "You have no custom chest.");
			htm.replace("%legsinfo%", "You have no custom legs.");
			htm.replace("%bootsinfo%", "You have no custom boots.");
			htm.replace("%glovesinfo%", "You have no custom gloves.");
			htm.replace("%weapinfo%", "You have no custom weapon.");
			htm.replace("%hairinfo%", "You have no custom weapon.");
		}
		else
		{
			htm.replace("%chestinfo%", activeChar.getDressMeData().getChestId() == 0 ? "You have no custom chest." : ItemTable.getInstance().getTemplate(activeChar.getDressMeData().getChestId()).getName());
			htm.replace("%legsinfo%", activeChar.getDressMeData().getLegsId() == 0 ? "You have no custom legs." : ItemTable.getInstance().getTemplate(activeChar.getDressMeData().getLegsId()).getName());
			htm.replace("%bootsinfo%", activeChar.getDressMeData().getBootsId() == 0 ? "You have no custom boots." : ItemTable.getInstance().getTemplate(activeChar.getDressMeData().getBootsId()).getName());
			htm.replace("%glovesinfo%", activeChar.getDressMeData().getGlovesId() == 0 ? "You have no custom gloves." : ItemTable.getInstance().getTemplate(activeChar.getDressMeData().getGlovesId()).getName());
			htm.replace("%weapinfo%", activeChar.getDressMeData().getWeapId() == 0 ? "You have no custom weapon." : ItemTable.getInstance().getTemplate(activeChar.getDressMeData().getWeapId()).getName());
			htm.replace("%hairinfo%", activeChar.getDressMeData().getHairId() == 0 ? "You have no custom weapon." : ItemTable.getInstance().getTemplate(activeChar.getDressMeData().getHairId()).getName());
		}
		
		activeChar.sendPacket(htm);
	}

	@Override
	public String[] getVoicedCommandList()
	{
		return VOICED_COMMANDS;
	}
}