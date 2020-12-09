package com.tarena.day11.plane;

import java.awt.Graphics;
import java.awt.Image;
public class Bullet {
	private int x;
	private int y;
	private int width;
	private int height;
	private Image img;
	/**width  = img.getWidth(null);
		height = img.getHeight(null);
	 */
	public void drawBullet(Graphics g){
		g.drawImage(img, x, y,width/2,height/2, null);
	}
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
}
