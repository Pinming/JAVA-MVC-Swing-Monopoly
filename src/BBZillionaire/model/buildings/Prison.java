package BBZillionaire.model.buildings;

import BBZillionaire.model.PlayerModel;

import BBZillionaire.context.GameState;

/**
 * 
 * ���� ��ҵ���������������߷��������¼�
 * 
 * 
 * @author MOVELIGHTS
 * 
 */
public class Prison extends Building {

	private String[] events = { "ȥ�����������ѣ�", "��ԩ��������", "����������Աץȥ��ɨ������" };

	private PlayerModel player;

	public Prison(int posX, int posY) {
		super(posX, posY);
		this.name = "����";
	}

	public String[] getEvents() {
		return events;
	}

	@Override
	public int getEvent() {
		return GameState.PRISON_EVENT;
	}
}
