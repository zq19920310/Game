package com.tarena.fish.day07;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFrame071 {
	public static void main(String args[]){
		JFrame frame = new JFrame();
		frame.setTitle("游动的鱼");
		Dimension dim = Toolkit.getDefaultToolkit().
					getScreenSize();
		int w = 1000;
		int h = 700;
		frame.setBounds((dim.width-w)/2, (dim.height-h)/2, w, h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel071 panel = new MyJPanel071(w,h);
		frame.add(panel);
		panel.fishMove();
		frame.setVisible(true);
	}
}
class MyJPanel071 extends JPanel{
	Fish fish;
	int width,height;
	Random random;
	public MyJPanel071(int width,int height){
		this.width = width;
		this.height = height;
		fish = new Fish();
		random = new Random();
		fish.setRoad(Fish.LEFT_TO_RIGHT);
		fish.setX(-305);
		fish.setY(200);
		fish.setSpeed(3);
		fish.setKind(10);
		Image imgs[] = new Image[10];//未被捕获对应的图片
		Image catchedImgs[] = new Image[4];//被捕获对应的图片
		for(int i = 0;i<imgs.length;i++){
			if(i<9){
				imgs[i] = new ImageIcon("image/left_to_right/fish10_0"+
						(i+1)+".png").getImage();
			}else{
				imgs[i] = new ImageIcon("image/left_to_right/fish10_"+
						(i+1)+".png").getImage();
			}
		}
		for(int j=0;j<catchedImgs.length;j++){
			catchedImgs[j] = new ImageIcon("image/left_to_right/" +
					"fish10_catch_0"+(j+1)+".png").getImage();
		}
		fish.setImgs(imgs);
		fish.setCatchedImgs(catchedImgs);
	}
	public void paint(Graphics g){
		super.paint(g);
		fish.drawFish(g);
	}
	public void fishMove(){
		new Thread(){
			public void run(){
				int count =0;
				while(true){
					if(fish.getX()>=width-8){
						fish.setX(-305);
						fish.setY(random.nextInt(height-35-125));
					}else{
						fish.move();
						if(count%5==0){
							fish.addIndex();
						}
					}
					count++;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}
			}
		}.start();
	}
}






