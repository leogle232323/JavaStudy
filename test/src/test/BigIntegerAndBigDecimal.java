package test;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerAndBigDecimal {
	public static void main(String[] args) {
		// 1.BigInteger 大数据整数类型
		// 1.基本函数
		char ch = 'x';
		byte b = 23;
		int i = 12345;
		long l = 1111111111;

		BigInteger cc = BigInteger.valueOf(ch);
		BigInteger bb = BigInteger.valueOf(b);
		BigInteger bi = BigInteger.valueOf(i);
		BigInteger bl = BigInteger.valueOf(l);

		System.out.println(cc);
		System.out.println(bb);
		System.out.println(bi);
		System.out.println(bl);

		// 2.大整数相加
		BigInteger c = bb.add(bi);
		System.out.println(c);

		// 3.大整数相减
		BigInteger d = bb.subtract(bi);
		System.out.println(d);

		// 4.大整数相乘
		BigInteger e = bb.multiply(bi);
		System.out.println(e);

		// 5.大整数相除
		BigInteger f = bb.divide(bi);
		System.out.println(f);

		// 6.大整数取余
		BigInteger g = bb.remainder(bi);
		System.out.println(g);

		// 7.x的y次方
		BigInteger h = bb.pow(i);
		System.out.println(h);

		// 8.gcd最大公约数
		BigInteger j = bb.gcd(bi);
		System.out.println(j);

		// 9.abs绝对值
		BigInteger k = bb.abs();
		System.out.println(k);

		// 10.取反数
		BigInteger m = bb.negate();
		System.out.println(m);

		// 11.取模
		BigInteger n = bb.mod(bi);
		System.out.println(n);

		// 12.取最大
		BigInteger o = bb.max(bi);
		System.out.println(o);

		// 13.取最小
		BigInteger p = bb.min(bi);
		System.out.println(p);

		// 14.compareTo
		int q = bb.compareTo(bi);
		System.out.println(q);

		// compareTo 返回两个字符串首次出现不同字符的字符差值，负数表示前者小，正数表示前者大，0表示相等
		String aaa = "abcedfg";
		String bbb = "abcedfg";
		String ccc = "ABCedfg";
		int iii = aaa.compareTo(bbb);
		int jjj = aaa.compareToIgnoreCase(ccc);
		System.out.println(iii);
		System.out.println(jjj);

		// 15.比较是否相等
		boolean r = bb.equals(bi);
		System.out.println(r);

		// 构造函数
		//
		// String str = "abcedf";
		// BigInteger s = new BigInteger(str);
		// System.out.println(s);

		// 基本常量
		BigInteger A = BigInteger.ONE;
		BigInteger B = BigInteger.TEN;
		BigInteger C = BigInteger.ZERO;
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);

		// 读入
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			BigInteger si = sc.nextBigInteger();
			System.out.println(si.toString());
		}
	}

}
