package model.buildings;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.PlayerModel;

import context.GameState;
import control.Control;

import util.FileUtil;
import util.MyThread;

/**
 * 
 * ���� 1-3�� ƽ��  �̳�  Ħ���¥
 *
 * @author MOVELIGHTS
 * 
 */
public class House extends Building {

	private int upPrice;
	private String[] nameString = { "�յ�", "ƽ��", "�̳�", "Ħ���¥" };

	private PlayerModel player;

	public House(int posX, int posY) {
		super(posX, posY);
		this.maxLevel = 3;
	}
	/**
	 * 
	 * ��ȡ�����ܼ�ֵ
	 * 
	 * @return
	 */
	public int getAllPrice() {
		int price = 0;
		for (int i = 0; i <= level; i++) {
			if (this.level == 0) {
				price +=500;
			} else {
				price += 1000 * i;
			}
		}
		return price;
	}

	/**
	 * ˰��
	 * 
	 * @return
	 */
	public int getRevenue() {
		/**
		 * ˰�ʼ��㷽��
		 */
		this.revenue = this.level * (int) (Math.random() * 1000)
				+ (this.level * 300);
		return revenue;
	}

	/**
	 * ���ķ������ڵȼ�������
	 * @return 
	 */
	public String getName() {
		return this.nameString[this.level];
	}

	/**
	 * ��ø���һ������
	 * 
	 * @return
	 */
	public String getUpName() {
		if (this.level >= this.nameString.length - 1) {
			return "null";
		}
		return this.nameString[this.level + 1];
	}

	@Override
	public int getEvent() {
		return GameState.HUOSE_EVENT;
	}
}
