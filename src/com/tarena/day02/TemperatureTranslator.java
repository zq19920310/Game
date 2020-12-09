package com.tarena.day02;
import java.util.Scanner;
public class TemperatureTranslator {
	public static void main(String[] args) {
		//		要保证输入的数字和单位间有空格。
		Scanner sca=new Scanner(System.in);
		while(true){
			System.out.println("请输入温度值(n C|F)：");
			int d=sca.nextInt(); 
			char c=sca.next().trim().charAt(0);		
			if(c=='c'||c=='C'){
				double f_temp=9*d/5.0+32;
	           //对double值四舍五入
				int f_temp_int=(int)(f_temp+0.5);			         
				System.out.println("您输入的温度值是："+d+" "+"C");            
				System.out.println("转化后的温度值是："+f_temp_int+" "+"F");
				
			}else if(c=='f'||c=='F'){
				double c_temp=5*(d-32)/9.0;
	          //对double值四舍五入
				int c_temp_int=(int)(c_temp+0.5);			
				System.out.println("您输入的温度值是："+d+" "+"F");
				System.out.println("转化后的温度值是："+c_temp_int+" "+"C");
			}else{
				System.out.println("您输入的温度单位不正确！温度单位必须为“C”或“F”");
			}
		}
	}
}
