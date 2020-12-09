package com.tarena.day04;
/**继承使用的好处：
 * 		可以把相似类中相同的属性和方法，封装到
 * 一个类中，这样的话可以减少相同代码编写的次数。
 * PS：一个类最多只能有一个父类，如果没有为该类指定具体的
 * 父类，系统会自动为之指定一个Object类作为该类的父类。
 * 
 */
public class Person  extends Animal{
	String name;
	int age;
	public void eat(){
		//...
	}
	public void sleep(){
		//...
	}
}
