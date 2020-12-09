package com.tarena.fish.day12;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Bullet {
	private int x;//旋转后横坐标
	private int y;//旋转后纵坐标
	private Image img;//子弹对应的图片
	private int xx;//旋转原点的x坐标
	private int yy;//旋转原点的y坐标
	private double rotate;//子弹的旋转角度
	//用来判断该子弹是否移出画布
	private int reX;//旋转还原后的x坐标
	private int reY;//旋转还原后的y坐标
	//是否可以正常移动，true:表示在画布内，可以正常移动
	//false：表示移出画布，不可以正常移动
	private boolean isMove = true;
	public void drawBullet(Graphics g){
		Graphics2D gd = (Graphics2D)g.create();
		gd.rotate(rotate, xx, yy);
		gd.drawImage(img, x, y, null);
	}
	public void move(){
		y -= 20;
		//子弹在竖直方向的改变量
		int cgY = (int)Math.round(Math.cos(rotate)*(yy-y));
		//计算旋转还原后对应的坐标reY
		reY = yy - cgY;
		//计算子弹在水平方向的改变量 sin=  cgX/(yy-y)
		int cgX = (int)Math.round(Math.sin(rotate)*(yy-y));
		//计算旋转还原后对应的坐标reX
		reX = xx + cgX;
		//判断该子弹是否移出画布
		if(reY<=-34||reX<=-20||reX>=800){
			isMove = false;
		}
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
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public int getXx() {
		return xx;
	}
	public void setXx(int xx) {
		this.xx = xx;
	}
	public int getYy() {
		return yy;
	}
	public void setYy(int yy) {
		this.yy = yy;
	}
	public double getRotate() {
		return rotate;
	}
	public void setRotate(double rotate) {
		this.rotate = rotate;
	}
	public int getReX() {
		return reX;
	}
	public void setReX(int reX) {
		this.reX = reX;
	}
	public int getReY() {
		return reY;
	}
	public void setReY(int reY) {
		this.reY = reY;
	}
	public boolean getIsMove() {
		return isMove;
	}
	public void setIsMove(boolean isMove) {
		this.isMove = isMove;
	}
	
	
	
	
}
