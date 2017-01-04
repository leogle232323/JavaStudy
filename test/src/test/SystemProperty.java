package test;

import java.util.Properties;

public class SystemProperty {
	public static void main(String[] args){
		//系统属性
		Properties sysProperty = System.getProperties();
		String str = sysProperty.toString();
		String[] strSplit = str.split("\\,");
		for(int i = 0;i < strSplit.length;i++){
			System.out.println(strSplit[i]);
		}
		
		System.out.println("merge分支");
	}
}
