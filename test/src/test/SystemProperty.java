package test;

import java.util.Properties;

public class SystemProperty {
	public static void main(String[] args){
		//系统属性
		Properties sysProperty = System.getProperties();
		String str = sysProperty.toString();
		String[] strSplit = str.split("\\,");
		for(int i = 0;i < strSplit.length;i++){
			System.err.println(strSplit[i]);
		}
		
		System.err.println("测试git提交");
		
	}
}
