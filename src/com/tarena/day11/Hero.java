package com.tarena.day11;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class Hero {
	private int x;
	private int y;
	private int r;
	private int speed;
	private int allBlood;//总血量
	private int blood;//当前剩余的血量
	private int score;//得分
	private Color color;
	private boolean  isFire;//是否发射子弹
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, 2*r, 2*r);
		//绘制血条
		g.setColor(Color.YELLOW);
		g.fillRect(4, 34, allBlood+2, 20);
		g.setColor(Color.RED);
		g.fillRect(5, 35, blood, 18);
		//绘制得分
		g.setFont(new Font("宋体",Font.BOLD,25));
		g.drawString("score:"+score, 5, 25);
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAllBlood() {
		return allBlood;
	}
	public void setAllBlood(int allBlood) {
		this.allBlood = allBlood;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean getIsFire() {
		return isFire;
	}
	public void setIsFire(boolean isFire) {
		this.isFire = isFire;
	}
	
	
}
