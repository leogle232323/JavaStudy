package project;

import java.util.ArrayList;
import java.util.List;

public class Salary {

	public static void main(String[] args) {
		List<Integer> arrList = new ArrayList<>();
		int june = 5000;
		int july = 5000;
		int august = 5000;
		int september = 3000;
		int october = 5000;
		int november = 5000;
		int december = 3000;
		int thirteen = 5000;
		int january = 5000;
		int february = 5000;

		arrList.add(june);
		arrList.add(july);
		arrList.add(august);
		arrList.add(september);
		arrList.add(october);
		arrList.add(november);
		arrList.add(december);
		arrList.add(thirteen);
		arrList.add(january);
		arrList.add(february);

		int result = 0;
		for (int value : arrList) {
			result += value;
		}

		System.out.println(result);
	}
}
