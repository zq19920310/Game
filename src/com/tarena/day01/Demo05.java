package com.tarena.day01;
//1�����ǽ����һ����
import  java.util.Scanner;
public class Demo05 {
	public static void main(String[] args) {
		//2��Ů����  С��  =  new Ů����("...");
		Scanner input = new Scanner(System.in);
		//3����ʾ�û���������
		System.out.println("��������������:");
		//4���������������
		String name = input.nextLine();//next();
		//5����ʾ�û���������
		System.out.println("��������������:");
		int age = input.nextInt();
		System.out.println("****************************");
		System.out.println("���������ǣ�"+name);
		System.out.println("���������ǣ�"+age);
	}

}
