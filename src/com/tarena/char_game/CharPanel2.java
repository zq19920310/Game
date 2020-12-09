package com.tarena.char_game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
public class CharPanel2  extends JPanel implements 
		Runnable,KeyListener{
	int num = 15;//ͬһ��������ĸ�ĸ���
	//�����漴��������ĸ
	CharVo cvs[] = new CharVo[num];
	int width,height;//�����Ŀ�͸�
	Random ran;
	int lineY = 570;//�¾����ߵ�y����
	int maxY = -1;//ƥ����ĸ����µ���ĸ��Ӧ��y����
	int maxIndex  = -1;//ƥ����ĸ����µ���ĸ��Ӧ���±�
	int rightNum = 0;//��ȷ�ĸ���
	int errorNum = 0;//����ĸ�����δ�ҵ�����©
	public CharPanel2(int width,int height){
		this.width = width-8;
		this.height = height - 35;
		ran = new Random();
		//ѭ��Ϊ�漴������ĸ��������Գ�ʼ��
		for(int i = 0;i<num;i++){
			cvs[i] = new CharVo();
			cvs[i].init(this.width, this.height, ran);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		//�����±߽���
		g.setColor(Color.RED);
		g.drawLine(5, lineY, this.width, lineY);
		g.drawString("right:"+rightNum, 5, 30);
		g.drawString("error:"+errorNum, 5, 55);
		if(errorNum>=20){
			g.drawString("Game Over!",this.width/2-50,
					this.height/2-30);
		}
		for(int i=0;i<num;i++){
			cvs[i].drawChar(g);
		}
	}
	public void run(){
		while(errorNum<20){
			for(int j =0;j<num;j++){
				if(cvs[j].getY()>lineY){
					cvs[j].init(width, ran, -36);
					errorNum++;
				}else{
					cvs[j].move();
				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if(errorNum<20){
			char ch = e.getKeyChar();
			for(int i = 0;i<num;i++){
				if(cvs[i].isCom(lineY)){
					if(cvs[i].equals(ch, false)){
						if(cvs[i].getY()>maxY){
							maxY = cvs[i].getY();
							maxIndex = i;
						}
					}
				}
			}
			if(maxIndex>-1){//�ҵ���
				cvs[maxIndex].init(width, ran, -36);
				//�޸���ȷ��
				rightNum++;
				maxIndex = -1;
				maxY = -1;
			}else{
				errorNum++;
			}
			repaint();
		}
	}
	public void keyTyped(KeyEvent e) {
	}
}




