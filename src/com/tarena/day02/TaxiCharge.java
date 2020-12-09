package com.tarena.day02;
import java.util.Calendar;
import java.util.Scanner;


public class TaxiCharge {
	public static void main(String[] args) {
		double len; // 行驶公里数
		int wait;//等待秒数
		double startPriceInDay=10.00; // 白天起价
		double startPriceInNight=12.00; // 夜间起价
		double perPriceInDay=2.0; // 白天每公里价格
		double perPriceInNight=2.3; // 晚上每公里价格
		double basePrice=0.0;//基本里程费
		double emptyBackPrice=0.0;//返回空驶价格
		double waitPrice=0.0;//等待费
		double totalPrice=0.0; // 总价
		//获得当前系统时间的小时数
		int nowTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		Scanner  sca=new Scanner(System.in);
		System.out.println("请输入行驶公里数：");
		len=sca.nextDouble();
		System.out.println("请输入等待时间（单位：秒）：");
		wait=sca.nextInt();
		
		if(nowTime>=7 && nowTime<23){//白天
			basePrice = startPriceInDay;
			if(len>3){
				basePrice +=Math.ceil(len-3.0)*perPriceInDay;
			}
			
		}else{//夜间
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
		
		System.out.println("出租车应收款如下：");
		System.out.println("基本里程费："+basePrice);
		System.out.println("空驶费："+emptyBackPrice);
		System.out.println("等待费："+waitPrice);
		System.out.println("总  计："+totalPrice);
	}
}
