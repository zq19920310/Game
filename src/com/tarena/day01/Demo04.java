package com.tarena.day01;
/**ѭ��
 * @author jinxf
 */
public class Demo04 {
	  public static void main(String[] args){
		  /*for(�������������ʼ����ֵ(��int i =0);
		      �ж�ѭ�������Ƿ����(i<20);
		      �ı������ֵ(i++)){
			  //ѭ����;
		  }*/
		  for(int i=0;i<20;i++){
			  System.out.println("����"+(i+1)+"Ȧ");
			  if(i%5!=4){
				  //��������ѭ��������ִ����һ��ѭ����continue�ؼ����Ժ��
				  //������forѭ���еĴ��뽫����ִ��
				  //continue;
				  //��ֹ��ǰѭ��
				  break;
			  }
			  System.out.println("�ȿ�ˮ");
			  System.out.println("...��������");
		  }
		 /* while(���ʽ){
			  //ѭ����
		  }*/
		  int sum =0;
		  while(sum<100){
			  //....
		  }
		  /*do{
			  //ѭ����
		  }while(���ʽ);*/
		  /**֪������ѭ�����ٴε�ʱ��ʹ��for��
		   * ��֪������ѭ�����ٴ�ʹ��while����do{}while();
		   * ���ѭ������ִ��һ�Σ�ʹ��do while��
		   */
	  }
}
