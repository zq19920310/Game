package com.tarena.day05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame052 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel052 panel  = new MyJPanel052();
		frame.add(panel);
		panel.move();
		frame.setVisible(true);
	}
}
class MyJPanel052 extends JPanel{
	int x = 700;
	int y = 50;
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.BLACK);
		//绘制白色的圆月
		g.setColor(Color.WHITE);
		g.fillOval(800, 150, 100, 100);
		//绘制黑色的圆月
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 100, 100);
	}
	public void move(){
		class MyThread extends Thread{
			public void run(){
				while(true){
					if(y>=251){
						x = 700;
						y = 50;
					}else{
						x++;
						y++;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}
			}
		}
		MyThread mt = new MyThread();
		mt.start();
	}
	public void move1(){
		new Thread(){
			public void run(){
				while(true){
					if(y>=251){
						x = 700;
						y = 50;
					}else{
						x++;
						y++;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}
			}
		}.start();
	}
}




