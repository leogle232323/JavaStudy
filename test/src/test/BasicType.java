package test;

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
		
		//Primitive type & Wrapper type
		//1.boolean|Boolean 
		boolean primitiveBoolean = false;
		boolean wrapperBoolean = new Boolean(true);
		System.out.println(primitiveBoolean);
		System.out.println(wrapperBoolean);
		
		//2.char|Character  Size:16-bit  Minimum:Unicode 0  Maximum:Unicode 2(16)-1
		char primitiveChar = '/';
		Character wrapperCharcter = new Character(';');
		System.out.println(primitiveChar);
		System.out.println(wrapperCharcter);
		
		//3.byte|Byte  Size:8-bit  Minimum:-128  Maximum:127 
		byte primitiveByte = 1;
		Byte wrapperByte = new Byte((byte)2);
		System.out.println(primitiveByte);
		System.out.println(wrapperByte);
		
		//4.short|Short  Size:16-bit  Minimum:-2(15)  Maximum:2(15)-1
		short primitiveShort = 3;
		Short wrapperShort = new Short((short)4);
		System.out.println(primitiveShort);
		System.out.println(wrapperShort);
		
		//5.int|Integer  Size:32-bit  Minimum:-2(31)  Maximum:2(31)-1
		int primitiveInt = 6;
		Integer wrapperInteger = new Integer(7);
		System.out.println(primitiveInt);
		System.out.println(wrapperInteger);
		
		//6.long|Long  Size:64-bit  Minimum:-2(63)  Maximum:2(63)-1
		long primitiveLong = 8;
		Long wrapperLong = new Long(9l);
		System.out.println(primitiveLong);
		System.out.println(wrapperLong);
		
		//7.float|Float  Size:32-bit  Minimum:IEEE754  Maximum:IEEE754
		float primitiveFloat = 10;
		Float wrapperFloat = new Float(11);
		System.out.println(primitiveFloat);
		System.out.println(wrapperFloat);
		
		//8.double|Double  Size:64-bit Minimum:IEEE754  Maximum:IEEE754
		double primitiveDouble = 12;
		Double wrapperDouble = new Double(13);
		System.out.println(primitiveDouble);
		System.out.println(wrapperDouble);
		
		//9.void|Void
		
		
	}
}
