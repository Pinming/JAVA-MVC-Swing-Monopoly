package music;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ����jdk�ײ�APIʵ�ֵ����ֲ�����
 * 
 * @����
 * 1��ֻ֧��wav����ֻ�ܲ���һ��
 * 2����ѭ�����ţ���ʱֹͣ��������ͣ��
 * 3��֧��һ����Χ�ڵ���������
 * 
 * �ο�����:
 * https://blog.csdn.net/qq_21907023/article/details/96174077
 * https://blog.csdn.net/fuckcdn/article/details/83725725
 * 
 * @author passerbyYSQ
 * @create 2020��7��20�� ����4:05:50
 */
public class MusicPlay {
//	private AudioInputStream audioIn;
//	private SourceDataLine sourceDataLine;
	// wav�ļ���·��
	private File file;
	// �Ƿ�ѭ������
	private boolean isLoop = false;
	// �Ƿ����ڲ���
	private boolean isPlaying;
	// FloatControl.Type.MASTER_GAIN��ֵ(�����ڵ�������)
	private float newVolume = 7;

	private PlayThread playThread;
	
//	public static void main(String[] args) {
//		try {
			//MusicPlay  player1 = new MusicPlay ("D:\\game21\\images\\�ҵ���Ƶ�ز�\\����ز - ���������������.wav"); 
			//MusicPlay  player = new MusicPlay ("F:\\�������ʵѵ\\��Ч\\������.mp3");
//			MusicPlayer player = new MusicPlayer("F:\\�������ʵѵ\\CrazyArcade-master\\music\\bgm0.wav");
//			player.setVolumn(6f).play();
//			System.out.println("��ʼ����");
//			
//			System.out.println("�Ƿ���ͣ��");
//			Scanner sc = new Scanner(System.in);
//			int isOver = sc.nextInt();
//			if (isOver == 1) {
//				player.over();
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public MusicPlay(String srcPath) {
		file = new File(srcPath);
	}
	
	/**
	 * ��������
	 */
	public void play() {
		playThread = new PlayThread();
		playThread.start();
	}
	
	/**
	 * �������֣�������ͣ��
	 */
	public void over() {
		isPlaying = false;
		if (playThread != null) {
			playThread = null;
		}
	}
	
	/**
	 * ����ѭ������
	 * @param isLoop
	 * @return	���ص�ǰ����
	 */
	public MusicPlay  setLoop(boolean isLoop) {
		this.isLoop = isLoop;
		return this;
	}
	
	/**
	 * -80.0~6.0206����,ԽС����ԽС
	 * @param newVolume
	 * @return	���ص�ǰ����
	 */
	public MusicPlay  setVolume(float newVolume) {
		this.newVolume = newVolume;
		return this;
	}
	
	/**
	 * �첽�����߳�
	 */
	private class PlayThread extends Thread {
	
		@Override
		public void run() {
			isPlaying = true;
			do {
//				isPlaying = true;
				
				SourceDataLine sourceDataLine = null;
				BufferedInputStream bufIn = null;
				AudioInputStream audioIn = null;
				try {
					bufIn = new BufferedInputStream(new FileInputStream(file));
					audioIn = AudioSystem.getAudioInputStream(bufIn); // ��ֱ�Ӵ���file
					
					AudioFormat format = audioIn.getFormat();
					sourceDataLine = AudioSystem.getSourceDataLine(format);
					sourceDataLine.open();
					// ����open֮��
					if (newVolume != 7) {
						FloatControl control = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
//						System.out.println(control.getMaximum());
//						System.out.println(control.getMinimum());
						control.setValue(newVolume);
					}
					
					sourceDataLine.start();
					byte[] buf = new byte[512];
//					System.out.println(audioIn.available());
					int len = -1;
					while (isPlaying && (len = audioIn.read(buf)) != -1) {
						sourceDataLine.write(buf, 0, len);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
					if (sourceDataLine != null) {
						sourceDataLine.drain(); 
						sourceDataLine.close();
					}
					try {
						if (bufIn != null) {
							bufIn.close();
						}
						if (audioIn != null) {
							audioIn.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} while (isPlaying && isLoop);
		}
	}
	
	
}