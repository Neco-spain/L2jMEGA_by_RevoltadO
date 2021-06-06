package com.rouxy.phantom.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rouxy.phantom.FakePlayer;
import com.rouxy.phantom.helpers.FakeHelpers;
import com.rouxy.phantom.model.HealingSpell;
import com.rouxy.phantom.model.OffensiveSpell;
import com.rouxy.phantom.model.SupportSpell;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.model.ShotType;

public class GrandKhavatariAI extends CombatAI
{
	public GrandKhavatariAI(FakePlayer character)
	{
		super(character);
	}
	
	
	@Override
	public void thinkAndAct()
	{
		super.thinkAndAct();
		setBusyThinking(true);
		applyDefaultBuffs();
		handleShots();			
		tryTargetRandomCreatureByTypeInRadius(FakeHelpers.getTestTargetClass(), FakeHelpers.getTestTargetRange());	
		if(Config.FAKE_PLAYER_CAN_TARGET_REAL_PLAYER == true)
		{
			tryFlagTargetRandom(FakeHelpers.getFlagTargetClass(), FakeHelpers.getTestTargetRange());
		}
		tryAttackingUsingFighterOffensiveSkill();
		
		setBusyThinking(false);
	}
	
	@Override
	protected double changeOfUsingSkill() {
		return 0.5;
	}
	
	@Override
	protected ShotType getShotType()
	{
		return ShotType.SOULSHOT;
	}
	
	@Override
	protected List<OffensiveSpell> getOffensiveSpells()
	{
		List<OffensiveSpell> _offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new OffensiveSpell(284, 1));
		_offensiveSpells.add(new OffensiveSpell(281, 2));
		_offensiveSpells.add(new OffensiveSpell(280, 3));
		_offensiveSpells.add(new OffensiveSpell(54, 4));		
		_offensiveSpells.add(new OffensiveSpell(346, 5));
		return _offensiveSpells; 
	}
	
	@Override
	protected int[][] getBuffs()
	{
		return FakeHelpers.getFighterBuffs();
	}	
	
	@Override
	protected List<HealingSpell> getHealingSpells()
	{		
		return Collections.emptyList();
	}
	
	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		return Collections.emptyList();
	}
}