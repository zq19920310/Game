package com.tarena.day06;

public class Person {
	private String name;
	private int age;
	private String sex;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		if(age<=0||age>200){
			this.age = 18;
		}else{
			this.age = age;
		}
	}
	public int getAge(){
		return age;
	}
	public void setSex(String sex){
		if("男".equals(sex)||"女".equals(sex)||"红艺人".equals(sex)){
			this.sex = sex;
		}else{
			this.sex = "男";
		}
	}
	public String getSex(){
		return this.sex;
	}
	public void printInfo(){
		System.out.println("姓名："+name+"\t年龄："+age
				+"\t性别："+sex);
	}
}
