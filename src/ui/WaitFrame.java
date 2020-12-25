package ui;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import util.FrameUtil;

public class WaitFrame extends JFrame {
    /**
     * ���� ImageIcon ����
     *
     * @param image ԭͼ ImageIcon ����
     * @param i     ���ű�����double
     * @return
     */
    public ImageIcon change(ImageIcon image, double i) {
        int width = (int) (image.getIconWidth() * i);
        int height = (int) (image.getIconHeight() * i);
        Image img = image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(img);
        return image2;
    }

    public WaitFrame() throws InterruptedException {
        // ��������
        this.setTitle("BBZilionaire");
        // ����Ĭ�Ϲر����ԣ����������
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���ô��ڴ�С
        this.setSize(500, 450);
        // �������û��ı䴰�ڴ�С
        this.setResizable(false);
        // ����
        FrameUtil.setFrameCenter(this);
        JLabel l = new JLabel();
        add(l);
        // �������� Logo
        ImageIcon icon = new ImageIcon("images/logo.jpg");
        // �������� Logo
        ImageIcon icon2 = change(icon, 0.28);
        l.setIcon(icon2);
        setVisible(true);
        // �����ӳ�ʱ��
        Thread.sleep(3000);
    }
}


