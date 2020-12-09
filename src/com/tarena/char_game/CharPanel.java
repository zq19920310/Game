package com.tarena.char_game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
public class CharPanel  extends JPanel implements 
		Runnable,KeyListener{
	int num = 15;//ͬһ��������ĸ�ĸ���
	//�����漴��������ĸ
	char chs[] = new char[num];
	int xs[] = new int[num];
	int ys[] = new int[num];
	int speeds[] = new int[num];
	Color colors[] = new Color[num];
	Font fonts[] = new Font[num];
	int width,height;//�����Ŀ�͸�
	Random ran;
	int lineY = 570;//�¾����ߵ�y����
	int maxY = -1;//ƥ����ĸ����µ���ĸ��Ӧ��y����
	int maxIndex  = -1;//ƥ����ĸ����µ���ĸ��Ӧ���±�
	int rightNum = 0;//��ȷ�ĸ���
	int errorNum = 0;//����ĸ�����δ�ҵ�����©
	public CharPanel(int width,int height){
		this.width = width-8;
		this.height = height - 35;
		ran = new Random();
		//ѭ��Ϊ�漴������ĸ��������Գ�ʼ��
		for(int i = 0;i<num;i++){
			chs[i] = (char)(ran.nextInt(26)+65);
			xs[i] = ran.nextInt(this.width-35);
			ys[i] = -ran.nextInt(this.height);
			speeds[i] = ran.nextInt(1)+1;
			colors[i] = new Color(ran.nextInt(256),ran.nextInt(256),
					ran.nextInt(256));
			fonts[i] = new Font("����",Font.BOLD,ran.nextInt(16)+20);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<num;i++){
			g.setColor(colors[i]);
			g.setFont(fonts[i]);
			g.drawString(chs[i]+"", xs[i], ys[i]);
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
				if(ys[j]>lineY){
					ys[j] = - 36;
					xs[j] = ran.nextInt(width-35);
					chs[j] = (char)(ran.nextInt(26)+65);
					speeds[j] = ran.nextInt(1)+1;
					colors[j] = new Color(ran.nextInt(256),ran.nextInt(256),
							ran.nextInt(256));
					fonts[j] = new Font("����",Font.BOLD,ran.nextInt(16)+20);
					errorNum++;
				}else{
					ys[j] += speeds[j];
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
				if(ys[i]>0&&ys[i]<lineY){
					if(ch==chs[i]||ch==chs[i]+32){
						if(ys[i]>maxY){
							maxY = ys[i];
							maxIndex = i;
						}
					}
				}
			}
			if(maxIndex>-1){//�ҵ���
				ys[maxIndex] = - 36;
				xs[maxIndex] = ran.nextInt(width-35);
				chs[maxIndex] = (char)(ran.nextInt(26)+65);
				speeds[maxIndex] = ran.nextInt(1)+1;
				colors[maxIndex] = new Color(ran.nextInt(256),ran.nextInt(256),
						ran.nextInt(256));
				fonts[maxIndex] = new Font("����",Font.BOLD,ran.nextInt(16)+20);
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




