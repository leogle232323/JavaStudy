package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterReader {

	public static void main(String[] args) throws IOException {
		//1.BufferedWriter
		FileWriter fileWriter = new FileWriter("e:\\bufferedWriter.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("Hello world !");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		bufferedWriter.close();
		
		//2.BufferedReader
		File file = new File("e:\\bufferedReader.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		FileWriter fileWriterCopy = new FileWriter("e:\\bufferedWriterCopy.txt", true); 
		BufferedWriter bufferedWriterCopy = new BufferedWriter(fileWriterCopy);
		String line = null;
		while((line = bufferedReader.readLine()) != null){
			System.out.println(line);
			bufferedWriterCopy.write(line);
			bufferedWriterCopy.newLine();
			bufferedWriterCopy.flush();
		}
		bufferedReader.close();
		bufferedWriterCopy.close();
	}
}
