package com.tarena.day02;
import java.util.Scanner;


public class PayTaxCalculator {
	public static void main(String[] args) {
		System.out.println("请输入月实际收入：");
		Scanner sca=new Scanner(System.in);
		double totalSalary=sca.nextDouble();
		double taxSalary=totalSalary-3500;
		double tax=0.0;
		if(taxSalary<=0){
			tax=0.0;
		}else if(taxSalary>0 && taxSalary<=1500){
			tax=taxSalary*0.03;
		}else if(taxSalary>1500 && taxSalary<=4500){
			tax=1500*0.03+(taxSalary-1500)*0.1;
		}else if(taxSalary>4500 && taxSalary<=9000){
			tax=1500*0.03+3000*0.1+(taxSalary-4500)*0.20;
		}else if(taxSalary>9000 && taxSalary<=35000){
			tax=1500*0.03+3000*0.1+4500*0.2+(taxSalary-9000)*0.25;
		}else if(taxSalary>35000 && taxSalary<=55000){
			tax=1500*0.03+3000*0.1+4500*0.2+26000*0.25+(taxSalary-35000)*0.3;
		}else if(taxSalary>=55000 && taxSalary<80000){
			tax=1500*0.03+3000*0.1+4500*0.2+26000*0.25+20000*0.3+(taxSalary-55000)*0.35;
		} else if(taxSalary>=80000){
	tax=1500*0.03+3000*0.1+4500*0.2+26000*0.25+20000*0.3+25000*0.35+(taxSalary-80000)*0.45;
		}
		System.out.println("您本月的实际收入是："+totalSalary);
		System.out.println("您本月的应纳税所得额是："+taxSalary);
		System.out.println("您本月的应缴纳个人所得税："+tax);
		System.out.println("您本月的税后收入是："+(totalSalary-tax));
	}
}
