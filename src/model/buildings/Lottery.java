package model.buildings;

import model.PlayerModel;
import model.TextTipModel;

import java.awt.Image;

import javax.swing.ImageIcon;

import context.GameState;
import control.Control;

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
	
	private Image[] imgageEvents = { EVENT_LUCK_GAIN_1000_01, EVENT_LUCK_GAIN_2000_01,
			EVENT_LUCK_GAIN_2000_02, 
			};
	/**
	 * �¼�ͼƬ
	 */
	public static Image EVENT_LUCK_GAIN_1000_01 = new ImageIcon(
			"images/event/luck_gain1000.jpg").getImage();
	/**
	 * �¼�ͼƬ
	 */
	public static Image EVENT_LUCK_GAIN_2000_01 = new ImageIcon(
			"images/event/luck_gain2000_01.jpg").getImage();
	/**
	 * �¼�ͼƬ
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
