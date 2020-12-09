package com.tarena.char_game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
public class CharPanel2_bak  extends JPanel implements 
		Runnable,KeyListener{
	int num = 15;//ͬһ��������ĸ�ĸ���
	//�����漴��������ĸ
	CharVo_bak04 chVos[] = new CharVo_bak04[num];
	int width,height;//�����Ŀ�͸�
	Random ran;
	int lineY = 570;//�¾����ߵ�y����
	int maxY = -1;//ƥ����ĸ����µ���ĸ��Ӧ��y����
	int maxIndex  = -1;//ƥ����ĸ����µ���ĸ��Ӧ���±�
	int rightNum = 0;//��ȷ�ĸ���
	int errorNum = 0;//����ĸ�����δ�ҵ�����©
	public CharPanel2_bak(int width,int height){
		this.width = width-8;
		this.height = height - 35;
		ran = new Random();
		//ѭ��Ϊ�漴������ĸ��������Գ�ʼ��
		for(int i = 0;i<num;i++){
			chVos[i] = new CharVo_bak04();
			chVos[i].init(width, height, ran);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<num;i++){
			chVos[i].drawChar(g);
		}
		//�����±߽���
		g.setColor(Color.RED);
		g.drawLine(5, lineY, this.width, lineY);
		g.drawString("right:"+rightNum, 5, 30);
		g.drawString("error:"+errorNum, 5, 55);
		if(errorNum>=20){
			g.drawString("Game Over!",this.width/2-50,
					this.height/2-30);
		}
	}
	public void run(){
		while(errorNum<20){
			for(int j =0;j<num;j++){
				if(chVos[j].getY()>lineY){
					chVos[j].init(width, ran,-36);
					errorNum++;
				}else{
					chVos[j].move();
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
				if(chVos[i].isEquals(lineY)){
					if(chVos[i].equals(ch)){
						if(chVos[i].getY()>maxY){
							maxY = chVos[i].getY();
							maxIndex = i;
						}
					}
				}
			}
			if(maxIndex>-1){//�ҵ���
				chVos[maxIndex].init(width, ran, -36);
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




