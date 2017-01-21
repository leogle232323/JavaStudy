package test;

public class RegularExpression {
	
	public static void main(String[] args) {
		//ESC (escape character)
		//1.\r enter
		String esc1 = "\r";
		System.out.println("esc \\r enter " + esc1.matches("\\r"));
		//2.\n newline
		String esc2 = "\n";
		System.out.println("esc \\n newline " + esc2.matches("\\n"));
		//3.\t tab
		String esc3 = "\t";
		System.out.println("esc \\t tab " + esc3.matches("\\t"));
		//4.\\ \ itself
		String esc4 = "\\";
		System.out.println("esc \\ \\ itself " + esc4.matches("\\*"));
		//5.\^ ^ 
		String esc5 = "^";
		System.out.println("esc \\^ ^ " + esc5.matches("\\^")); 
		//6.\$ $
		String esc6 = "$";
		System.out.println("esc \\$ $ " + esc6.matches("\\$"));
		//7.\. .
		String esc7 = ".";
		System.out.println("esc \\. . " + esc7.matches("\\."));
		//8.\d matches number in[0,9]
		String esc8 = "555";
		System.out.println("esc \\d [0,9] " + esc8.matches("\\d\\d\\d"));
		//9.\w  A-Z,a-z,[0,9],_
		String esc9 = "Aa0_";
		System.out.println("esc \\w A-Z,a-z,[0,9],_ " + esc9.matches("\\w\\w\\w\\w"));
		//10.\s space/tab/form feed 
		String esc10 = " \t ";
		System.out.println("esc \\s space/tab/form feed " + esc10.matches("\\s\\s\\s"));
		//11. . every character except \n
		String str1 = "Ab0_%$";
		System.out.println(" . every character except \\n " + str1.matches("......"));
		
		//12.[ab5@] in {a,b,5,@}
		String str2 = "a";
		System.out.println("[ab5@] character in {a,b,5,@} " + str2.matches("[ab5@]"));
		//13.[^abc] not in{a,b,c}
		String str3 = "e";
		System.out.println("[^abc] character not in {a,b,c} " + str3.matches("[^abc]"));
		//14.[b-z] in [b-z]
		String str4 = "c";
		System.out.println("[b-z] character in [b-z] " + str4.matches("[b-z]"));
		//15.[^A-F0-3] not in [A-F] or [0-3]
		String str5 = "b";
		System.out.println("[^A-F0-3] not in [A-F] or [0-3] " + str5.matches("[^A-F0-3]"));
		
		//16.{n} repeat n times
		String str6 = "aaaaa";
		System.out.println("{n} repeat n times " + str6.matches("\\w{5}"));
		//17.{m,n} repeat [m,n] times
		String str7 = "bbb";
		System.out.println("{m,n} repeat [m,n] times " + str7.matches("\\w{0,5}"));
		//18.{m,} repeat at least m times
		String str8 = "ccccc";
		System.out.println("{m,} repeat at least m times " + str8.matches("\\w{5,}"));
		//19.?  equals {0,1}
		String str9 = "ac";
		System.out.println("? equals {0,1} " + str9.matches("\\w\\w?"));
		//20.+  equals {1,}
		String str10 = "abcde";
		System.out.println("+ equals {1,} " + str10.matches("\\w+"));
		//21.* equals {0,}
		String str11 = "abcdef";
		System.out.println("* equals {0,} " + str11.matches("\\w*"));
		
		//22.^ matches at beginning of string, do not matches any character
		String str12 = "aaabbbccc";
		System.out.println("^ matches at beginning of string, do not matches any character " + str12.matches("^aaa\\w{6}"));
		//23.$ matches at end of string, do not matches any character
		String str13 = "aaabbbccc";
		System.out.println("$ matches at end of string, do not matches any character " + str13.matches("\\w*ccc$"));
		//24.\b matches edge of a word(between word and space), do not matches any character
		String str14 = "weekend,end";
		System.out.println("\\b matches edge of a word(between word and space), do not matches any character " + str14.matches(".{8}end\\b"));
		
		//25.a|b matches a or b 
		String str15 = "Tom,Jack";
		System.out.println("a|b matches a or b " + str15.matches("Tom.*|Jack.*"));
		//26.() as a whole which in ()
		String str16 = "hahaha";
		System.out.println("() as a whole in () " + str16.matches("(\\w*)+"));
		
		//27.greedy mode
		String str17 = "dxxxdxxxd";
		System.out.println("greedy mode" + str17.matches("(d)(\\w+)"));
		System.out.println("greedy mode " + str17.matches("(d)(\\w+)(d)"));
		//28.non-greedy mode
		String str18 = "dxxxdxxxd";
		System.out.println("non-greedy mode " + str18.matches("(d)(\\w+?)"));
		System.out.println("non-greedy mode " + str18.matches("(d)(\\w+?)(d)"));
		
		//29.back reference
		String str19 = "'Hello','World'";
		System.out.println("back reference " + str19.matches("(\'|\")(.*?)(\1)(.*)"));
		String str20 = "aa bb ccccc 999999";
		System.out.println("back reference " + str20.matches("(.*)(\\w)\2{4,}(.*)"));
		String str21 = "<td id='td1' style='bgcolor:white'></td>";
		String str22 = "<td id='td1' style=\"bgcolor:white\"></td>";
		System.out.println("back reference " + str21.matches("<(\\w+)\\s*(\\w+(=(\'|\").*\\4)?\\s*)*>.*?</\\1>"));
		System.out.println("back reference " + str22.matches("<(\\w+)(\\s*)(\\w+(=(\'|\").*\\5)?\\s*)*></\\1>"));
		
		
		//exercise
		//1.postal code
		String e1 = "637000";
		System.out.println("postal code " + e1.matches("^[1-9]\\d{5}$"));
	    //2.QQ number
		String e2 = "1191087021";
		System.out.println("QQ number " + e2.matches("^[1-9]\\d{4,10}$"));
		//3.email
		String e3 = "11eoge@yeah.net";
		String e4 = "zhang.guo.feng@qq.com";
		String ee = "xxx_xxx@xxx-xxx.com.hk";
		String regex1 = "^(\\w)+(\\.\\w+)*@(\\w)+(\\.\\w{2,3}){1,3}";
		String regex2 = "^(\\w)+(\\.\\w+)*@(\\w)+(\\.\\w+)+";
		String regexx = "^(.*)@(.*)+(\\.\\w+)+";
		System.out.println("email " + e3.matches(regex1));
		System.out.println("email " + e4.matches(regex2));
		System.out.println("email " + ee.matches(regexx));
		//4.username
		String e5 = "Xxss__";
		System.out.println("username " + e5.matches("^[A-Za-z]\\w+$"));
		//5.phone number
		String e6 = "15826142583";
		System.out.println("phone number " + e6.matches("^1[3|4|5|7|8]\\d{9}$"));
		//6.url
		String regex3 = "^((http|https):?(//)?)?(\\w+)?(\\.\\w+)*$";
		String e7 = "http://www.zbj.com";
		String e8 = "zbj.com";
		String e9 = "www2.zbj.com.cn.cn";
		String e10 = "http";
		String e11 = "http://";
		System.out.println("url " + e7.matches(regex3));
		System.out.println("url " + e8.matches(regex3));
		System.out.println("url " + e9.matches(regex3));
		System.out.println("url " + e10.matches(regex3));
		System.out.println("url " + e11.matches(regex3));
		//7.ID number
		String regex4 = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$";
		String e12 = "37068519880618730X";
		String e13 = "130634199306097797";
		System.out.println("ID number " + e12.matches(regex4));
		System.out.println("ID number " + e13.matches(regex4));
		//8.one or more Chinese Character
		String regex5 = "^[\u0391-\uFFE5]+$";
		String e14 = "哈哈";
		System.out.println("one or more Chinese Character " + e14.matches(regex5));
	}

}
