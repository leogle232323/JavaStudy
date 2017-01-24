package test;

import java.io.IOException;

public class RuntimeClass {

	public static void main(String[] args) throws IOException {
		//1.Execute external program(Call external command)
		String cmd = "cmd /k notepad E:\\test1.txt";
		Runtime.getRuntime().exec(cmd);
		
		//2.Memory management
		Runtime r = Runtime.getRuntime();
		long mem1,mem2;
		Integer[] someIntegers = new Integer[1000];
		System.out.println("Total memory is : " + r.totalMemory());
		mem1 = r.freeMemory();
		System.out.println("Inital free memory is :" + mem1);
		r.gc();
		mem1 = r.freeMemory();
		System.out.println("Free memory after garbage collection is :" + mem1);
		//allocate integers
		for(int i = 0;i < 1000;i++){
			someIntegers[i] = new Integer(i);
		}
		mem2 = r.freeMemory();
		System.out.println("Free memory after allocation is :" + mem2);
		System.out.println("Memory used by allocation :" + (mem1 - mem2));
		//discard integers
		for(int i = 0;i < 1000;i++) someIntegers[i] = null;
		r.gc();
		mem2 = r.freeMemory();
		System.out.println("Free memory after collecting discarded integers is :" + mem2);
	}

}
