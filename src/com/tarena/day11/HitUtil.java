package com.tarena.day11;

public class HitUtil {
	/**判断英雄机和敌机是否发生碰撞
	 * @param hero：英雄级
	 * @param enimy：敌机
	 * @return true:碰撞，false:未碰撞
	 */
	public static boolean isHit(Hero hero,Bubble enimy){
		//1、计算英雄机和敌机的“半径”和
		int sumR = hero.getR()+enimy.getR();
		//2、计算平行于X轴的“直角边”的“长度”
		int xxLen = hero.getX()+hero.getR()-
			(enimy.getX()+enimy.getR());
		//3、计算平行于Y轴的“直角边”的“长度”
		int yyLen = hero.getY()+hero.getR()-
			(enimy.getY()+enimy.getR());
		//4、计算英雄机和敌机中心点之间距离的平方
		int cc = xxLen*xxLen+yyLen*yyLen;
		//5、判断是否发生碰撞
		return cc <=sumR*sumR;
	}
	/**判断当前敌机是否被“当前”子弹击中
	 * @param b1:敌机
	 * @param b2:子弹
	 * @return true：表示击中，false:表示未击中
	 */
	public static boolean isHit(Bubble b1,Bubble b2){
		//1、计算两个泡泡的半径和
		int sumR = b1.getR() + b2.getR();
		//2、计算平行于X轴的“直角边”的“长度”
		int xxLen = b1.getX()+b1.getR()-
				(b2.getX()+b2.getR());
		//3、计算平行于Y轴的“直角边”的“长度”
		int yyLen = b1.getY()+b1.getR()-
				(b2.getY()+b2.getR());
		//4、计算两个泡泡圆心点之间距离的平方
		int cc = xxLen * xxLen +yyLen*yyLen;
		//5、判断是否发生碰撞
		/*if(cc<=sumR*sumR){
			return true;
		}else{
			return false;
		}*/
		return cc<=sumR*sumR;
	}
}
