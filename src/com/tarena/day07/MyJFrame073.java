package com.tarena.day07;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame073 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("键盘控制小球的移动");
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-300)/2, (dim.height-400)/2, 300	, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel073 mp = new MyJPanel073();
		frame.add(mp);
		//3、打开任督二脉
		frame.addKeyListener(mp);
		frame.setVisible(true);
	}
}
//1使用关键字implements实现KeyListener接口
class 	MyJPanel073 extends JPanel implements KeyListener{
	int x = 100;
	int y = 200;
	boolean left;
	boolean up;
	boolean right;
	boolean down;
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 50, 50);
	}
	//2、实现接口中的抽象方法
	public void keyPressed(KeyEvent e) {
		//System.out.println("keyPressed");
		//判断按下的是神马键？
		/*System.out.println("e.getKeyChar()="+e.getKeyChar());
		System.out.println("e.getKeyCode()="+e.getKeyCode());
		System.out.println("e.getKeyLocation()="+e.getKeyLocation());*/
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			left= true;
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			up=true;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			right=true;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			down = true;
		}
		if(left){
			x-=3;
			if(up){
				y-=3;
			}
			if(down){
				y+=3;
			}
		}
		if(right){
			x+=3;
			if(up){
				y-=3;
			}
			if(down){
				y+=3;
			}
		}
		if(up){
			y-=3;
		}
		if(down){
			y+=3;
		}
		repaint();
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			left= false;
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			up=false;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			right=false;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			down = false;
		}
	}
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");
	}
	
}



