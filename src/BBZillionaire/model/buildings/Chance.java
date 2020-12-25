package model.buildings;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import context.GameState;
import control.GameRunning;
import model.PlayerModel;
import model.buildings.Building;
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
	private final int MAXITEMSIZE = 12;

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
		for (int i = 0; i < MAXITEMSIZE; i++) {
			int random = (int) (Math.random() * 12);
			switch (random) {
			case 0:
				player.getCards().add(card = new AddLevelCard(null));
				break;
			case 1:
				player.getCards().add(card = new AveragerPoorCard(null));
				break;
			case 2:
				player.getCards().add(card = new ChangeCard(null));
				break;
			case 3:
				player.getCards().add(card = new ControlDiceCard(null));
				break;
			case 4:
				player.getCards().add(card = new CrossingCard(null));
				break;
			case 5:
				player.getCards().add(card = new HaveCard(null));
				break;
			case 6:
				player.getCards().add(card = new ReduceLevelCard(null));
				break;
			case 7:
				player.getCards().add(card = new RobCard(null));
				break;
			case 8:
				player.getCards().add(card = new StopCard(null));
				break;
			case 9:
				player.getCards().add(card = new TallageCard(null));
				break;
			case 10:
				player.getCards().add(card = new TortoiseCard(null));
				break;
			case 11:
				player.getCards().add(card = new TrapCard(null));
				break;
			}
		}
	}
	
	public Card getCards() {
		return card;
	}
	
	public PlayerModel getPlayer() {
		return player;
	}
	@Override
	public int getEvent() {
		return GameState.CHANCE_EVENT;
	}

}
