/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j.gameserver.model.actor.instance;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.cache.HtmCache;
import net.sf.l2j.gameserver.data.NpcTable;
import net.sf.l2j.gameserver.instancemanager.GrandBossManager;
import net.sf.l2j.gameserver.instancemanager.RaidBossSpawnManager;
import net.sf.l2j.gameserver.model.actor.Npc;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.model.actor.template.NpcTemplate;
import net.sf.l2j.gameserver.network.serverpackets.NpcHtmlMessage;
import net.sf.l2j.gameserver.templates.StatsSet;

public class RaidBossInfo extends Npc
{
	
	public RaidBossInfo(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public void showChatWindow(Player player)
	{
		generateFirstWindow(player);
	}

	public void generateFirstWindow(Player activeChar)
	{
		final StringBuilder tb = new StringBuilder();

		for (int boss : Config.GRAND_BOSS_LIST)
		{
			String name = "";
			NpcTemplate template = null;
			if ((template = NpcTable.getInstance().getTemplate(boss)) != null)
			{
				name = template.getName();
			}
			else
			{
				_log.warning("Raid Info: Raid Boss with ID " + boss + " is not defined into NpcXml");
				continue;
			}
			
			StatsSet actual_boss_stat = null;
			
			GrandBossManager.getInstance().getStatsSet(boss);
			long delay = 0;
			
			if (NpcTable.getInstance().getTemplate(boss).isType("RaidBoss"))
			{
				delay = RaidBossSpawnManager.getInstance().getRespawntime(boss);
				
			}
			else if (NpcTable.getInstance().getTemplate(boss).isType("GrandBoss"))
			{
				actual_boss_stat = GrandBossManager.getInstance().getStatsSet(boss);
				if (actual_boss_stat != null)
					delay = actual_boss_stat.getLong("respawn_time");
			}
			else
				continue;
			
			if (delay <= System.currentTimeMillis())
			{
				tb.append("&nbsp;<font color=\"FFFFFF\">" + name + "</font>: " + "<font color=\"4d94ff\">Is Alive</font>" + "<br1>");
				tb.append("<img src=\"L2UI.SquareGray\" width=300 height=1><br>");
			}
			else
			{
				int hours = (int) ((delay - System.currentTimeMillis()) / 1000 / 60 / 60);
				int mins = (int) (((delay - (hours * 60 * 60 * 1000)) - System.currentTimeMillis()) / 1000 / 60);
				int seconts = (int) (((delay - ((hours * 60 * 60 * 1000) + (mins * 60 * 1000))) - System.currentTimeMillis()) / 1000);
				tb.append("&nbsp;<font color=\"4d94ff\">" + name + "</font>" + "<font color=\"FFFFFF\">" + " " + "Respawn in :</font>" + " " + " <font color=\"FF9900\">" + hours + " : " + mins + " : " + seconts + "</font><br1>");
				tb.append("<img src=\"L2UI.SquareGray\" width=300 height=1><br>");
			}
		}

		NpcHtmlMessage html = new NpcHtmlMessage(1);
		html.setFile(getHtmlPath(getNpcId(), 0));
		html.replace("%objectId%", getObjectId());
		html.replace("%bosslist%", tb.toString());
		activeChar.sendPacket(html);
	}

	@Override
	public String getHtmlPath(int npcId, int val)
	{
		String filename;

		if (val == 0)
			filename = "data/html/mods/RaidBossStatus/" + npcId + ".htm";
		else
			filename = "data/html/mods/RaidBossStatus/" + npcId + "-" + val + ".htm";

		if (HtmCache.getInstance().isLoadable(filename))
			return filename;

		return "data/html/mods/RaidBossStatus/" + npcId + ".htm";
	}
}