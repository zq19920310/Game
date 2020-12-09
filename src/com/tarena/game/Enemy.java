package com.tarena.game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemy {
	private int x;
	private int y;
	private int width;
	private int height;
	private Image image;
	//�ٶ�
	private int speed;
	//�ƶ��ķ���
	private int direction;
	private JPanel panel;
	//��ըͼƬ����
	private Image[] deadImages={
			 new ImageIcon("img/bomb_1.png").getImage(),
			 new ImageIcon("img/bomb_2.png").getImage(),
			 new ImageIcon("img/bomb_3.png").getImage()};
	//����
	private String type;//L ��ʾ�л�������D��ʾ������
	//���弸����������ʾ�ƶ��ľ��巽��
	public static final int UP=0;
	public static final int DOWN=1;
		
	//�������ݵķ���
	public void draw(Graphics g){
		if("L".equals(type)){
			g.drawImage(image,x, y, width,height,panel);
		}else if("D".equals(type)){
			//ȡ����ըЧ��
			//g.drawImage(deadImages[new Random().nextInt(3)],x, y, width,height,panel);
		}
	}
	//�ƶ��ķ���
	public void move(){
		switch (direction) {
		case UP:
			y=y-speed;
			break;
		case DOWN:
			y = y+speed;
			break;
		default:
			break;
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
