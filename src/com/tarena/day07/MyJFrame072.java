package com.tarena.day07;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyJFrame072 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("鼠标控制小球的移动");
		frame.setUndecorated(true);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-300)/2, (dim.height-400)/2, 300	, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel072 mp = new MyJPanel072();
		frame.add(mp);
		//3、打开任督二脉
		frame.addKeyListener(mp);
		frame.addMouseMotionListener(mp);
		frame.addMouseListener(mp);
		frame.setVisible(true);
	}
}
//1使用关键字implements实现KeyListener接口
class 	MyJPanel072 extends JPanel implements KeyListener,
				MouseMotionListener,MouseListener{//
	int x = 100;
	int y = 200;
	Color color  = Color.BLACK;
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(color);
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
			x-=3;
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			y-=3;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x+=3;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y+=3;
		}
		repaint();
	}
	public void keyReleased(KeyEvent e) {
		//System.out.println("keyReleased");
	}
	public void keyTyped(KeyEvent e) {
		//System.out.println("keyTyped");
	}//鼠标按键在组件上按下并拖动时调用
	public void mouseDragged(MouseEvent e) {
		color = Color.GREEN;
		//System.out.println("("+e.getX()+","+e.getY()+")");
		//System.out.println("("+e.getPoint().getX()+","+e.getPoint().getY()+")");
		x = e.getX();
		y = e.getY();
		repaint();
	}//鼠标光标移动到组件上但无按键按下时调用。
	public void mouseMoved(MouseEvent e) {
		color = Color.RED;
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		color = Color.BLACK;
		repaint();
	}
	
}



