package com.tarena.day01;

public class Demo01 {
	  public static void main(String[] args){
		  /**��ֵ�ͣ�
		   * 	|-���ͣ�
		   * 		byte,short,int,long
		   * 	|-�����ͣ�
		   * 		float��double
		   * ����ֵ�ͣ�
		   * 	char
		   *    boolean
		   * 1�� ��С��Χ����Χ�����Զ�����ת��
		   * byte->short->int->long
		   * float->double
		   * char->int ->long
		   * int ->float-->double
		   *  2���Ӵ�Χ��С��Χ��Ҫǿ������ת��
		   *  3��С��Χ���͵���ֵ�ʹ�Χ���͵���ֵ ���м�����
		   *  ���Զ���������Χ��
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
		  String str = "�ܼ�:";
		   System.out.println(str+(allPrice-20));
		  String s = "123";
		  //��String����ת���ɻ������ͣ�
		  int sint = Integer.parseInt(s);
		  double sdou = Double.parseDouble(s);
		  float sflo = Float.parseFloat(s);
		  char sch = s.charAt(0);
		  //Alt+/:��ʾ ���Զ���ȫ
		  
	  }
}
