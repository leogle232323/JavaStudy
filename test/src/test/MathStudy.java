package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MathStudy {

	public static void main(String[] args) {
		// 1.random()，生成[0,1)的数
		double d = Math.random();
		System.out.println(d);

		// 生成1000个在[5,15)的整数，计数每个整数出现的次数
		Map<Integer, Integer> mp = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			int j = 5 + (int) (Math.random() * 10);
			// 1.map方式计数
			if (mp.containsKey(j)) {
				mp.put(j, mp.get(j) + 1);
			} else {
				mp.put(j, 1);
			}
			// list存储
			list.add(j);
		}

		System.out.println("map计数");
		for (Entry<Integer, Integer> entry : mp.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		// 2.set与list结合计数
		Set<Integer> set = new HashSet<>(list);
		System.out.println("list与set计数");
		for (int value : set) {
			System.out.println(value + ":" + Collections.frequency(list, value));
		}

		// 2.求平方根
		System.out.println(Math.sqrt(1));

		// 3.m的n次方
		System.out.println(Math.pow(2, 3));

		// 4.绝对值
		System.out.println(Math.abs(-111));

		// 5.四舍五入
		System.out.println(Math.round(4.4999));

		// 6.PI
		double r = 2.5;
		double s = Math.PI * r * r;
		System.out.println(s);
	}

}
