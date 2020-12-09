package com.tarena.fish.day07;

import java.awt.Graphics;
import java.awt.Image;

public class Fish {
	private int road;//鱼移动的路线（方向）
	private int x;
	private int y;
	private int speed;//“速度”
	private int kind;//鱼的种类
	private Image imgs[];//正常游动时使用的图片
	private int index;//当前使用图片的下标（未被捕获的图片下标）
	private Image catchedImgs[];//被捕获的所有图片
	private int catchedIndex;//被捕获的鱼当前绘制图片对应的下标
	//是否被捕获到true：表示被捕获，false：表示未被捕获
	private boolean isCatched;
	public static final int LEFT_TO_RIGHT = 0;
	public static final int UP_TO_BUTTOM = 1;
	public static final int RIGHT_TO_LEFT = 2;
	/**绘制鱼的方法
	 * @param g：传递过来的画笔
	 */
	public void drawFish(Graphics g){
		if(isCatched){
			g.drawImage(catchedImgs[catchedIndex], x, y, null);
		}else{
			g.drawImage(imgs[index], x, y, null);
		}
	}
	public void move(){
		if(!isCatched){//未被捕获
			switch (road) {
				case LEFT_TO_RIGHT:
					x +=speed;
					break;
				case UP_TO_BUTTOM:
					y +=speed;
					break;
				case RIGHT_TO_LEFT:
					x -= speed;
					break;
				default:
					break;
			}
		}
		//addIndex();
	}
	public void addIndex(){
		if(isCatched){//被捕获
			if(kind>7){
				catchedIndex = (catchedIndex+1)%4;
			}else{
				catchedIndex = ++catchedIndex%2;
			}
		}else{//未被捕获
			index = ++index%10;
		}
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Image[] getImgs() {
		return imgs;
	}
	public void setImgs(Image[] imgs) {
		this.imgs = imgs;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Image[] getCatchedImgs() {
		return catchedImgs;
	}
	public void setCatchedImgs(Image[] catchedImgs) {
		this.catchedImgs = catchedImgs;
	}
	public int getCatchedIndex() {
		return catchedIndex;
	}
	public void setCatchedIndex(int catchedIndex) {
		this.catchedIndex = catchedIndex;
	}
	public boolean getIsCatched() {
		return isCatched;
	}
	public void setIsCatched(boolean isCatched) {
		this.isCatched = isCatched;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getRoad() {
		return road;
	}
	public void setRoad(int road) {
		this.road = road;
	}
	
	
}
