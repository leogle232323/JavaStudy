package test;

import java.math.BigInteger;

public class BasicType {
	public static void main(String[] args){
		//1.在堆栈中创建对象
		char c = 'x';
		//2.在堆中创建对象，Character是基本类型char的包装器类
		Character ch = new Character(c);
		Character ch1 = new Character('x');
		
		System.out.println(c);
		System.out.println(ch);
		System.out.println(ch1);
		
		//测试分支合并
		System.out.println("测试分支合并");
		
		//1.测试分支合并合并合并
		System.out.println("hahhaha");
		
	}
}
