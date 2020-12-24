package BBZillionaire.model.buildings;

import BBZillionaire.model.PlayerModel;
import BBZillionaire.context.GameState;

/**
 * 
 * ��͸
 * ��ɫ��������ʱ�����Խ�����ע��Ϸ��������Ӯ����.
 * 
 * 
 * 
 * @author MOVELIGHTS
 * 
 */
public class Lottery extends Building {

	private PlayerModel player;
	
	public Lottery(int posX, int posY) {
		super(posX, posY);
		this.name = "��͸";
	}
	
	@Override
	public int getEvent() {
		return GameState.LOTTERY_EVENT;
	}
}
