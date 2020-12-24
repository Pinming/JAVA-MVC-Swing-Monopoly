package BBZillionaire.model.card;

import BBZillionaire.context.GameState;

import BBZillionaire.model.PlayerModel;

/**
 * 
 * ��˰��,ֱ�ӌ�����ʹ�ö�����������ȡ�F���10%���
 * 
 *
 */
public class TallageCard extends Card{

	public TallageCard(PlayerModel owner) {
		super(owner);
		this.name = "TallageCard";
		this.cName = "��˰��";
		this.price = 100;
	}

	@Override
	public int useCard() {
		return GameState.CARD_TALLAGE;
	}

}