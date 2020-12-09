package com.tarena.day03;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame033 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setTitle("画卡通星星");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel033 panel = new MyJPanel033();
		frame.add(panel);
		frame.setVisible(true);
	}
}
class MyJPanel033 extends JPanel{
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		//1、定义变量，并赋值
		int x = 100;
		int y = 100;
		int r = 50;
	    Graphics2D gd = (Graphics2D)g;
	    //设置画笔的粗细
	    /*BasicStroke bs = new BasicStroke(10);
	    gd.setStroke(bs);*/
	    gd.setStroke(new BasicStroke(r/2));
		//2、绘制实心圆
		gd.fillOval(x, y, 2*r, 2*r);
		//3、绘制水平线
		gd.drawLine(x-r, y+r, x+3*r, y+r);
		//4、绘制垂直于水平线方向的直线
		gd.drawLine(x+r, y-r, x+r, y+3*r);
		//5、计算“直角边”的长度
		int len = (int)Math.round(Math.sqrt(2)*r);
		//6、绘制从左上到右下直线
		gd.drawLine(x+r-len, y+r-len, x+r+len, y+r+len);
		//7、绘制从左下到右上的直线
		gd.drawLine(x+r-len, y+r+len, x+r+len, y+r-len);
	}
}







