package com.tarena.day02;
import java.util.Calendar;
import java.util.Scanner;


public class TaxiCharge {
	public static void main(String[] args) {
		double len; // ��ʻ������
		int wait;//�ȴ�����
		double startPriceInDay=10.00; // �������
		double startPriceInNight=12.00; // ҹ�����
		double perPriceInDay=2.0; // ����ÿ����۸�
		double perPriceInNight=2.3; // ����ÿ����۸�
		double basePrice=0.0;//������̷�
		double emptyBackPrice=0.0;//���ؿ�ʻ�۸�
		double waitPrice=0.0;//�ȴ���
		double totalPrice=0.0; // �ܼ�
		//��õ�ǰϵͳʱ���Сʱ��
		int nowTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		Scanner  sca=new Scanner(System.in);
		System.out.println("��������ʻ��������");
		len=sca.nextDouble();
		System.out.println("������ȴ�ʱ�䣨��λ���룩��");
		wait=sca.nextInt();
		
		if(nowTime>=7 && nowTime<23){//����
			basePrice = startPriceInDay;
			if(len>3){
				basePrice +=Math.ceil(len-3.0)*perPriceInDay;
			}
			
		}else{//ҹ��
			basePrice=startPriceInNight;
			if(len>3){
				basePrice+=Math.ceil(len-3.0)*perPriceInNight;
			}
		}
		
		if(len>15){
			emptyBackPrice+=Math.ceil(len-15.0)*1;
		}
		
		waitPrice=wait/300*2;
		
		totalPrice=(basePrice+emptyBackPrice+waitPrice);
		
		System.out.println("���⳵Ӧ�տ����£�");
		System.out.println("������̷ѣ�"+basePrice);
		System.out.println("��ʻ�ѣ�"+emptyBackPrice);
		System.out.println("�ȴ��ѣ�"+waitPrice);
		System.out.println("��  �ƣ�"+totalPrice);
	}
}
