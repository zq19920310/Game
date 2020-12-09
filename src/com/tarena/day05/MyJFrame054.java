package com.tarena.day05;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame054 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel054 panel  = new MyJPanel054(dim);
		frame.add(panel);
		panel.move();
		frame.setVisible(true);
	}
}
class MyJPanel054 extends JPanel{
	int x = 700;
	int y = 50;
	//定义两个int类型的数组xs,ys
	int xs[] = new int[300]; 
	int[] ys = new int[300];
	int rs[] = new int[300];
	Random random;
	public MyJPanel054(Dimension dim){
		random = new Random();
		//for循环为数组xs,ys进行逐一的赋值 
		for(int i=0;i<xs.length;i++){
			rs[i] = random.nextInt(6)+1;
			xs[i] = random.nextInt(dim.width-8-2*rs[i]);
			ys[i] = random.nextInt(dim.height-30-2*rs[i]);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.BLACK);
		//绘制白色的圆月
		g.setColor(Color.WHITE);
		g.fillOval(800, 150, 100, 100);
		//绘制黑色的圆月
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 100, 100);
		//循环绘制所有的星星
		g.setColor(Color.WHITE);
		Graphics2D gd = (Graphics2D)g;
		for(int i=0;i<xs.length;i++){
			gd.setStroke(new BasicStroke(rs[i]/3+1));
			gd.fillOval(xs[i]-rs[i], ys[i]-rs[i], 2*rs[i], 2*rs[i]);
			gd.drawLine(xs[i]-2*rs[i],ys[i], xs[i]+2*rs[i], ys[i]);
			gd.drawLine(xs[i], ys[i]-2*rs[i], xs[i], ys[i]+2*rs[i]);	
			int len = (int)Math.round(Math.sqrt(2)*rs[i]);
			gd.drawLine(xs[i]-len, ys[i]-len, xs[i]+len, ys[i]+len);
			gd.drawLine(xs[i]-len,ys[i]+len,xs[i]+len,ys[i]-len);
		}
	}
	public void move(){
		class MyThread extends Thread{
			public void run(){
				while(true){
					for(int i=0;i<xs.length;i++){
						rs[i] = random.nextInt(6)+1;
					}
					if(y>=251){
						x = 700;
						y = 50;
					}else{
						x++;
						y++;
					}
					try {
						Thread.sleep(100);
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




