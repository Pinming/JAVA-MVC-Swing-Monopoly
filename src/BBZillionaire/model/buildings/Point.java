package BBZillionaire.model.buildings;

import BBZillionaire.context.GameState;

/**
 * 
 * 10 30 50 ���λ ��ɫ������λ��ʱ�򣬿��Ի����Ӧ ��� �Ľ��
 * 
 * 
 * @author MOVELIGHTS
 * 
 */
public class Point extends Building {

	private int point;


	public Point(int posX, int posY, int point) {
		super(posX, posY);
		this.name = point + "���λ";
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
