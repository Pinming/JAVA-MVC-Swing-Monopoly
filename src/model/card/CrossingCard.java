package model.card;

import context.GameState;
import model.PlayerModel;
import model.card.Card;

/**
 * 
 * 
 *嫁祸卡,遇到危險的時候自動生效，將陷害或大額租金（3000元以上）嫁禍給別人。
 * 
 *
 */
public class CrossingCard extends Card{

	public CrossingCard(PlayerModel owner) {
		super(owner);
		this.name = "CrossingCard";
		this.cName = "嫁祸卡";
	}

	@Override
	public int useCard() {
		return GameState.CARD_CROSSING;
	}

}
