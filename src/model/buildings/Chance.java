package model.buildings;

import context.GameState;
import model.PlayerModel;
import model.card.*;

/**
 *
 *
 * 机会模型
 *
 * @author MOVELIGHTS
 *
 */
public class Chance extends Building {

	private PlayerModel player;

	private Card card;
	private final int MAX_ITEM_SIZE = 12;

	public Chance(int posX, int posY) {
		super(posX, posY);
		this.name = "机会";
	}

	/**
	 *
	 * 生成一张卡片
	 *
	 */
	public void createCards() {
		// 产生新的card
		for (int i = 0; i < MAX_ITEM_SIZE; i++) {
			int random = (int) (Math.random() * 12);
			switch (random) {
				case 0:
					card = new AddLevelCard(player);
					break;
				case 1:
					card = new AveragerPoorCard(player);
					break;
				case 2:
					card = new ChangeCard(player);
					break;
				case 3:
					card = new ControlDiceCard(player);
					break;
				case 4:
					card = new CrossingCard(player);
					break;
				case 5:
					card = new HaveCard(player);
					break;
				case 6:
					card = new ReduceLevelCard(player);
					break;
				case 7:
					card = new RobCard(player);
					break;
				case 8:
					card = new StopCard(player);
					break;
				case 9:
					card = new TallageCard(player);
					break;
				case 10:
					card = new TortoiseCard(player);
					break;
				case 11:
					card = new TrapCard(player);
					break;
			}
		}
	}

	public PlayerModel getPlayer() {
		return player;
	}
	@Override
	public int getEvent() {
		return GameState.CHANCE_EVENT;
	}

	public Card getCard() {
		// TODO Auto-generated method stub
		return card;
	}

}
