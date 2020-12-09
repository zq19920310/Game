package com.tarena.day04;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame043 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("下落的小球");
		frame.setBounds(260, 60, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel043 panel = new MyJPanel043();
		frame.add(panel);
		//新建一个线程对象：新生状态
		Thread thread = new Thread(panel);
		//启动线程：从新生状态-->就绪状态
		thread.start();
		frame.setVisible(true);
	}
}
/**实现多线程的两种方法：
 * 1、通过实现Runnable接口
 * 	a.使用关键字implements实现Runnable接口
 *  b.实现接口中的抽象方法
 *  c.声明并实例化Thread类的对象，在实例化时需要
 *  向Thread类调用的构造方法中传递Runnable接口实现类
 *  的对象
 *  d.调用该线程对象的start(),让该线程进入就绪状态。
 * 2、继承Thread类
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
			//重绘
			repaint();
		}
	}
}
