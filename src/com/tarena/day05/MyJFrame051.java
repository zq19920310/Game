package com.tarena.day05;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFrame051 {
	public static void main(String args[]){
		JFrame frame = new JFrame();
		frame.setBounds(260, 80, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel051 panel = new MyJPanel051();
		frame.add(panel);
		panel.move();//����move����
		frame.setVisible(true);
	}
}
class MyJPanel051 extends JPanel{
	int x = 100;
	int y =100;
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 50, 50);
	}
	public void move(){//�ֲ��ڲ���
		//1���̳�Thread��
		//2����д�����е�run()
		class MyThread extends Thread{
			public void run(){//���߳̽��뵽����״̬ʱִ�еľ������
				while(true){
					if(y>=220){
						x = 100;
						y = 100;
					}else{
						x++;
						y++;
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();//�ػ�
				}
			}
		}
		//3��������ʵ����MyThread�߳���Ķ���
		MyThread mt = new MyThread();
		//4�������߳�
		mt.start();
	}
	public void move1(){//�ֲ��ڲ���
		//1���̳�Thread��
		//2����д�����е�run()
		class MyThread extends Thread{
			public void run(){//���߳̽��뵽����״̬ʱִ�еľ������
				while(true){
					if(y>=220){
						x = 100;
						y = 100;
					}else{
						x++;
						y++;
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();//�ػ�
				}
			}
		}
		//3��4��ʵ����MyThread�߳���Ķ���Ȼ�������߳�
		new MyThread().start();
	}
	public void move2(){//�ֲ��ڲ���
		//1���̳�Thread��
		//2����д�����е�run()
		//3��4��ʵ����MyThread�߳���Ķ���Ȼ�������߳�
		new Thread(){
			public void run(){//���߳̽��뵽����״̬ʱִ�еľ������
				while(true){
					if(y>=220){
						x = 100;
						y = 100;
					}else{
						x++;
						y++;
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();//�ػ�
				}
			}
		}.start();
	}
}








