package com.tarena.day04;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame042 {
	public static void main(String args[]){
		JFrame frame = new JFrame();
		frame.setTitle("»æÖÆÍ¼Æ¬");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-430)/2,(dim.height-640)/2,
				430, 640);
		frame.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
		MyJPanel042 panel = new MyJPanel042();
		frame.add(panel);
		frame.setVisible(true);
	}
}
class MyJPanel042 extends JPanel{
	public void paint(Graphics g){
		try {
			Image bgImg2  =  ImageIO.read(new File("img/bg2.jpg"));
			g.drawImage(bgImg2, 0, 0, 430, 640, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//»æÖÆ±³¾°Í¼
		Image bgImg = new ImageIcon("img/bg1.jpg").getImage();
		//g.drawImage(bgImg, 0, 0, 430, 640, null);
		//»æÖÆµÐ»ú
		Image epImg1 = new ImageIcon("img/ep01.png").getImage();
		g.drawImage(epImg1, 10, 30, null);
		g.drawImage(epImg1, 280, 200, null);
		Image epImg2 = new ImageIcon("img/ep02.png").getImage();
		g.drawImage(epImg2, 100, 140, null);
		Image epImg3  = new ImageIcon("img/ep13.png").getImage();
		g.drawImage(epImg3, 50, 200, null);
		//»æÖÆ×Óµ¯
		Image fireImg = new ImageIcon("img/fire.png").getImage();
		g.drawImage(fireImg, 235, 347,fireImg.getWidth(null)/2,
				fireImg.getHeight(null)/2, null);
		g.drawImage(fireImg, 235, 247,fireImg.getWidth(null)/2,
				fireImg.getHeight(null)/2, null);

		//»æÖÆÓ¢ÐÛ»ú
		ImageIcon imgIcon = new ImageIcon("img/hero.png");
		Image img =imgIcon.getImage();
		g.drawImage(img, 200, 450, null);
	}
}




