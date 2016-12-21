package test;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args){
//		getUnduplicatedRandom();
		getRandomMinus();
		getRandomFloat();
		
	}
	
	/**
	 *获取指定范围内不重复随机整数 
	 */
	static void getUnduplicatedRandom(){
		int[] rdSet = new int[10];//存储生成的随机数数组
		int count = 0;//记录随机数个数
		int flag = 0;//标记随机数是否已存在，0表示不存在，1表示已存在
		int num = 0;//记录总共生成了多少次随机数
		
		Random rd = new Random();
		
		while(count < 10){
			int rdNum = rd.nextInt(10) + 1;
			
			//遍历随机数存储数组，标记新生成的随机数是否已经存在
			for(int i = 0;i < count;i++){
				if(rdSet[i] == rdNum){
					flag = 1;
					break;
				}else{
					flag = 0;
				}
			}
			
			//如果新生成的随机数不存在，则添加进随机数存储数组，并将随机数个数加1
			if(flag == 0){
				rdSet[count] = rdNum;
				count++;
			}
			
			num++;
		}
		
		//打印输出不重复的随机数
		for(int i = 0;i < count;i++){
			System.out.println(rdSet[i]);
		}
		
		//输出总共进行了多少次随机
		System.out.println(num);
		
	}
	
	/**
	 *生成一个随机负数 
	 */
	static void getRandomMinus(){
		Random rd = new Random();
		int rdNum = 0;
		do{
			rdNum = rd.nextInt();
		}while(rdNum >= 0);
		
		System.out.println(rdNum%10);
	}
	
	/**
	 *生成随机浮点数 
	 */
	static void getRandomFloat(){
		Random rd = new Random();
		System.out.println(rd.nextFloat());
		System.out.println(rd.nextDouble());
	}
	
	
}
