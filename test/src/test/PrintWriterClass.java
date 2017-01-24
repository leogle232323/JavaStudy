package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterClass {

	public static void main(String[] args) {
		PrintWriter pw = null;
		String name = "leogle";
		int age = 25;
		float score = 55.55f;
		char sex = '男';
		try {
			pw = new PrintWriter(new File("e:\\printWriter.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pw.printf("姓名：%s;年龄：%d,分数：%f,性别：%c", name,age,score,sex);
		pw.close();
	}

}
