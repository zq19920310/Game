package com.tarena.day02;
import java.util.Random;
public class GetStudents {
	public static void main(String[] args) {
		Random random = new Random();
		for(int i=0;i<8;i++){
			int num = random.nextInt(16)+1;
			System.out.println("第"+num+"组做好准备");
		}
	}
}
