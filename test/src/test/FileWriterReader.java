package test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {
	public static void main(String[] args) throws IOException{
		//1.FileWriter
		FileWriter fw = new FileWriter("e:\\fileWriter.txt", true);
		fw.write("\r\nHe is a giant!");
		fw.flush();
		fw.close();
		
		//2.FileReader
		FileReader fr = new FileReader("e:\\fileWriter.txt");
		int ch = 0;
		while((ch = fr.read()) != -1){
			System.out.print((char)ch);
		}
		fr.close();
		
		//3.copy file
		FileWriter fwCopy = new FileWriter("e:\\fileWriterCopy.txt", true);
		File fileReader = new File("e:\\fileReaderCopy.txt");
		if(!fileReader.exists()){
			fileReader.createNewFile();
		}
		FileReader frCopy = new FileReader(fileReader);
		//read an array size, write an array size
		char[] buf = new char[1024];
		int len = 0;
		while((len = frCopy.read(buf)) != -1){
			fwCopy.write(buf, 0, len);
		}
		frCopy.close();
		fwCopy.close();

	}
}
