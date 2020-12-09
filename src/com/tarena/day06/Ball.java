package com.tarena.day06;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Administrator
 *
 */
public class Ball {
	private int x;
	private int y;
	private int r;
	private int speed;
	private int dir;
	private Color color;
	public static final int RIGHT_DOWN = 0;
	public static final int LEFT_DOWN = 1;
	public static final int LEFT_UP = 2;
	public static final int RIGHT_UP = 3;
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, 2*r, 2*r);
	}
	public void move(int width,int height){
		//根据方向改变小球的坐标
		if(dir ==RIGHT_DOWN){
			x+=speed;
			y+=speed;
		}else if(dir == LEFT_DOWN){
			x-=speed;
			y+=speed;
		}else if(dir == LEFT_UP){
			x-=speed;
			y-=speed;
		}else if(dir == RIGHT_UP){
			x+=speed;
			y-=speed;
		}
		//判断是否碰撞到4个边界，碰撞边界后改变方向
		if(x<=0){//左侧边界
			if(dir==LEFT_DOWN){
				dir = RIGHT_DOWN;
			}else{
				dir = RIGHT_UP;
			}
		}
		if(y<=0){//上边界
			if(dir==RIGHT_UP){
				dir = RIGHT_DOWN;
			}else{
				dir = LEFT_DOWN;
			}
		}
		if(x>=width-2*r-8){//右边界
			if(dir==RIGHT_DOWN){
				dir = LEFT_DOWN;
			}else{
				dir = LEFT_UP;
			}
		}
		if(y>=height-35-2*r){
			if(dir==LEFT_DOWN){
				dir = LEFT_UP;
			}else{
				dir = RIGHT_UP;
			}
		}
	}
	//Alt+Shift+S->R->Select All(选择对应的属性)->OK
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
