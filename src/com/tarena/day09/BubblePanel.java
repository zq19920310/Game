package com.tarena.day09;
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
	int x = 180;
	int y = 300;
	int r = 25;
	boolean isFire = false;//�Ƿ�ð��
	//1����������ð��������
	List<Bubble> ballList = new LinkedList<Bubble>();
	//A1�������������������
	List<Bubble> downBubList = new LinkedList<Bubble>();
	int width,height;
	Random random;
	public BubblePanel(int width,int height){
		this.width = width;
		this.height = height;
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
		g.fillOval(x, y, 2*r, 2*r);
		if(isFire){
			g.drawString("ð��", 10, 30);
		}else{
			g.drawString("ֹͣð��", 10, 30);
		}
		//2��ѭ���������е���������
		for(int i = 0;i<ballList.size();i++){
			/*Ball ball = ballList.get(i);
			ball.drawBall(g);*/
			ballList.get(i).drawBall(g);
		}
		//A4��ѭ�������������������
		for(int k = 0;k<downBubList.size();k++){
			downBubList.get(k).drawBall(g);
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
	public boolean isHit(Bubble b1,Bubble b2){
		//1�������������ݵİ뾶��
		int sumR = b1.getR() + b2.getR();
		//2������ƽ����X��ġ�ֱ�Ǳߡ��ġ����ȡ�
		int xxLen = b1.getX()+b1.getR()-
				(b2.getX()+b2.getR());
		//3������ƽ����Y��ġ�ֱ�Ǳߡ��ġ����ȡ�
		int yyLen = b1.getY()+b1.getR()-
				(b2.getY()+b2.getR());
		//4��������������Բ�ĵ�֮������ƽ��
		int cc = xxLen * xxLen +yyLen*yyLen;
		//5���ж��Ƿ�����ײ
		/*if(cc<=sumR*sumR){
			return true;
		}else{
			return false;
		}*/
		return cc<=sumR*sumR;
	}
	public void run() {
		int count =0;
		while(true){
			//���isFireΪtrue���򼯺������һ������
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
				//�õ�ǰ���л��������еġ��ӵ�������һ��ȥ�Ƚ��Ƿ�����ײ
				for(int n =0;n<ballList.size();n++){
					//����isHit����
					if(isHit(bub, ballList.get(n))){
						//�����ײ���л������١����ӵ�ɾ����������ǰѭ��
						bub.setY(-2*bub.getR());
						bub.setX(random.nextInt(width-8-2*bub.getR()));
						bub.setSpeed(random.nextInt(5)+1);
						ballList.remove(n);
						break;
					}
				}
				if(bub.getY()>=height){
					bub.setY(-2*bub.getR());
					bub.setX(random.nextInt(width)-28);
					bub.setSpeed(random.nextInt(5)+1);
				}else{
					bub.move();
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
