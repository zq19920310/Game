package com.tarena.day11;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
public class BubblePanel  extends JPanel implements 
		MouseListener,MouseMotionListener,Runnable{
	Hero hero = new Hero();//"Ӣ�ۻ�"
	//1����������ð��������
	List<Bubble> ballList = new LinkedList<Bubble>();
	//A1�������������������
	List<Bubble> downBubList = new LinkedList<Bubble>();
	int width,height;
	Random random;
	public BubblePanel(int width,int height){
		this.width = width;
		this.height = height;
		hero.setX(180);
		hero.setY(300);
		hero.setR(25);
		hero.setAllBlood(100);
		hero.setBlood(100);
		hero.setColor(Color.GREEN);
		boolean isFire = false;//�Ƿ�ð��
		//A3��ѭ������20�����������
		random = new Random();
		for(int i = 0 ;i<20;i++){
			Bubble bub = new Bubble();
			bub.setRoad(Bubble.DOWN);
			bub.setR(10);
			bub.setY(random.nextInt(height-35));
			bub.setX(random.nextInt(width-28));
			bub.setSpeed(random.nextInt(5)+1);
			bub.setColor(Color.BLUE);
			downBubList.add(bub);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		//2��ѭ���������е���������
		for(int i = 0;i<ballList.size();i++){
			ballList.get(i).drawBall(g);
		}
		//A4��ѭ�������������������
		for(int k = 0;k<downBubList.size();k++){
			downBubList.get(k).drawBall(g);
		}
		//����Ӣ�ۻ��Լ��������
		hero.paint(g);
		if(hero.getBlood()<=0){
			g.drawString("Game Over", width/2-100, height/2-40);
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		hero.setIsFire(true);
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		hero.setIsFire(false);
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		if(hero.getBlood()>0){
			hero.setIsFire(true);
			hero.setX(e.getX()-hero.getR());
			hero.setY(e.getY()-hero.getR()-10);
			repaint();
		}
	}
	public void mouseMoved(MouseEvent e) {
		if(hero.getBlood()>0){
			hero.setIsFire(false);
			hero.setX(e.getX()-hero.getR());
			hero.setY(e.getY()-hero.getR()-10);
			repaint();
		}
	}
	
	public void run() {
		int count =0;
		while(hero.getBlood()>0){
			//���isFireΪtrue���򼯺������һ������
			if(hero.getIsFire()&&count%15==0){
				Bubble ball = new Bubble();
				ball.setSpeed(3);
				ball.setRoad(Bubble.UP);
				ball.setR(15);
				ball.setColor(Color.RED);
				ball.setY(hero.getY());
				ball.setX(hero.getX()+hero.getR()-ball.getR());
				ballList.add(ball);
				Bubble ball1 = new Bubble();
				ball1.setSpeed(3);
				ball1.setRoad(Bubble.LEFT_UP);
				ball1.setR(15);
				ball1.setColor(Color.RED);
				ball1.setY(hero.getY());
				ball1.setX(hero.getX()+hero.getR()-ball.getR()-10);
				ballList.add(ball1);
				Bubble ball2 = new Bubble();
				ball2.setSpeed(3);
				ball2.setRoad(Bubble.RIHGT_UP);
				ball2.setR(15);
				ball2.setColor(Color.RED);
				ball2.setY(hero.getY());
				ball2.setX(hero.getX()+hero.getR()-ball.getR()+10);
				ballList.add(ball2);
			}
			if(count>10000){
				count = 0;
			}else{
				count++;
			}
			//ѭ���ƶ����е���������
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
			//A5��ѭ���ƶ����е����������
			for(int m = 0;m<downBubList.size();m++){
				Bubble bub = downBubList.get(m);
				boolean isHit = false;
				//�õ�ǰ���л��������еġ��ӵ�������һ��ȥ�Ƚ��Ƿ�����ײ
				for(int n =0;n<ballList.size();n++){
					//����isHit����
					if(HitUtil.isHit(bub, ballList.get(n))){
						isHit = true;
						//�����ײ���л������١����ӵ�ɾ����������ǰѭ��
						bub.setY(-2*bub.getR());
						bub.setX(random.nextInt(width-8-2*bub.getR()));
						bub.setSpeed(random.nextInt(5)+1);
						ballList.remove(n);
						hero.setScore(hero.getScore()+10);
						break;
					}
				}
				if(!isHit&&HitUtil.isHit(hero, bub)){//����Ӣ�ۻ�
					bub.setY(-2*bub.getR());
					bub.setX(random.nextInt(width)-28);
					bub.setSpeed(random.nextInt(5)+1);
					hero.setBlood(hero.getBlood()-10);
				}else{
					if(bub.getY()>=height){
						bub.setY(-2*bub.getR());
						bub.setX(random.nextInt(width)-28);
						bub.setSpeed(random.nextInt(5)+1);
					}else{
						bub.move();
					}
				}
			}
			//����
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//�ػ�
			repaint();
		}
	}
}
