package com.tarena.day01;
//1、哥们借给我一个类
import  java.util.Scanner;
public class Demo05 {
	public static void main(String[] args) {
		//2、女朋友  小美  =  new 女朋友("...");
		Scanner input = new Scanner(System.in);
		//3、提示用户输入姓名
		System.out.println("请输入您的姓名:");
		//4、接收输入的姓名
		String name = input.nextLine();//next();
		//5、提示用户输入年龄
		System.out.println("请输入您的年龄:");
		int age = input.nextInt();
		System.out.println("****************************");
		System.out.println("您的姓名是："+name);
		System.out.println("您的年龄是："+age);
	}

}
