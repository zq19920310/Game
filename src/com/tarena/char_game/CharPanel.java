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
	int num = 15;//同一窗体内字母的个数
	//保存随即产生的字母
	char chs[] = new char[num];
	int xs[] = new int[num];
	int ys[] = new int[num];
	int speeds[] = new int[num];
	Color colors[] = new Color[num];
	Font fonts[] = new Font[num];
	int width,height;//画布的宽和高
	Random ran;
	int lineY = 570;//下警戒线的y坐标
	int maxY = -1;//匹配字母中最靠下的字母对应的y坐标
	int maxIndex  = -1;//匹配字母中最靠下的字母对应的下标
	int rightNum = 0;//正确的个数
	int errorNum = 0;//错误的个数：未找到和遗漏
	public CharPanel(int width,int height){
		this.width = width-8;
		this.height = height - 35;
		ran = new Random();
		//循环为随即产生字母的相关属性初始化
		for(int i = 0;i<num;i++){
			chs[i] = (char)(ran.nextInt(26)+65);
			xs[i] = ran.nextInt(this.width-35);
			ys[i] = -ran.nextInt(this.height);
			speeds[i] = ran.nextInt(1)+1;
			colors[i] = new Color(ran.nextInt(256),ran.nextInt(256),
					ran.nextInt(256));
			fonts[i] = new Font("宋体",Font.BOLD,ran.nextInt(16)+20);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<num;i++){
			g.setColor(colors[i]);
			g.setFont(fonts[i]);
			g.drawString(chs[i]+"", xs[i], ys[i]);
		}
		//绘制下边界线
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
					fonts[j] = new Font("宋体",Font.BOLD,ran.nextInt(16)+20);
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
			if(maxIndex>-1){//找到了
				ys[maxIndex] = - 36;
				xs[maxIndex] = ran.nextInt(width-35);
				chs[maxIndex] = (char)(ran.nextInt(26)+65);
				speeds[maxIndex] = ran.nextInt(1)+1;
				colors[maxIndex] = new Color(ran.nextInt(256),ran.nextInt(256),
						ran.nextInt(256));
				fonts[maxIndex] = new Font("宋体",Font.BOLD,ran.nextInt(16)+20);
				//修改正确数
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




