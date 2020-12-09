package com.tarena.day03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame032 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel032 panel = new MyJPanel032(dim);
		frame.add(panel);
		frame.setVisible(true);
	}
}
class MyJPanel032 extends JPanel{
	Dimension dim;
	/**���췽����
	 * ��������������ͬ��û�з���ֵ���ͣ�Ҳ��ʹ��void��
	 * 1��ʲôʱ�򱻵��ã�ʵ����ʱ������
	 * 2����һ���������û�ж����κι��췽���Ļ���Ĭ�ϴ���һ���޲εĹ��췽����
	 * 3�������һ�����У�ֻ������һ���вεĹ��췽������ôĬ�ϴ��ڵ��޲ι��췽��
	 * �����ڴ��ڡ��������ʹ���޲εĹ��췽������ô��Ҫ�Զ���һ���޲εĹ��췽����
	 * 4�����췽��֮�以�����ʱ��ʹ��this(�����б�);
	 * 	  �ڹ��췽���������ʱ��Ҫ�С����ڡ�,������ѭ����
	 * 5�����ã�a.���죨ʵ������һ���µĶ���
	 *        b.Ϊ��������Ը���ʼ����ֵ
	 */
	public MyJPanel032(){
	}
	public MyJPanel032(Dimension dim){
		this.dim = dim;
	}
	public MyJPanel032(Dimension dim,String str){
		//...
	}
	public void paint(Graphics g){
		//ͨ��super�ؼ��ֵ��ø����е�paint����
		super.paint(g);
		//ʹ��this�ؼ������ñ���ɫ
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		Random random = new Random();
		for(int i=0;i<300;i++){
			int x = random.nextInt(dim.width);
			int y = random.nextInt(dim.height);
			g.drawString("*", x, y);
		}
	}
}









