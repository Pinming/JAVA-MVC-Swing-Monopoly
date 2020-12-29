package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import ui.massage.MassageOk;
import ui.massage.MassageSimple;
import ui.massage.MassageYesNo;
import control.Control;
import music.MusicPlay;

@SuppressWarnings("serial")
public class JPanelGame extends JPanel{

	private JFrameGame gameFrame = null;
	private JLayeredPane layeredPane;

	private List<Layer> lays = null;
	private Background backgroundUI = null;
	private Lands landsUI = null;
	private Buildings buildingsUI = null;
	private Players playersUI = null;
	private TextTip textTip = null;
	private PlayersPanel layerPlayersPanel = null;
	private Dice dice = null;
	private Event event = null;
	//	private Shop shop = null;
	private Running running = null;
	private Effect effect = null;
	//音乐播放按钮
	private JButton musicPlay=new JButton();

	private PlayerInfo playerInfo = null;

	private MassageYesNo massageYesNo = null;
	private MassageOk massageOk = null;
	private MassageSimple massageSimple = null;

	private Control control = null;

	/**
	 * 全局左上角X
	 */
	public int posX = 100;
	/**
	 * 全局左上角Y
	 * */
	public int posY = 100;

	public JPanelGame() {
		setLayout(new BorderLayout());
		// 初始化游戏
		initGame();
	}

	/**
	 *
	 * 初始化游戏
	 *
	 */
	private void initGame() {
		// 添加控制器
		control = new Control();
		// 初始化UI
		initUI();
		// panel 传入控制器
		control.setPanel(this);
	}

	public Control getControl() {
		return control;
	}

	/**
	 *
	 * 初始化UI
	 *
	 */
	private void initUI() {

		// 创建背景UI
		this.backgroundUI = new Background(0, 0, 1000, 800,
				control.getBackground(),this);
		// 创建土地UI
		this.landsUI = new Lands(posX, posY, 1000, 800, control.getLand());
		// 创建房屋UI
		this.buildingsUI = new Buildings(posX, posY, 950, 650,
				control.getBuilding());
		// 创建玩家显示UI
		this.playersUI = new Players(posX, posY, 950, 650,control.getRunning(), control.getPlayers());
		// 玩家信息面板UI
		this.layerPlayersPanel = new PlayersPanel(425, 170, 170,
				250, control.getPlayers());
		// 文字显示面板UI
		this.textTip = new TextTip(0,0,950,650,control.getTextTip());
		// 骰子事件UI
		this.dice = new Dice(425, 450, 170, 90, control);
		// 事件显示UI
		this.event = new Event(0, 0, 950, 650, control.getEvents());
		// 商店界面UI
//		this.shop = new Shop(0, 0, 750, 650, control, this);
		// 游戏运转界面UI
		this.running = new Running(780, 0, 200, 80, control.getRunning(),this);
		// 场景效果UI
		this.effect = new Effect(0, 0, 950, 650, control.getEffect(),this);
		// 玩家信息面板显示
		this.playerInfo = new PlayerInfo(control.getPlayers(),this);
		// 对话UI
		this.massageYesNo = new MassageYesNo("选择框", "创建一个对话框", this);
		// 对话UI
		this.massageOk = new MassageOk("确定框", "创建一个对话框", this);
		// 对话UI
		this.massageSimple = new MassageSimple("多选框", "创建一个对话框", this);


		// lays存放所有panel组件
		lays = new ArrayList<Layer>();
		lays.add(backgroundUI);
		lays.add(dice);
		lays.add(playersUI);
//		lays.add(textTip);
		lays.add(layerPlayersPanel);
		lays.add(buildingsUI);
		lays.add(landsUI);
		lays.add(backgroundUI);
		lays.add(running);
		lays.add(effect);
		// lays.add(shop);
		// lays.add(massageYesNo);

		layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		addMusicPlayButton( layeredPane );
		int add = 1;
		//layeredPane.add(this.massageOk, add++);
		layeredPane.add(this.event, add++);
		layeredPane.add(this.effect, add++);
		layeredPane.add(this.textTip, add++);
		layeredPane.add(this.dice, add++);
		layeredPane.add(this.playersUI, add++);
		layeredPane.add(this.layerPlayersPanel, add++);
		layeredPane.add(this.buildingsUI, add++);
		layeredPane.add(this.landsUI, add++);
		layeredPane.add(this.running, add++);
		layeredPane.add(this.backgroundUI, add++);
//		layeredPane.add(this.shop, add++);
		layeredPane.add(this.playerInfo,add++);


		//layeredPane.add(this.massageYesNo, add++);
		//layeredPane.add(this.massageSimple, add++);

		add(layeredPane);
	}


	public MassageYesNo getMassageYesNo() {
		return massageYesNo;
	}

	public MassageOk getMassageOk() {
		return massageOk;
	}

	public MassageSimple getMassageSimple() {
		return massageSimple;
	}

	public Running getRunning() {
		return running;
	}

	public Dice getDice() {
		return dice;
	}

//	public Shop getShop() {
//		return this.shop;
//	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public Background getBackgroundUI() {
		return backgroundUI;
	}

	public Effect getEffect() {
		return effect;
	}

	public JFrameGame getGameFrame() {
		return gameFrame;
	}

	public PlayerInfo getPlayerInfo() {
		return playerInfo;
	}

	public void setGameFrame(JFrameGame gameFrame) {
		this.gameFrame = gameFrame;
	}

	/**
	 *
	 * 初始化游戏配置
	 *
	 */
	public void startGamePanelInit() {
		for (Layer temp : this.lays) {
			// 刷新窗口UI
			temp.startPanel();
		}
	}
	private void addMusicPlayButton(JLayeredPane  panel) {
		musicPlay.addActionListener(new ActionListener() {
			int count = 0;
			boolean flag = true;
			MusicPlay music=new MusicPlay("images/music/bgm.wav");
			// 为按钮设置事件，即按下按钮的时候，播放音乐
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					music.play();
					// 播放时的图标
					musicPlay.setIcon(new ImageIcon("images/music/播放键3.png"));
					flag = false;
				} else {
					// 音乐直接停止，后续可能需要修改为可提供暂停方法的库
					music.over();
					musicPlay.setIcon(new ImageIcon("images/music/暂停键3.png"));
					flag = true;
				}
			} // 开启一个线程用来播放音乐
		});

		// 按钮默认的图标
		musicPlay.setIcon(new ImageIcon("images/music/暂停键3.png"));
		musicPlay.setBounds(200, 200, 80, 66);
		musicPlay.setContentAreaFilled(true);// 设置按钮透明
		musicPlay.setFont(new Font("粗体", Font.PLAIN, 15));// 按钮文本样式
		musicPlay.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
		panel.add(musicPlay);
	}


}
