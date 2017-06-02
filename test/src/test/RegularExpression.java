package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		// ESC (escape character)
		// 1.\r enter
		String esc1 = "\r";
		System.out.println("1.esc \\r enter " + esc1.matches("\\r"));
		// 2.\n newline
		String esc2 = "\n";
		System.out.println("2.esc \\n newline " + esc2.matches("\\n"));
		// 3.\t tab
		String esc3 = "\t";
		System.out.println("3.esc \\t tab " + esc3.matches("\\t"));
		// 4.\\ \ itself
		String esc4 = "\\";
		System.out.println("4.esc \\ \\ itself " + esc4.matches("\\."));
		// 5.\^ ^
		String esc5 = "^";
		System.out.println("5.esc \\^ ^ " + esc5.matches("\\^"));
		// 6.\$ $
		String esc6 = "$";
		System.out.println("6.esc \\$ $ " + esc6.matches("\\$"));
		// 7.\. .
		String esc7 = ".";
		System.out.println("7.esc \\. . " + esc7.matches("\\."));
		// 8.\d matches number in[0,9]
		String esc8 = "555";
		System.out.println("8.esc \\d [0,9] " + esc8.matches("\\d\\d\\d"));
		// 9.\w A-Z,a-z,[0,9],_
		String esc9 = "Aa0_";
		System.out.println("9.esc \\w A-Z,a-z,[0,9],_ " + esc9.matches("\\w\\w\\w\\w"));
		// 10.\s space/tab/form feed
		String esc10 = " \t ";
		System.out.println("10.esc \\s space/tab/form feed " + esc10.matches("\\s\\s\\s"));
		// 11. . every character except \n
		String str1 = "Ab0_%$";
		System.out.println("11. . every character except \\n " + str1.matches("......"));

		// 12.[ab5@] in {a,b,5,@}
		String str2 = "a";
		System.out.println("12.[ab5@] character in {a,b,5,@} " + str2.matches("[ab5@]"));
		// 13.[^abc] not in{a,b,c}
		String str3 = "e";
		System.out.println("13.[^abc] character not in {a,b,c} " + str3.matches("[^abc]"));
		// 14.[b-z] in [b-z]
		String str4 = "c";
		System.out.println("14.[b-z] character in [b-z] " + str4.matches("[b-z]"));
		// 15.[^A-F0-3] not in [A-F] or [0-3]
		String str5 = "b";
		System.out.println("15.[^A-F0-3] not in [A-F] or [0-3] " + str5.matches("[^A-F0-3]"));

		// 16.{n} repeat n times
		String str6 = "aaaaa";
		System.out.println("16.{n} repeat n times " + str6.matches("\\w{5}"));
		// 17.{m,n} repeat [m,n] times
		String str7 = "bbb";
		System.out.println("17.{m,n} repeat [m,n] times " + str7.matches("\\w{0,5}"));
		// 18.{m,} repeat at least m times
		String str8 = "ccccc";
		System.out.println("18.{m,} repeat at least m times " + str8.matches("\\w{5,}"));
		// 19.? equals {0,1}
		String str9 = "ac";
		System.out.println("19.? equals {0,1} " + str9.matches("\\w\\w?"));
		// 20.+ equals {1,}
		String str10 = "abcde";
		System.out.println("20.+ equals {1,} " + str10.matches("\\w+"));
		// 21.* equals {0,}
		String str11 = "abcdef";
		System.out.println("21.* equals {0,} " + str11.matches("\\w*"));

		// 22.^ matches at beginning of string, do not matches any character
		String str12 = "aaabbbccc";
		System.out.println(
				"22.^ matches at beginning of string, do not matches any character " + str12.matches("^aaa\\w{6}"));
		// 23.$ matches at end of string, do not matches any character
		String str13 = "aaabbbccc";
		System.out.println("23.$ matches at end of string, do not matches any character " + str13.matches("\\w*ccc$"));
		// 24.\b matches edge of a word(between word and space), do not matches
		// any character
		String str14 = "weekend,end";
		System.out.println("24.\\b matches edge of a word(between word and space), do not matches any character "
				+ str14.matches(".{8}end\\b"));

		// 25.a|b matches a or b
		String str15 = "Tom,Jack";
		System.out.println("25.a|b matches a or b " + str15.matches("Tom.*|Jack.*"));
		// 26.() as a whole which in ()
		String str16 = "hahaha";
		System.out.println("26.() as a whole in () " + str16.matches("(\\w*)+"));

		// 27.greedy mode
		String str17 = "dxxxdxxxd";
		Pattern p1 = Pattern.compile("(d)(\\w+)");
		Pattern p2 = Pattern.compile("(d)(\\w+)(d)");
		Matcher m1 = p1.matcher(str17);
		Matcher m2 = p2.matcher(str17);
		System.out.println(m1);
		System.out.println("27.greedy mode " + m1.matches());
		System.out.println(m2);
		System.out.println("27.greedy mode " + m2.matches());
		// 28.non-greedy mode
		String str18 = "dxxxdxxxd";
		Pattern p3 = Pattern.compile("(d)(\\w+?)");
		Pattern p4 = Pattern.compile("(d)(\\w+?)(d)");
		Matcher m3 = p3.matcher(str18);
		Matcher m4 = p4.matcher(str18);
		System.out.println(m3);
		System.out.println("28.non-greedy mode " + m3.matches());
		System.out.println(m4);
		System.out.println("28.non-greedy mode " + m4.matches());

		// 29.back reference
		String str19 = "'Hello','World'";
		System.out.println("29.back reference " + str19.matches("(\'|\")(.*?)(\1)(.*)"));
		String str20 = "aa bb ccccc 999999";
		System.out.println("29.back reference " + str20.matches("(.*)(\\w)\2{4,}(.*)"));
		String str21 = "<td id='td1' style='bgcolor:white'></td>";
		String str22 = "<td id='td1' style=\"bgcolor:white\"></td>";
		System.out.println("29.back reference " + str21.matches("<(\\w+)\\s*(\\w+(=(\'|\").*\\4)?\\s*)*>.*?</\\1>"));
		System.out.println("29.back reference " + str22.matches("<(\\w+)(\\s*)(\\w+(=(\'|\").*\\5)?\\s*)*></\\1>"));

		// exercise
		// 1.postal code
		System.out.println("exercies:");
		String e1 = "637000";
		System.out.println("1.postal code " + e1.matches("^[1-9]\\d{5}$"));
		// 2.QQ number
		String e2 = "1191087021";
		System.out.println("2.QQ number " + e2.matches("^[1-9]\\d{4,10}$"));
		// 3.email
		String e3 = "11eoge@yeah.net";
		String e4 = "zhang.guo.feng@qq.com";
		String ee = "xxx_xxx@xxx-xxx.com.hk";
		String regex1 = "^(\\w)+(\\.\\w+)*@(\\w)+(\\.\\w{2,3}){1,3}";
		String regex2 = "^(\\w)+(\\.\\w+)*@(\\w)+(\\.\\w+)+";
		String regexx = "^(.*)@(.*)+(\\.\\w+)+";
		System.out.println("3.email " + e3.matches(regex1));
		System.out.println("3.email " + e4.matches(regex2));
		System.out.println("3.email " + ee.matches(regexx));
		// 4.username
		String e5 = "Xxss__";
		System.out.println("4.username " + e5.matches("^[A-Za-z]\\w+$"));
		// 5.phone number
		String e6 = "15826142583";
		System.out.println("5.phone number " + e6.matches("^1[3|4|5|7|8]\\d{9}$"));
		// 6.url
		String regex3 = "^((http|https):?(//)?)?(\\w+)?(\\.\\w+)*$";
		String e7 = "http://www.zbj.com";
		String e8 = "zbj.com";
		String e9 = "www2.zbj.com.cn.cn";
		String e10 = "http";
		String e11 = "http://";
		System.out.println("6.url " + e7.matches(regex3));
		System.out.println("6.url " + e8.matches(regex3));
		System.out.println("6.url " + e9.matches(regex3));
		System.out.println("6.url " + e10.matches(regex3));
		System.out.println("6.url " + e11.matches(regex3));
		// 7.ID number
		String regex4 = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$";
		String e12 = "37068519880618730X";
		String e13 = "130634199306097797";
		System.out.println("7.ID number " + e12.matches(regex4));
		System.out.println("7.ID number " + e13.matches(regex4));
		// 8.one or more Chinese Character
		String regex5 = "^[\u0391-\uFFE5]+$";
		String e14 = "哈哈";
		System.out.println("8.one or more Chinese Character " + e14.matches(regex5));
	}
}
