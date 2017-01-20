package test;

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
		String date = "2014-02-01";
		System.out.println(isDate(date));
		
	}
}
