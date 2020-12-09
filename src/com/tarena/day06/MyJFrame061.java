package com.tarena.day06;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame061 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("反弹的小球");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = 300;
		int h = 400;
		frame.setBounds((dim.width-w)/2,(dim.height-h)/2,
				300, 400);
		MyJPanel061 panel = new MyJPanel061(w,h);
		frame.add(panel);
		Thread thread = new Thread(panel);
		thread.start();
		frame.setVisible(true);
	}
}
class MyJPanel061 extends JPanel implements Runnable{
	int x = 150;//小球的x坐标
	int y =180;//小球的y坐标
	int r = 25;//小球的半径
	int width;//窗体的宽
	int height;//窗体的高
	public static final int RIGHT_DOWN = 0;
	public static final int LEFT_DOWN = 1;
	public static final int LEFT_UP = 2;
	public static final int RIGHT_UP = 3;
	int dir = RIGHT_UP;//小球移动的方向 0:右下,1：左下,2：左上,3：右上
	public MyJPanel061(int width,int height){
		this.width = width;
		this.height = height;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 2*r, 2*r);
	}
	public void run(){
		while(true){
			//根据方向改变小球的坐标
			if(dir ==RIGHT_DOWN){
				x++;
				y++;
			}else if(dir == LEFT_DOWN){
				x--;
				y++;
			}else if(dir == LEFT_UP){
				x--;
				y--;
			}else if(dir == RIGHT_UP){
				x++;
				y--;
			}
			//判断是否碰撞到4个边界，碰撞边界后改变方向
			if(x<=0){//左侧边界
				if(dir==LEFT_DOWN){
					dir = RIGHT_DOWN;
				}else{
					dir = RIGHT_UP;
				}
			}
			if(y<=0){//上边界
				if(dir==RIGHT_UP){
					dir = RIGHT_DOWN;
				}else{
					dir = LEFT_DOWN;
				}
			}
			if(x>=width-2*r-8){//右边界
				if(dir==RIGHT_DOWN){
					dir = LEFT_DOWN;
				}else{
					dir = LEFT_UP;
				}
			}
			if(y>=height-35-2*r){
				if(dir==LEFT_DOWN){
					dir = LEFT_UP;
				}else{
					dir = RIGHT_UP;
				}
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
}





