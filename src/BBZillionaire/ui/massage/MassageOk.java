package BBZillionaire.ui.massage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextArea;

import BBZillionaire.ui.JPanelGame;

public class MassageOk extends Massage {

	
	private JTextArea textArea = null;

	private MassageButton ok;
	

	public MassageOk(String titile, String information, JPanelGame panel) {
		super(titile, panel);
		this.titileStr = titile;
		// ���Ӱ�ť
		addButtons();
		// �����ı���
		addTextArea();
		this.textArea.setText(information);
	}

	public void setInfo(String titileStr) {
		this.textArea.setText(titileStr);
		this.titile.setText("<html><font color='white' >"+titileStr+"</font></html>");
	}
	
	private void addButtons() {
		ok = new MassageButton("ok",this, 18 * 6, 131);
		add(ok);
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

		ok.update(g);
		super.paint(g);
	}

	public void paints(Graphics g) {
		g.drawImage(bg, 0, 0, bg.getWidth(null), bg.getHeight(null), 0, 0,
				bg.getWidth(null), bg.getHeight(null), null);
	}

}
