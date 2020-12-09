package com.tarena.day06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFrame063 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("多个小球反弹");
		int w = 1024;
		int h = 768;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-w)/2,(dim.height-h)/2,
				w, h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel063 panel = new MyJPanel063(w,h);
		frame.add(panel);
		Thread thread = new Thread(panel);
		thread.start();
		frame.setVisible(true);
	}
}
class MyJPanel063 extends JPanel implements Runnable{
	Ball balls[] = new Ball[50];
	Random random;
	int width;
	int height;
	public MyJPanel063(int width,int height){
		this.width = width;
		this.height = height;
		random = new  Random();
		//循环为小球的属性赋值
		for(int i =0;i<balls.length;i++){
			balls[i] = new Ball();
			balls[i].setR(random.nextInt(11)+10);
			balls[i].setX(random.nextInt(width-8-2*balls[i].getR()));
			balls[i].setY(random.nextInt(height-35-2*balls[i].getR()));
			balls[i].setDir(random.nextInt(4));
			balls[i].setSpeed(random.nextInt(5)+1);
			balls[i].setColor(new Color(random.nextInt(256),
					random.nextInt(256),random.nextInt(256)));
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i =0;i<balls.length;i++){
			balls[i].paint(g);
		}
	}
	public void run(){
		while(true){
			for(int i =0;i<balls.length;i++){
				balls[i].move(width, height);
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













