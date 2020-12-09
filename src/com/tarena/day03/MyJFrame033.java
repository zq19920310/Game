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
		frame.setTitle("����ͨ����");
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
		//1���������������ֵ
		int x = 100;
		int y = 100;
		int r = 50;
	    Graphics2D gd = (Graphics2D)g;
	    //���û��ʵĴ�ϸ
	    /*BasicStroke bs = new BasicStroke(10);
	    gd.setStroke(bs);*/
	    gd.setStroke(new BasicStroke(r/2));
		//2������ʵ��Բ
		gd.fillOval(x, y, 2*r, 2*r);
		//3������ˮƽ��
		gd.drawLine(x-r, y+r, x+3*r, y+r);
		//4�����ƴ�ֱ��ˮƽ�߷����ֱ��
		gd.drawLine(x+r, y-r, x+r, y+3*r);
		//5�����㡰ֱ�Ǳߡ��ĳ���
		int len = (int)Math.round(Math.sqrt(2)*r);
		//6�����ƴ����ϵ�����ֱ��
		gd.drawLine(x+r-len, y+r-len, x+r+len, y+r+len);
		//7�����ƴ����µ����ϵ�ֱ��
		gd.drawLine(x+r-len, y+r+len, x+r+len, y+r-len);
	}
}







