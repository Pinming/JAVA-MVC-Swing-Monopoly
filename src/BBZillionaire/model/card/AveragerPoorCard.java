package BBZillionaire.model.card;

import BBZillionaire.context.GameState;

import BBZillionaire.model.PlayerModel;

/**
 * 
 * ��ƶ��,��һ������ʹ�þ�ؚ���������c�ˌ���ƽ�֬F��
 * OK
 * 
 */
public class AveragerPoorCard extends Card {

	public AveragerPoorCard(PlayerModel owner) {
		super(owner);
		this.name = "AveragerPoorCard";
		this.cName = "��ƶ��";
		this.price = 200;
	}

	@Override
	public int useCard() {
		return GameState.CARD_AVERAGERPOOR;
	}

}
