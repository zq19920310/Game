package com.tarena.day01;
/**循环
 * @author jinxf
 */
public class Demo04 {
	  public static void main(String[] args){
		  /*for(定义变量并赋初始化的值(如int i =0);
		      判断循环条件是否成立(i<20);
		      改变变量的值(i++)){
			  //循环体;
		  }*/
		  for(int i=0;i<20;i++){
			  System.out.println("跑了"+(i+1)+"圈");
			  if(i%5!=4){
				  //跳出本次循环，继续执行下一次循环，continue关键字以后的
				  //并且在for循环中的代码将不再执行
				  //continue;
				  //终止当前循环
				  break;
			  }
			  System.out.println("喝口水");
			  System.out.println("...，继续跑");
		  }
		 /* while(表达式){
			  //循环体
		  }*/
		  int sum =0;
		  while(sum<100){
			  //....
		  }
		  /*do{
			  //循环体
		  }while(表达式);*/
		  /**知道具体循环多少次的时候使用for。
		   * 不知道具体循环多少次使用while或者do{}while();
		   * 如果循环至少执行一次，使用do while。
		   */
	  }
}
