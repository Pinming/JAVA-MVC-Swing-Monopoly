package ui;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import util.FrameUtil;

public class WaitFrame extends JFrame {
    /**
     * 缩放 ImageIcon 对象
     *
     * @param image 原图 ImageIcon 对象
     * @param i     缩放倍数，double
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
        // 设置名字
        this.setTitle("BBZilionaire");
        // 设置默认关闭属性（程序结束）
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口大小
        this.setSize(500, 450);
        // 不允许用户改变窗口大小
        this.setResizable(false);
        // 居中
        FrameUtil.setFrameCenter(this);
        JLabel l = new JLabel();
        add(l);
        // 设置启动 Logo
        ImageIcon icon = new ImageIcon("images/logo.jpg");
        // 缩放启动 Logo
        ImageIcon icon2 = change(icon, 0.28);
        l.setIcon(icon2);
        setVisible(true);
        // 设置延迟时间
        Thread.sleep(3000);
    }
}


