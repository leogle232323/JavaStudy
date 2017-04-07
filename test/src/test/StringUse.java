package test;

public class StringUse {

	public static void main(String[] args) {
		//1.length of string
		char chars[] = {'a','b','c'};
		String s = new String(chars);
		int len = s.length();
		System.out.println(s + len);
		//2.interception of a character
		char c = s.charAt(0);
		System.out.println(c);
		//3.interception of characters
		String s1 = "this scenery is very beautiful   ";
		char buf[] = new char[20];
		s1.getChars(1, 10, buf, 2);
		System.out.println(buf);
		//4.getBytes()
		byte b[] = s1.getBytes();
		System.out.println(b[1]);
		//5.equals
		System.out.println(s.equals(s1));
		//6.equalsIgnoreCase
		System.out.println(s.equalsIgnoreCase(s1));
		//7.substring
		System.out.println(s1.substring(10));
		System.out.println(s1.substring(1, 10));
		//8.indexOf
		System.out.println(s1.indexOf(97));
	    System.out.println(s1.indexOf("is"));
	    System.out.println(s1.indexOf(97, 23));
	    System.out.println(s1.indexOf("is", 3));
	    //9.trim
	    String s2 = s1.trim();
	    System.out.println(s1);
	    System.out.println(s2);
	    //10.isEmpty
	    System.out.println(s1.isEmpty());
	    //11.contains
	    System.out.println(s1.contains(s2));
	    //12.compareTo
	    System.out.println(s1.compareTo(s2));
	    //13.compareToIgnore
	    System.out.println(s1.compareToIgnoreCase(s2));
	    //14.replace
	    String news1 = s1.replace('i', 'I');
	    System.out.println(news1);
	    System.out.println(s1.replace("this", "THIS"));
	    //15.split
	    String arrays[] = s1.split(" ");
	    System.out.println(arrays[0]);
	}

}
