package model.card;

import context.GameState;

import model.PlayerModel;

/**
 * 
 * �ݺ���,ʹ���ݺ������x��һ�����֣���������׌������z2�졣
 * 
 */
public class TrapCard extends Card {

	public TrapCard(PlayerModel owner) {
		super(owner);
		this.name = "TrapCard";
		this.cName = "�ݺ���";
	}

	@Override
	public int useCard() {
		return GameState.CARD_TRAP;
	}

}
