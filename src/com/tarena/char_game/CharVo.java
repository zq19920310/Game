package com.tarena.char_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class CharVo {
	//属性
	private int x;
	private int y;
	private int speed;
	private char  ch;
	private Color color;
	private Font font;
	/**判断字母是否在“有效区域”
	 * @param lineY：下警戒线的y坐标
	 * @return：true:在有效区域中，false:不在有效区域中
	 */
	public boolean isCom(int lineY){
		return y>0&&y<lineY;
	}
	/**初始化字母
	 * @param width：画布的宽
	 * @param height：画布的高
	 * @param ran：Random类的对象，用来生产随机数
	 */
	public void init(int width,int height,Random ran){
		ch = (char)(ran.nextInt(26)+65);
		x = ran.nextInt(width-35);
		y = -ran.nextInt(height);
		speed = ran.nextInt(1)+1;
		color = new Color(ran.nextInt(256),ran.nextInt(256),
				ran.nextInt(256));
		font= new Font("宋体",Font.BOLD,ran.nextInt(16)+20);
	}
	/**初始化字母(遗漏或被消掉时，重新初始化)
	 * @param width：画布的宽
	 * @param ran：Random类的对象，用来生产随机数
	 * @param startY：指定该字母对应y的坐标
	 */
	public void init(int width,Random ran,int startY){
		ch = (char)(ran.nextInt(26)+65);
		x = ran.nextInt(width-35);
		y = startY;
		speed = ran.nextInt(1)+1;
		color = new Color(ran.nextInt(256),ran.nextInt(256),
				ran.nextInt(256));
		font= new Font("宋体",Font.BOLD,ran.nextInt(16)+20);
	}
	/**比较传递过来的字母和当前字母是否相同
	 * @param ch：传递过来的字母
	 * @param flag：是否区分大小写，true:区分，false不区分
	 * @return true:相同，false表示不同
	 */
	public boolean equals(char ch,boolean flag){
		if(flag){
			return this.ch ==ch;
		}else{
			return this.ch ==ch||this.ch ==ch-32
				||this.ch ==ch+32;
		}
		
	}
	public void drawChar(Graphics g){
		g.setColor(color);
		g.setFont(font);
		g.drawString(ch+"", x, y);
	}
	public  void move(){
		y +=  speed;
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
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
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
	
}
