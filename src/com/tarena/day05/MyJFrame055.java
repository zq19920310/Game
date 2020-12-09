package com.tarena.day05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame055 {
	public static void main(String[] args) {
		JFrame frame= new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel055 panel = new MyJPanel055(dim);
		frame.add(panel);
		frame.setTitle("2014年的最后一场雪");
		Thread thread = new Thread(panel);
		thread.start();
		frame.setVisible(true);
	}
}
class MyJPanel055 extends JPanel implements Runnable{
	int xs[] = new int[300];
	int ys[] = new int[300];
	Random random;
	Dimension dim;
	public MyJPanel055(Dimension  dim){
		this.dim = dim;
		random = new Random();
		for(int i = 0;i<xs.length;i++){
			xs[i] = random.nextInt(dim.width-8);
			ys[i] = random.nextInt(dim.height-30);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		for(int j=0;j<xs.length;j++){
			g.drawString("*", xs[j], ys[j]);
		}
	}
	public void run(){
		while(true){
			for(int i= 0;i<ys.length;i++){
				if(ys[i]>dim.height-30){
					ys[i] = -5;
					xs[i] = random.nextInt(dim.width-8);
				}else{
					ys[i] ++;
				}
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










