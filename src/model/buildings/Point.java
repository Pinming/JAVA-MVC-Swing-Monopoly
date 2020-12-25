package model.buildings;

import model.PlayerModel;
import model.TextTipModel;
import context.GameState;
import control.Control;

/**
 * 
 * 1000 3000 5000 金币位 角色到达金币位的时候，可以获得响应 金币的金额
 * 
 * 
 * @author MOVELIGHTS
 * 
 */
public class Point extends Building {

	private int point;

	public Point(int posX, int posY, int point) {
		super(posX, posY);
		this.name = point + "金币位";
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	@Override
	public int getEvent() {
		return GameState.POINT_EVENT;
	}
}
