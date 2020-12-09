package com.tarena.fish.day07;

import java.awt.Graphics;
import java.awt.Image;

public class Fish {
	private int road;//���ƶ���·�ߣ�����
	private int x;
	private int y;
	private int speed;//���ٶȡ�
	private int kind;//�������
	private Image imgs[];//�����ζ�ʱʹ�õ�ͼƬ
	private int index;//��ǰʹ��ͼƬ���±꣨δ�������ͼƬ�±꣩
	private Image catchedImgs[];//�����������ͼƬ
	private int catchedIndex;//��������㵱ǰ����ͼƬ��Ӧ���±�
	//�Ƿ񱻲���true����ʾ������false����ʾδ������
	private boolean isCatched;
	public static final int LEFT_TO_RIGHT = 0;
	public static final int UP_TO_BUTTOM = 1;
	public static final int RIGHT_TO_LEFT = 2;
	/**������ķ���
	 * @param g�����ݹ����Ļ���
	 */
	public void drawFish(Graphics g){
		if(isCatched){
			g.drawImage(catchedImgs[catchedIndex], x, y, null);
		}else{
			g.drawImage(imgs[index], x, y, null);
		}
	}
	public void move(){
		if(!isCatched){//δ������
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
		if(isCatched){//������
			if(kind>7){
				catchedIndex = (catchedIndex+1)%4;
			}else{
				catchedIndex = ++catchedIndex%2;
			}
		}else{//δ������
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
