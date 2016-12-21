package test;

class Test{
	boolean b;
	char c;
	byte bt;
	short s;
	int i;
	long l;
	float f;
	double d;
}
public class ClassTest {
	public static void main(String[] args){
		//1.类成员，默认初始化值，只适用于类成员，不适用于局部变量
		Test t = new Test();
		System.out.println(t.b);//默认为false
		System.out.println(t.c);//默认为null
		System.out.println(t.bt);//默认为（byte）0
		System.out.println(t.s);//默认为（short）0
		System.out.println(t.i);//默认为0
		System.out.println(t.l);//默认为0L
		System.out.println(t.f);//默认为0.0f
		System.out.println(t.d);//默认为0.0d
		
		System.out.println(System.lineSeparator() + "haha");
		
		//2.将属性list发送给输出流
		System.getProperties().list(System.out);
		
	}
}
