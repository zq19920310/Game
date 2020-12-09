package com.tarena.day09;

import java.awt.Color;
import java.awt.Graphics;
//A2、添加一个移动方向的常量，并修改move方法
public class Bubble {
	//属性
	private int x;
	private int y;
	private int r;
	private Color color;
	private int speed;
	private int road;
	public static final  int UP = 0;
	public static final int LEFT_UP =1 ;
	public static final int RIHGT_UP = 2;
	public static final int DOWN = 3;
	public void drawBall(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, 2*r, 2*r);
	}
	public void move(){
		switch(road){
			case UP:
				y -= speed;
				break;
			case LEFT_UP:
				x-=speed;
				y-=speed;
				break;
			case RIHGT_UP:
				x+=speed;
				y-=speed;
				break;
			case DOWN:
				y+= speed;
				break;
			default:break;
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
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getRoad() {
		return road;
	}
	public void setRoad(int road) {
		this.road = road;
	}
}
