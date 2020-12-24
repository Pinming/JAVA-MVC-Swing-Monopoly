package BBZillionaire.ui.massage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextArea;

import BBZillionaire.ui.JPanelGame;

public class MassageSimple extends Massage {

	
	private JTextArea textArea = null;
	
	
	private MassageButton cancel;


	public MassageSimple(String titile,String information,JPanelGame panel) {
		super(titile, panel);
		this.titileStr = titile;
		// ���Ӱ�ť
		addButtons();
		// �����ı���
		addTextArea();
	}


	public void setInfo(String titileStr) {
		this.textArea.setText(titileStr);
	}

	private void addButtons() {
		cancel = new MassageButton("cancel",this,18 * 8 + 64,131);
		add(cancel);
	}

	private void addTextArea() {
		textArea = new JTextArea();
		textArea.setText("���˸�ȥ����");
		textArea.setBounds(18, 39, 230, 50);
		textArea.setSelectedTextColor(Color.BLUE);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		add(textArea);
	}

	@Override
	public void paint(Graphics g) {
		paints(g);

		cancel.update(g);
		super.paint(g);
	}

	public void paints(Graphics g) {
		g.drawImage(bg, 0, 0, bg.getWidth(null), bg.getHeight(null), 0, 0,
				bg.getWidth(null), bg.getHeight(null), null);
	}

}
