package com.tarena.day09;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
public class MyJPanel091  extends JPanel implements 
		MouseListener,MouseMotionListener,Runnable{
	int x = 180;
	int y = 300;
	int r = 25;
	boolean isFire = false;//是否冒泡
	//1、保存所有冒出的泡泡
	List<Bubble> ballList = new LinkedList<Bubble>();
	int width,height;
	public MyJPanel091(int width,int height){
		this.width = width;
		this.height = height;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 2*r, 2*r);
		if(isFire){
			g.drawString("冒泡", 10, 30);
		}else{
			g.drawString("停止冒泡", 10, 30);
		}
		//2、循环绘制所有的泡泡
		for(int i = 0;i<ballList.size();i++){
			/*Ball ball = ballList.get(i);
			ball.drawBall(g);*/
			ballList.get(i).drawBall(g);
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		isFire = true;
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		isFire = false;
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		isFire = true;
		x = e.getX()-r;
		y = e.getY()-r-10;
		repaint();
	}
	public void mouseMoved(MouseEvent e) {
		isFire = false;
		x = e.getX()-r;
		y = e.getY()-r-10;
		repaint();
	}
	public void run() {
		int count =0;
		while(true){
			//如果isFire为true，向集合中添加一个泡泡
			if(isFire&&count%15==0){
				Bubble ball = new Bubble();
				ball.setSpeed(3);
				ball.setRoad(Bubble.UP);
				ball.setR(15);
				ball.setColor(Color.RED);
				ball.setY(y);
				ball.setX(x+r-ball.getR());
				ballList.add(ball);
				Bubble ball1 = new Bubble();
				ball1.setSpeed(3);
				ball1.setRoad(Bubble.LEFT_UP);
				ball1.setR(15);
				ball1.setColor(Color.RED);
				ball1.setY(y);
				ball1.setX(x+r-ball.getR()-10);
				ballList.add(ball1);
				Bubble ball2 = new Bubble();
				ball2.setSpeed(3);
				ball2.setRoad(Bubble.RIHGT_UP);
				ball2.setR(15);
				ball2.setColor(Color.RED);
				ball2.setY(y);
				ball2.setX(x+r-ball.getR()+10);
				ballList.add(ball2);
			}
			count++;
			//循环移动所有的泡泡
			for(int i = 0;i<ballList.size();i++){
				Bubble ball = ballList.get(i);
				if(ball.getRoad()==Bubble.UP){
					if(ball.getY()<-2*ball.getR()){
						ballList.remove(ball);
						i--;
					}else{
						ball.move();
					}
				}else if(ball.getRoad()==Bubble.LEFT_UP){
					if(ball.getX()<=-2*ball.getR()||ball.getY()<=-2*ball.getR()){
						ballList.remove(ball);
						i--;
					}else{
						ball.move();
					}
				}else if(ball.getRoad()==Bubble.RIHGT_UP){
					if(ball.getX()>=width||ball.getY()<=-2*ball.getR()){
						ballList.remove(ball);
						i--;
					}else{
						ball.move();
					}
				}
			}
			//休眠
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//重绘
			repaint();
		}
	}
}
