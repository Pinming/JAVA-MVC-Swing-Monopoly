package BBZillionaire.main;

import javax.swing.UIManager;

import BBZillionaire.music.Music;
import BBZillionaire.ui.JFrameGame;
import BBZillionaire.ui.WaitFrame;
import BBZillionaire.ui.config.FrameConfig;

public class Main {

	static {
		// 设置样式
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e1) {
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// 建立等待界面
		WaitFrame wFrame = new WaitFrame();
		// 建立游戏主窗口
		JFrameGame frame = new JFrameGame();
		// 建立游戏配置窗口
		new FrameConfig(wFrame,frame);
		Music Data=new Music();
		new Thread(()->{while(true) {Data.playMusic();} //while中的true可换成参数来控制音乐的停止播放
		}).start();// Lambda表达式
	}

}

