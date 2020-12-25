package model.card;

import context.GameState;
import model.PlayerModel;
import model.card.Card;

/**
 * 
 * 
 *�޻���,����Σ�U�ĕr���Ԅ���Ч�����ݺ�����~���3000Ԫ���ϣ��޵��o�e�ˡ�
 * 
 *
 */
public class CrossingCard extends Card{

	public CrossingCard(PlayerModel owner) {
		super(owner);
		this.name = "CrossingCard";
		this.cName = "�޻���";
	}

	@Override
	public int useCard() {
		return GameState.CARD_CROSSING;
	}

}
