package model.card;

import context.GameState;

import model.PlayerModel;

/**
 * 
 * 陷害卡,使用陷害卡後選定一名對手，可以立刻讓對方入獄2天。
 * 
 */
public class TrapCard extends Card {

	public TrapCard(PlayerModel owner) {
		super(owner);
		this.name = "TrapCard";
		this.cName = "陷害卡";
	}

	@Override
	public int useCard() {
		return GameState.CARD_TRAP;
	}

}
