package test;

public class StringBufferClass {

	public static void main(String[] args) {
		String str = "abc";
		//1.Initialize StringBuffer & String to StringBuffer
		StringBuffer strB1 = new StringBuffer(str);
		StringBuffer strB2 = new StringBuffer("def");
		
		//2.StringBuffer to String 
		String str1 = strB1.toString();
		String str2 = strB2.toString();
		System.out.println("str = " + str);
		System.out.println("strB1 = " + strB1);
		System.out.println("strB2 = " + strB2);
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		
		//3.append
		StringBuffer strB3 = new StringBuffer();
		strB3.append("Nice Day ! ");
		strB3.append("The sky is blue ,")
			 .append("the sky is white ,")
			 .append("the sky is green !");
		System.out.println(strB3);
		
		//4.deleteCharAt
		strB3.deleteCharAt(1);
		System.out.println(strB3);
		
		//5.delete(int start, int end)  [start,end)
		strB3.delete(1, 3);
		System.out.println(strB3);
		
		//6.insert
		strB3.insert(1, "ice");
		System.out.println(strB3);
		
		//7.reverse
		strB3.reverse();
		System.out.println(strB3);
		
		//8.setCharAt
		strB3.setCharAt(1, '%');
		System.out.println(strB3);
		
		//9.trimToSize
		System.out.println("strB3's length is " + strB3.length());
		strB3.trimToSize();
		System.out.println("strB3's length after trim is " + strB3.length());
		
	}
}
