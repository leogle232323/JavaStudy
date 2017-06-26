package test;

public class StringToNumber {

	public static void main(String[] args) {
		// 1.string to int
		int a = Integer.parseInt("123456");
		// 2.string to Integer
		Integer b = Integer.valueOf("123456");
		System.out.println(a + ":" + b);

		// 3.int to string
		String s = Integer.toString(a);
		// 4.Integer to string
		String s1 = Integer.toString(b);
		System.out.println(s + ":" + s1);

		// 5.int to Integer
		Integer c = Integer.valueOf(a);
		// 6.Integer to int
		int d = b;
		System.out.println(c + ":" + d);

	}

}
