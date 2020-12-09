package com.tarena.day04;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame043 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("�����С��");
		frame.setBounds(260, 60, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel043 panel = new MyJPanel043();
		frame.add(panel);
		//�½�һ���̶߳�������״̬
		Thread thread = new Thread(panel);
		//�����̣߳�������״̬-->����״̬
		thread.start();
		frame.setVisible(true);
	}
}
/**ʵ�ֶ��̵߳����ַ�����
 * 1��ͨ��ʵ��Runnable�ӿ�
 * 	a.ʹ�ùؼ���implementsʵ��Runnable�ӿ�
 *  b.ʵ�ֽӿ��еĳ��󷽷�
 *  c.������ʵ����Thread��Ķ�����ʵ����ʱ��Ҫ
 *  ��Thread����õĹ��췽���д���Runnable�ӿ�ʵ����
 *  �Ķ���
 *  d.���ø��̶߳����start(),�ø��߳̽������״̬��
 * 2���̳�Thread��
 */
class MyJPanel043 extends JPanel implements Runnable{
	int y = 100;
	public void paint(Graphics g){
		super.paint(g);
		//g.clearRect(0,0,300, 400);
		g.fillOval(100, y, 50, 50);
	}
	public void run() {
		while(true){
			if(y>=400){
				y=-50;
			}else{
				y++;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//�ػ�
			repaint();
		}
	}
}
