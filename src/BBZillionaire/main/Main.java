package BBZillionaire.main;

import javax.swing.UIManager;

import BBZillionaire.ui.JFrameGame;
import BBZillionaire.ui.WaitFrame;
import BBZillionaire.ui.config.FrameConfig;

public class Main {

	static {
		// ������ʽ
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e1) {
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// �����ȴ�����
		WaitFrame wFrame = new WaitFrame();
		// ������Ϸ������
		JFrameGame frame = new JFrameGame();
		// ������Ϸ���ô���
		new FrameConfig(wFrame,frame);
	}
}