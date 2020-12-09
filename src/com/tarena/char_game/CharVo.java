package com.tarena.char_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class CharVo {
	//����
	private int x;
	private int y;
	private int speed;
	private char  ch;
	private Color color;
	private Font font;
	/**�ж���ĸ�Ƿ��ڡ���Ч����
	 * @param lineY���¾����ߵ�y����
	 * @return��true:����Ч�����У�false:������Ч������
	 */
	public boolean isCom(int lineY){
		return y>0&&y<lineY;
	}
	/**��ʼ����ĸ
	 * @param width�������Ŀ�
	 * @param height�������ĸ�
	 * @param ran��Random��Ķ����������������
	 */
	public void init(int width,int height,Random ran){
		ch = (char)(ran.nextInt(26)+65);
		x = ran.nextInt(width-35);
		y = -ran.nextInt(height);
		speed = ran.nextInt(1)+1;
		color = new Color(ran.nextInt(256),ran.nextInt(256),
				ran.nextInt(256));
		font= new Font("����",Font.BOLD,ran.nextInt(16)+20);
	}
	/**��ʼ����ĸ(��©������ʱ�����³�ʼ��)
	 * @param width�������Ŀ�
	 * @param ran��Random��Ķ����������������
	 * @param startY��ָ������ĸ��Ӧy������
	 */
	public void init(int width,Random ran,int startY){
		ch = (char)(ran.nextInt(26)+65);
		x = ran.nextInt(width-35);
		y = startY;
		speed = ran.nextInt(1)+1;
		color = new Color(ran.nextInt(256),ran.nextInt(256),
				ran.nextInt(256));
		font= new Font("����",Font.BOLD,ran.nextInt(16)+20);
	}
	/**�Ƚϴ��ݹ�������ĸ�͵�ǰ��ĸ�Ƿ���ͬ
	 * @param ch�����ݹ�������ĸ
	 * @param flag���Ƿ����ִ�Сд��true:���֣�false������
	 * @return true:��ͬ��false��ʾ��ͬ
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
	//getters��setters
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
