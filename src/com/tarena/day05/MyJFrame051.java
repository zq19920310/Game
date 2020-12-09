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
		panel.move();//调用move方法
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
	public void move(){//局部内部类
		//1、继承Thread类
		//2、覆写父类中的run()
		class MyThread extends Thread{
			public void run(){//在线程进入到运行状态时执行的具体代码
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
					repaint();//重绘
				}
			}
		}
		//3、声明并实例化MyThread线程类的对象
		MyThread mt = new MyThread();
		//4、启动线程
		mt.start();
	}
	public void move1(){//局部内部类
		//1、继承Thread类
		//2、覆写父类中的run()
		class MyThread extends Thread{
			public void run(){//在线程进入到运行状态时执行的具体代码
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
					repaint();//重绘
				}
			}
		}
		//3、4、实例化MyThread线程类的对象，然后启动线程
		new MyThread().start();
	}
	public void move2(){//局部内部类
		//1、继承Thread类
		//2、覆写父类中的run()
		//3、4、实例化MyThread线程类的对象，然后启动线程
		new Thread(){
			public void run(){//在线程进入到运行状态时执行的具体代码
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
					repaint();//重绘
				}
			}
		}.start();
	}
}








