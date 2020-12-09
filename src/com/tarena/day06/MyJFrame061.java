package com.tarena.day06;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame061 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("������С��");
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
	int x = 150;//С���x����
	int y =180;//С���y����
	int r = 25;//С��İ뾶
	int width;//����Ŀ�
	int height;//����ĸ�
	public static final int RIGHT_DOWN = 0;
	public static final int LEFT_DOWN = 1;
	public static final int LEFT_UP = 2;
	public static final int RIGHT_UP = 3;
	int dir = RIGHT_UP;//С���ƶ��ķ��� 0:����,1������,2������,3������
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
			//���ݷ���ı�С�������
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
			//�ж��Ƿ���ײ��4���߽磬��ײ�߽��ı䷽��
			if(x<=0){//���߽�
				if(dir==LEFT_DOWN){
					dir = RIGHT_DOWN;
				}else{
					dir = RIGHT_UP;
				}
			}
			if(y<=0){//�ϱ߽�
				if(dir==RIGHT_UP){
					dir = RIGHT_DOWN;
				}else{
					dir = LEFT_DOWN;
				}
			}
			if(x>=width-2*r-8){//�ұ߽�
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





