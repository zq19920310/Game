package com.tarena.day05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame053 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel053 panel  = new MyJPanel053(dim);
		frame.add(panel);
		panel.move();
		frame.setVisible(true);
	}
}
class MyJPanel053 extends JPanel{
	int x = 700;
	int y = 50;
	//��������int���͵�����xs,ys
	int xs[] = new int[300]; 
	int[] ys = new int[300];
	Random random;
	public MyJPanel053(Dimension dim){
		random = new Random();
		//forѭ��Ϊ����xs,ys������һ�ĸ�ֵ 
		for(int i=0;i<xs.length;i++){
			xs[i] = random.nextInt(dim.width);
			ys[i] = random.nextInt(dim.height);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.BLACK);
		//���ư�ɫ��Բ��
		g.setColor(Color.WHITE);
		g.fillOval(800, 150, 100, 100);
		//���ƺ�ɫ��Բ��
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 100, 100);
		//ѭ���������е�����
		g.setColor(Color.WHITE);
		for(int i=0;i<xs.length;i++){
			g.drawString("*", xs[i], ys[i]);
		}
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




