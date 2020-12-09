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
		frame.setTitle("����ͨ���ǣ�ʥ�����ְ棩");
		Dimension dim = Toolkit.getDefaultToolkit().
				getScreenSize();
		frame.setBounds((dim.width-300)/2,(dim.height-400)/2,
				300, 400);
		//Ctrl+Shift+X:��Сд���д
		//Ctrl+Shift+Y:����д��Сд
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
		//���û��ʴ�ϸ
		Graphics2D gd = (Graphics2D)g;
		//����Բ�ĵ������x,y,�Լ�Բ�İ뾶r
		int x = 150;
		int y = 150;
		//int r = new Random().nextInt(10)+1;
		int r = 20;
		gd.setStroke(new BasicStroke(r/3));
		//����ʵ��Բ
		gd.fillOval(x-r, y-r, 2*r, 2*r);
		//����ˮƽ��
		gd.drawLine(x-2*r, y, x+2*r, y);
		//����ƽ����Y�᷽���ֱ��
		gd.drawLine(x, y-2*r, x, y+2*r);
		//���㡰ֱ�Ǳߡ��ĳ���
		int len = (int)Math.round(Math.sqrt(2)*r);
		//���ƴ����ϵ����µ�ֱ��
		gd.drawLine(x-len, y-len, x+len, y+len);
		//���ƴ����µ����ϵ�ֱ��
		gd.drawLine(x-len, y+len, x+len, y-len);
	}
}







