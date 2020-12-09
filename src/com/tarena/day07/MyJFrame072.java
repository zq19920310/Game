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
		frame.setTitle("������С����ƶ�");
		frame.setUndecorated(true);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width-300)/2, (dim.height-400)/2, 300	, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel072 mp = new MyJPanel072();
		frame.add(mp);
		//3�����ζ�����
		frame.addKeyListener(mp);
		frame.addMouseMotionListener(mp);
		frame.addMouseListener(mp);
		frame.setVisible(true);
	}
}
//1ʹ�ùؼ���implementsʵ��KeyListener�ӿ�
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
	//2��ʵ�ֽӿ��еĳ��󷽷�
	public void keyPressed(KeyEvent e) {
		//System.out.println("keyPressed");
		//�жϰ��µ����������
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
	}//��갴��������ϰ��²��϶�ʱ����
	public void mouseDragged(MouseEvent e) {
		color = Color.GREEN;
		//System.out.println("("+e.getX()+","+e.getY()+")");
		//System.out.println("("+e.getPoint().getX()+","+e.getPoint().getY()+")");
		x = e.getX();
		y = e.getY();
		repaint();
	}//������ƶ�������ϵ��ް�������ʱ���á�
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



