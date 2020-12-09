package com.tarena.fish.day08;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class FishPanel  extends JPanel{
	Image bgImg;
	Image bgImg1;
	List<Fish> fishList;
	Random random;
	public FishPanel(){
		fishList = new LinkedList<Fish>();
		random = new Random();
		bgImg = new ImageIcon("image/bg2.png").getImage();
		bgImg1 = new ImageIcon("image/bg1.jpg").getImage();
		addFish();
	}
	public void addFish(){
		new Thread(){
			public void run(){
				while(true){
					Fish fish = new Fish();
					fish.setRoad(random.nextInt(3));
					int min = -305;
					int max = 125;
					fish.setKind(random.nextInt(11)+1);
					String path = "image/";
					switch(fish.getRoad()){
					case Fish.LEFT_TO_RIGHT:
						fish.setX(min);
						fish.setY(random.nextInt(480-max));
						path += "left_to_right/";
						break;
					case Fish.UP_TO_BUTTOM:
						fish.setX(random.nextInt(800-max));
						fish.setY(min);
						path +="up_to_buttom/";
						break;
					case Fish.RIGHT_TO_LEFT:
						fish.setX(800);
						fish.setY(random.nextInt(480-max));
						path+="right_to_left/";
						break;
					default: break;
					}
					Image imgs[] = new Image[10];
					for(int i = 0;i<imgs.length;i++){
						String imgPath = path+"fish";
						if(fish.getKind()<10){
							imgPath +="0"+fish.getKind()+"_";
						}else{
							imgPath+=fish.getKind()+"_";
						}
						/*imgPath+=fish.getKind()<10?"0"+fish.getKind()+"_":
							fish.getKind()+"_";*/
						if(i<9){
							imgPath +="0"+(i+1)+".png";
						}else{
							imgPath+=(i+1)+".png";
						}
						imgs[i] = new ImageIcon(imgPath).getImage();
					}
					fish.setImgs(imgs);
					Image catchedImg[];
					if(fish.getKind()<=7){
						catchedImg = new Image[2];
					}else{
						catchedImg = new Image[4];
					}
					for(int i=0;i<catchedImg.length;i++){
						String cPath = path+"fish";
						if(fish.getKind()<10){
							cPath +="0"+fish.getKind()+"_catch_0"+(i+1)+".png";
						}else{
							cPath+=fish.getKind()+"_catch_0"+(i+1)+".png";
						}
						catchedImg[i] = new ImageIcon(cPath).getImage();
					}
					fish.setCatchedImgs(catchedImg);
					switch (fish.getKind()) {
					case 1:case 2:case 5:
						fish.setSpeed(2);
						break;
					case 3:case 6:case 7:
						fish.setSpeed(4);
						break;
					case 4:case 8:case 11:
						fish.setSpeed(1);
						break;
					case 9:
						fish.setSpeed(5);
						break;
					case 10:
						fish.setSpeed(6);
						break;
					default:
						break;
					}
					fishList.add(fish);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bgImg, 0, 0, null);
		//绘制所有的鱼
		for(int i = 0;i<fishList.size();i++){
			fishList.get(i).drawFish(g);
		}
		g.drawImage(bgImg1, 10, 408, 780, 72,null);
	}
	//启动一个线程，让所有的鱼游动
	public void move(){
		new Thread(){
			public void run(){
				while(true){
					for(int i = 0;i<fishList.size();i++){
						Fish fish = fishList.get(i);
						if(fish.getRoad()==Fish.LEFT_TO_RIGHT){
							if(fish.getX()>=800){
								fishList.remove(fish);
							}else{
								fish.move();
							}
						}else if(fish.getRoad()==Fish.UP_TO_BUTTOM){
							if(fish.getY()>=480){
								fishList.remove(fish);
							}else{
								fish.move();
							}
						}else if(fish.getRoad()==Fish.RIGHT_TO_LEFT){
							if(fish.getX()<=-305){
								fishList.remove(fish);
							}else{
								fish.move();
							}
						}
					}
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}
			}
		}.start();
	}
	
}
