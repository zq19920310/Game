package com.tarena.day06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFrame062 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("多个小球反弹");
		int w = 1024;
		int h = 768;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-w)/2,(dim.height-h)/2,
				w, h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel062 panel = new MyJPanel062(w,h);
		frame.add(panel);
		Thread thread = new Thread(panel);
		thread.start();
		frame.setVisible(true);
	}
}
class MyJPanel062 extends JPanel implements Runnable{
	int num = 50;//小球的个数
	int xs[] = new int[num];
	int ys[] = new int[num];
	int rs[] = new int[num];
	int speeds[] = new int[num];//速度
	int dirs[] = new int[num];
	Color colors[] = new Color[num];
	public static final int RIGHT_DOWN = 0;
	public static final int LEFT_DOWN = 1;
	public static final int LEFT_UP = 2;
	public  static final int RIGHT_UP = 3;
	Random random;
	int width;
	int height;
	public MyJPanel062(int width,int height){
		this.width = width;
		this.height = height;
		random = new  Random();
		//循环为小球的属性赋值
		for(int i =0;i<num;i++){
			rs[i] = random.nextInt(11)+10;
			xs[i] = random.nextInt(width-8-2*rs[i]);
			ys[i] = random.nextInt(height-35-2*rs[i]);
			dirs[i] = random.nextInt(4);
			speeds[i] = random.nextInt(5)+1;
			colors[i] = new Color(random.nextInt(256),
					random.nextInt(256),random.nextInt(256));
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i =0;i<num;i++){
			g.setColor(colors[i]);
			g.fillOval(xs[i], ys[i], 2*rs[i], 2*rs[i]);
		}
	}
	public void run(){
		while(true){
			for(int i =0;i<num;i++){
				//根据方向改变坐标
				if(dirs[i]==RIGHT_DOWN){
					//xs[i] = xs[i] + speeds[i];
					xs[i] += speeds[i];
					ys[i] += speeds[i];
				}else if(dirs[i] == LEFT_DOWN){
					xs[i] -=speeds[i];
					ys[i] +=speeds[i];	
				}else if(dirs[i]==LEFT_UP){
					xs[i]-=speeds[i];
					ys[i]-=speeds[i];
				}else if(dirs[i] ==RIGHT_UP){
					xs[i] +=speeds[i];
					ys[i] -=speeds[i];
				}
				if(xs[i]<=0){
					if(dirs[i]==LEFT_DOWN){
						dirs[i] = RIGHT_DOWN;
					}else{
						dirs[i] = RIGHT_UP;
					}
				}
				if(ys[i]<=0){
					if(dirs[i]==RIGHT_UP){
						dirs[i] = RIGHT_DOWN;
					}else{
						dirs[i] = LEFT_DOWN;
					}
				}
				if(xs[i]>=width-8-2*rs[i]){
					if(dirs[i]==RIGHT_UP){
						dirs[i] = LEFT_UP;
					}else{
						dirs[i] = LEFT_DOWN;
					}
				}
				if(ys[i]>=height-35-2*rs[i]){
					if(dirs[i]==LEFT_DOWN){
						dirs[i] = LEFT_UP;
					}else{
						dirs[i] = RIGHT_UP;
					}
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













