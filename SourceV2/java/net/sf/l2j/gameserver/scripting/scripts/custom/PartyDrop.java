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
package net.sf.l2j.gameserver.scripting.scripts.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.sf.l2j.commons.random.Rnd;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.model.actor.Npc;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.network.serverpackets.PlaySound;
import net.sf.l2j.gameserver.scripting.Quest;

public class PartyDrop extends Quest
{
	boolean _canReward = false;
	static HashMap<String, Integer> playerIps = new HashMap<>();
	
	public PartyDrop()
	{
		super(-1, "custom");
		
		addKillId(Config.NPC_LIST_SET);
	}
	
	@Override
	public String onKill(Npc npc, Player player, boolean isPet)
	{
		if (player.isInParty())
		{
			List<Player> party = player.getParty().getMembers();
			
			for (Player member : party)
			{
				String pIp = member.getClient().getConnection().getInetAddress().getHostAddress();
				
				if (!playerIps.containsKey(pIp))
				{
					playerIps.put(pIp, 1);
					_canReward = true;
				}
				else
				{
					int count = playerIps.get(pIp);
					
					if (count < 1)
					{
						playerIps.remove(pIp);
						playerIps.put(pIp, count + 1);
						_canReward = true;
					}
					else
					{
						member.sendMessage("Already 1 member of your ip have been rewarded, so this character won't be rewarded.");
						_canReward = false;
					}
				}
				if (_canReward)
				{
					if (member.isInsideRadius(npc, 1000, false, false))
					{
						Set<Integer> rewards = Config.PARTY_DROP_REWARDS.keySet();
						for (Integer i : rewards)
						{
							if (Rnd.get(100) < Config.CHANCE_PARTY_DROP)
								member.addItem("Party Drop Rewards.", Config.PARTY_DROP_REWARDS.get(i), i, member, true);
							member.broadcastPacket(new PlaySound("ItemSound.quest_finish"));
						}
					}
					else
					{
						member.sendMessage("You are too far to be rewarded.");
					}
				}
			}
			playerIps.clear();
		}
		else
		{
			Set<Integer> rewards = Config.PARTY_DROP_REWARDS.keySet();
			for (Integer i : rewards)
			{
				if (Rnd.get(100) < Config.CHANCE_PARTY_DROP)
					player.addItem("Party Drop Rewards.", Config.PARTY_DROP_REWARDS.get(i), i, player, true);
				player.broadcastPacket(new PlaySound("ItemSound.quest_finish"));
			}
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		new PartyDrop();
	}
}