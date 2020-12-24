package BBZillionaire.model.buildings;

import BBZillionaire.model.PlayerModel;
import BBZillionaire.context.GameState;

/**
 * 
 * 乐透
 * 角色到达这里时，可以进行下注游戏，可能输赢奖金.
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
		this.name = "乐透";
	}
	
	@Override
	public int getEvent() {
		return GameState.LOTTERY_EVENT;
	}
}
