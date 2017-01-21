package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.path.json.JsonPath;

public class StringMatchesClass {
	/**
	 *Verify if a string is type of date 
	 *@param date a String
	 *@return true if date is type of date,false if date is not type of date
	 */
	static boolean isDate(String date){
		return date.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2}");
	}
	public static void main(String[] args) {
		//Three way 
		//1.String.matches()
		String date = "2014-02-01";
		System.out.println(date);
		System.out.println(isDate(date));
		
		//2.Pattern.matches()
		boolean patternBoolean =  Pattern.matches("\\d{4}\\-\\d{1,2}-\\d{1,2}", date);
		System.out.println(patternBoolean);
		
		//3.Matcher
		Pattern p = Pattern.compile("\\d{4}\\-\\d{1,2}-\\d{1,2}");
		Matcher m = p.matcher(date);
		boolean matcherBoolean = m.matches();
		System.out.println(matcherBoolean);
		System.out.println(m.toMatchResult());

	}
}
