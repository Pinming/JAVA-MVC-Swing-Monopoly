package ui;

import javax.swing.JFrame;

import util.FrameUtil;

@SuppressWarnings("serial")
public class JFrameGame extends JFrame {

	/**
	 * 
	 * Ĭ����panel
	 * 
	 * */
	private JPanelGame panelGame = null;
	
	public JFrameGame() {
		// ��������
		this.setTitle("BBZillionaire");
		// ����Ĭ�Ϲر����ԣ����������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô��ڴ�С
		this.setSize(1000, 800);
		// �������û��ı䴰�ڴ�С
		this.setResizable(false);
		// ����
		FrameUtil.setFrameCenter(this);
		// ����Ĭ��Panel
		this.panelGame = new JPanelGame();
		add(this.panelGame);
		
		// ���ñ߿���ʾ
		this.setUndecorated(false);
	}

	public JPanelGame getPanelGame() {
		return panelGame;
	}
}
