package test;

import java.util.Date;

public class StringFormat {

	public static void main(String[] args) {
		// 1.%s String
		String str = String.format("Hi,%s!", "leogle");
		System.out.println(str);
		// 2.%c char
		System.out.printf("字母a的大写是：%c %n", 'A');
		// 3.%b boolean
		System.out.printf("3>7的结果是 %b %n", 3 > 7);
		// 4.%d decimal int
		System.out.printf("100的一半是:%d %n", 100 / 2);
		// 5.%x hexadecimal int
		System.out.printf("100的16进制数是：%x %n", 100);
		// 6.%o octal int
		System.out.printf("100的八进制数是：%o %n", 100);
		// 7.%f float
		System.out.printf("50元的书打8.5折是：%f 元 %n", 50 * 8.5);
		// 8.%a hexadecimal float
		System.out.printf("上面价格的十六进制数是： %a 元 %n", 50 * 8.5);
		// 9.%e index
		System.out.printf("上面的价格指数是： %e %n", 50 * 8.5);
		// 10.%g commom float
		System.out.printf("上面价格中指数和浮点数较短的是：%g %n", 50 * 8.5);
		// 11.%h hash code
		System.out.printf("字母A的散列码是：%h %n", 'A');
		// 12.%% percent
		System.out.printf("上面的折扣是：%d%% %n", 85);
		// 13.%n newline
		System.out.printf("换行：%n", "");
		// 14.%tx date&time
		long date = new Date().getTime();
		// 1.%tc
		System.out.printf("包括全部日期和时间信息：%tc %n", date);
		// 2.%tF year-month-day
		System.out.printf("年月日格式：%tF %n", date);
		// 3.%tD month/day/year
		System.out.printf("月日年格式：%tD %n", date);
		// 4.%tr HH:MM:SS PM
		System.out.printf("12小时制：%tr %n", date);
		// 5.%tT HH:MM:SS
		System.out.printf("24小时制:%tT %n", date);
	}

}
