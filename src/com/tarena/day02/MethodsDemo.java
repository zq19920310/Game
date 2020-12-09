package com.tarena.day02;

public class MethodsDemo {
	  /**  访问修饰符（public,protected,private,...）   
	   *    static修饰符(静态方法或类方法，可以通过类名直接调用)
	   *    返回值类型/void
	   *    方法名(参数类型 参数1，参数类型  参数2...)
	   */
	public static  int  getSum(int x,int y){
		return x+y;
	}
	public static  double  getSum(double m,int n){
		return m+n;
	}
	public static  double  getSum(int m,double n){
		return m+n;
	}
	public static double getSum(double x,double y){
		return x+y;
	}
	/**方法重载：
	 * 位置：同一类中
	 * 方法名相同，参数列表不同，和返回值类型无关。
	 */
}
