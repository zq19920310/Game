package com.tarena.char_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class CharVo_bak04 {
	//属性
	private int x;
	private int y;
	private int speed;
	private Color color;
	private Font font;
	private char ch;
	public boolean equals(char ch){
		return this.ch==ch||ch==this.ch+32;
	}
	public void init(int width,int height,Random ran){
		ch= (char)(ran.nextInt(26)+65);
		x = ran.nextInt(width-35);
		y = -ran.nextInt(height);
		speed= ran.nextInt(1)+1;
		color= new Color(ran.nextInt(256),ran.nextInt(256),
				ran.nextInt(256));
		font= new Font("宋体",Font.BOLD,ran.nextInt(16)+20);
	}
	public void init(int width,Random ran,int startY){
		ch= (char)(ran.nextInt(26)+65);
		x = ran.nextInt(width-35);
		y = startY;
		speed= ran.nextInt(1)+1;
		color= new Color(ran.nextInt(256),ran.nextInt(256),
				ran.nextInt(256));
		font= new Font("宋体",Font.BOLD,ran.nextInt(16)+20);
	}
	public void drawChar(Graphics g){
		g.setFont(font);
		g.setColor(color);
		g.drawString(ch+"", x, y);
	}
	public  void move(){
		y +=speed;
	}
	public boolean isEquals(int lineY){
		return y>0&&y<lineY;
	}
	//getters和setters
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	
}
