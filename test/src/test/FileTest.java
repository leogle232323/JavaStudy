package test;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		System.out.println(System.getProperty("user.dir"));
		File f = new File("F:\\Test");
		f.mkdir();//1.创建目录
	    File f1 = File.createTempFile("pre", "suf");//默认路径下创建文件
	    File f2 = File.createTempFile("pre", "suf", f);//指定路径下创建文件
	    System.out.println(f1.getAbsolutePath());
	    System.out.println(f2.getAbsolutePath());
	    
	    //2.创建多级目录
	    File fm = new File("F:\\Test1\\test\\test");
	    fm.mkdirs();
	}
}
