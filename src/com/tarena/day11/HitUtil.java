package com.tarena.day11;

public class HitUtil {
	/**�ж�Ӣ�ۻ��͵л��Ƿ�����ײ
	 * @param hero��Ӣ�ۼ�
	 * @param enimy���л�
	 * @return true:��ײ��false:δ��ײ
	 */
	public static boolean isHit(Hero hero,Bubble enimy){
		//1������Ӣ�ۻ��͵л��ġ��뾶����
		int sumR = hero.getR()+enimy.getR();
		//2������ƽ����X��ġ�ֱ�Ǳߡ��ġ����ȡ�
		int xxLen = hero.getX()+hero.getR()-
			(enimy.getX()+enimy.getR());
		//3������ƽ����Y��ġ�ֱ�Ǳߡ��ġ����ȡ�
		int yyLen = hero.getY()+hero.getR()-
			(enimy.getY()+enimy.getR());
		//4������Ӣ�ۻ��͵л����ĵ�֮������ƽ��
		int cc = xxLen*xxLen+yyLen*yyLen;
		//5���ж��Ƿ�����ײ
		return cc <=sumR*sumR;
	}
	/**�жϵ�ǰ�л��Ƿ񱻡���ǰ���ӵ�����
	 * @param b1:�л�
	 * @param b2:�ӵ�
	 * @return true����ʾ���У�false:��ʾδ����
	 */
	public static boolean isHit(Bubble b1,Bubble b2){
		//1�������������ݵİ뾶��
		int sumR = b1.getR() + b2.getR();
		//2������ƽ����X��ġ�ֱ�Ǳߡ��ġ����ȡ�
		int xxLen = b1.getX()+b1.getR()-
				(b2.getX()+b2.getR());
		//3������ƽ����Y��ġ�ֱ�Ǳߡ��ġ����ȡ�
		int yyLen = b1.getY()+b1.getR()-
				(b2.getY()+b2.getR());
		//4��������������Բ�ĵ�֮������ƽ��
		int cc = xxLen * xxLen +yyLen*yyLen;
		//5���ж��Ƿ�����ײ
		/*if(cc<=sumR*sumR){
			return true;
		}else{
			return false;
		}*/
		return cc<=sumR*sumR;
	}
}
