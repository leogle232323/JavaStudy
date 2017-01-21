package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintStackTrace {

	public static void main(String[] args) {
		File file = new File("e:\\test.txt");
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		FileWriter fileWriter = null;
		try {
			 fileWriter = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		try {
			bufferedWriter.write("This is the first line.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close BufferedWriter
		try {
			bufferedWriter.close();
			System.out.println("Write success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Write failed");
			e.printStackTrace();
		}
		//close FileWriter
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
