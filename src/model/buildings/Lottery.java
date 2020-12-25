package model.buildings;

import model.PlayerModel;
import model.TextTipModel;

import java.awt.Image;

import javax.swing.ImageIcon;

import context.GameState;
import control.Control;

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
	
	private Image[] imgageEvents = { EVENT_LUCK_GAIN_1000_01, EVENT_LUCK_GAIN_2000_01,
			EVENT_LUCK_GAIN_2000_02, 
			};
	/**
	 * 事件图片
	 */
	public static Image EVENT_LUCK_GAIN_1000_01 = new ImageIcon(
			"images/event/luck_gain1000.jpg").getImage();
	/**
	 * 事件图片
	 */
	public static Image EVENT_LUCK_GAIN_2000_01 = new ImageIcon(
			"images/event/luck_gain2000_01.jpg").getImage();
	/**
	 * 事件图片
	 */
	public static Image EVENT_LUCK_GAIN_2000_02 = new ImageIcon(
			"images/event/luck_gain2000.jpg").getImage();

	public Image[] getImgageEvents() {
		return imgageEvents;
	}
	
	@Override
	public int getEvent() {
		return GameState.LOTTERY_EVENT;
	}
}
