package com.tarena.day04;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFrame041 {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("画卡通星星（圣诞快乐版）");
		Dimension dim = Toolkit.getDefaultToolkit().
				getScreenSize();
		frame.setBounds((dim.width-300)/2,(dim.height-400)/2,
				300, 400);
		//Ctrl+Shift+X:将小写变大写
		//Ctrl+Shift+Y:将大写变小写
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		MyJPanel041 	panel = new MyJPanel041();
		frame.add(panel);
		frame.setVisible(true);
	}
}
class MyJPanel041 extends JPanel{
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		//设置画笔粗细
		Graphics2D gd = (Graphics2D)g;
		//定义圆心点的坐标x,y,以及圆的半径r
		int x = 150;
		int y = 150;
		//int r = new Random().nextInt(10)+1;
		int r = 20;
		gd.setStroke(new BasicStroke(r/3));
		//绘制实心圆
		gd.fillOval(x-r, y-r, 2*r, 2*r);
		//绘制水平线
		gd.drawLine(x-2*r, y, x+2*r, y);
		//绘制平行于Y轴方向的直线
		gd.drawLine(x, y-2*r, x, y+2*r);
		//计算“直角边”的长度
		int len = (int)Math.round(Math.sqrt(2)*r);
		//绘制从左上到右下的直线
		gd.drawLine(x-len, y-len, x+len, y+len);
		//绘制从左下到右上的直线
		gd.drawLine(x-len, y+len, x+len, y-len);
	}
}







