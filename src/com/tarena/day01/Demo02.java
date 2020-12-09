package com.tarena.day01;
//条件判断
public class Demo02 {
	public static void main(String[] args){
		 /*if(条件表达式){
			 //如果表达式的结果为true，执行该块代码
		 }else if(条件表达式2){
			 //....
		 }else if(条件表达式3){
			 //.....
		 }else{
			 //以上所有的条件表达式结果 均为false时，执行该块代码
		 }*/
		//Ctrl+Shift+/：多行注释
		/*if(条件表达式){
			//条件成立
		}else{
			//条件表达式不成立。
		}*/
		/*if(条件表达式){
			//条件成立时执行，如果不成立则不作任何操作。
		}*/
		int age = 10;
		if(age>=18){
			System.out.println("成年人，可以进网吧");
		}else{
			System.out.println("不好意思，未成年不能进网吧");
		}
		int score = 70;
		char level = ' ';
		switch(score/10){
			case 9:level ='A';break;
			case 8:level = 'B';break;
			case 7:level = 'C';break;
			case 6:level = 'D';break;
			case 5:case 4:case 3:case 2:case 1:case 0:
					level = 'E';break;
			default:
				level = ' ';break;
		}
		System.out.println("转换后的成绩："+level);
	}
}
