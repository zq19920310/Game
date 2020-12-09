package com.tarena.fish.day12;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Bullet {
	private int x;//��ת�������
	private int y;//��ת��������
	private Image img;//�ӵ���Ӧ��ͼƬ
	private int xx;//��תԭ���x����
	private int yy;//��תԭ���y����
	private double rotate;//�ӵ�����ת�Ƕ�
	//�����жϸ��ӵ��Ƿ��Ƴ�����
	private int reX;//��ת��ԭ���x����
	private int reY;//��ת��ԭ���y����
	//�Ƿ���������ƶ���true:��ʾ�ڻ����ڣ����������ƶ�
	//false����ʾ�Ƴ������������������ƶ�
	private boolean isMove = true;
	public void drawBullet(Graphics g){
		Graphics2D gd = (Graphics2D)g.create();
		gd.rotate(rotate, xx, yy);
		gd.drawImage(img, x, y, null);
	}
	public void move(){
		y -= 20;
		//�ӵ�����ֱ����ĸı���
		int cgY = (int)Math.round(Math.cos(rotate)*(yy-y));
		//������ת��ԭ���Ӧ������reY
		reY = yy - cgY;
		//�����ӵ���ˮƽ����ĸı��� sin=  cgX/(yy-y)
		int cgX = (int)Math.round(Math.sin(rotate)*(yy-y));
		//������ת��ԭ���Ӧ������reX
		reX = xx + cgX;
		//�жϸ��ӵ��Ƿ��Ƴ�����
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
