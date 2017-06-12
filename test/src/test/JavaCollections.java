package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaCollections {

	public static void main(String[] args) {
		// 1.List ArrayList
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(1);
		al.add('h');
		al.add("haahha");
		al.add(1l);
		al.add(22d);

		System.out.println(al);

		// 2.frequency
		String text = "a a b c d e f g b b c d e f g g e c c d e h";
		List<String> list = new ArrayList<>();
		// 拆分字符串，结果为字符串数组
		String[] arr = text.split(" ");
		// 将字符串数组转换为list
		list = Arrays.asList(arr);
		// list.addAll(Arrays.asList(arr));

		// set集中元素不可重复
		Set<String> set = new HashSet<>(list);
		for (String word : set) {
			// Collections.frequency 判断集合中某元素出现次数
			System.out.println(word + ":" + Collections.frequency(list, word));
		}

	}

}
