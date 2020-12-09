package com.tarena.day01;

public class Demo01 {
	  public static void main(String[] args){
		  /**数值型：
		   * 	|-整型：
		   * 		byte,short,int,long
		   * 	|-非整型：
		   * 		float、double
		   * 非数值型：
		   * 	char
		   *    boolean
		   * 1、 从小范围到大范围可以自动类型转化
		   * byte->short->int->long
		   * float->double
		   * char->int ->long
		   * int ->float-->double
		   *  2、从大范围到小范围需要强制类型转化
		   *  3、小范围类型的数值和大范围类型的数值 进行计算结果
		   *  会自动升级到大范围。
		   */
		  byte b1 = 1;
		  short s1 = b1;
		  int in1 = s1;
		  int in2 = b1;
		  long lo1 = b1;
		  long lo2 = s1;
		  long lo3 = in1;
		  int in3 = (int)lo3;
		  int x = 30;
		  long y = 25l+30;
		  char ch = 'Z';
		  int z = ch;
		  //[0,26)+65:[65,91]
		  System.out.println(z);
		  double price = 50.5;
		  int count  = 40;
		  double allPrice = price*count;
		  String str = "总价:";
		   System.out.println(str+(allPrice-20));
		  String s = "123";
		  //从String类型转化成基本类型：
		  int sint = Integer.parseInt(s);
		  double sdou = Double.parseDouble(s);
		  float sflo = Float.parseFloat(s);
		  char sch = s.charAt(0);
		  //Alt+/:提示 或自动补全
		  
	  }
}
