package com.tarena.day08;

import java.util.LinkedList;
import java.util.List;
public class ListDemo {
	public static void main(String[] args) {
		/**1、声明并实例化集合类的对象
		 * List<类型> 集合对象的名称 = new ArrayList<类型>();
		 * List<类型> 集合对象的名称 = new LinkedList<类型>();
		 * ArrayList:可变长度的数组
		 * 		优点：查询效率较高，
		 *      缺点：添加和删除效率较低
		 *LinkedList:可变长度的链表
		 *		优点：添加和删除效率较高
		 *	    缺点：查询的效率较低
		 *2、常用方法：
		 *	add(Object obj):添加一个对象
		 *  add(int index,Object obj):在对应的位置上添加一个对象
		 *  get(int index)：读取对应位置的对象
		 *  remove(int index)：删除指定位置的对象
		 *  remove(Object obj)：删除集合中对应的对象
		 *  size():获取集合的长度（即保存对象的个数）
		 *  3、泛型
		 *  A.对添加的对象进行类型验证：
		 *  使用泛型之后，该集合中只能添加泛型对应类型的对象
		 *  或它的"后代类"的对象。
		 *  B.使用get方法获取对象后，类型一般和目标类型一致，
		 *  通常不需要进行类型转换。
		 */
		//List<Food> foodBox = new ArrayList<Food>();//
		List<Food> foodBox = new LinkedList<Food>();
		Food f1 = new Food("平遥牛肉",50);
		foodBox.add(f1);//add添加一个对象
		foodBox.add(new Food("北京烤鸭",72));
		foodBox.add(new Food("鲍鱼一只",3000));
		Food f2 = new Food("龙虾",500);
		foodBox.add(0,f2);
		foodBox.remove(2);
		foodBox.remove(2);
		for(int i=0;i<foodBox.size();i++){
			Food food =  foodBox.get(i);
			food.printInfo();
		}
	}
}
class Food{
	private String name;
	private double price;
	public Food(String name,double price){
		this.name = name;
		this.price = price;
	}
	public void printInfo(){
		System.out.println("名称："+name+"价格："+price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

