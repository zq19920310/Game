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
	int num = 15;//同一窗体内字母的个数
	//保存随即产生的字母
	CharVo_bak04 chVos[] = new CharVo_bak04[num];
	int width,height;//画布的宽和高
	Random ran;
	int lineY = 570;//下警戒线的y坐标
	int maxY = -1;//匹配字母中最靠下的字母对应的y坐标
	int maxIndex  = -1;//匹配字母中最靠下的字母对应的下标
	int rightNum = 0;//正确的个数
	int errorNum = 0;//错误的个数：未找到和遗漏
	public CharPanel2_bak(int width,int height){
		this.width = width-8;
		this.height = height - 35;
		ran = new Random();
		//循环为随即产生字母的相关属性初始化
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
			if(maxIndex>-1){//找到了
				chVos[maxIndex].init(width, ran, -36);
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




