package BBZillionaire.model.card;

import BBZillionaire.context.GameState;

import BBZillionaire.model.PlayerModel;

/**
 * 
 * 
 * ���Ῠ,ʹ�Ó��Z������ԏ�һλ����̎���Zһ��Ƭ ���ܿ��������Ŀ�Ƭ���\�Ⓦ�Zһ����
 * 
 * 
 */
public class RobCard extends Card {

	public RobCard(PlayerModel owner) {
		super(owner);
		this.name = "RobCard";
		this.cName = "���Ῠ";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_ROB;
	}

}
