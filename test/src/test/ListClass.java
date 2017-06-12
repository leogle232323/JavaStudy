package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List集合运用
 * 
 */
public class ListClass {
	public static void main(String[] args) {
		// 1.list中添加、获取、删除元素
		List<String> list = new ArrayList<>();
		list.add("value1");
		list.add("value2");
		list.add("value3");
		list.add("value4");
		list.add("value5");
		list.add("value5");

		System.out.println(list);
		System.out.println("List中第二个元素是：" + list.get(1));

		// 按照index删除元素
		list.remove(1);
		System.out.println("删除List中第二个元素之后，List内容为" + list);
		// 按照元素内容删除元素
		list.remove("value1");
		System.out.println("删除List中第一个元素之后，List内容为" + list);

		// 2.List中是否有包含某个元素 .contains(Object o)
		if (list.contains("value5")) {
			System.out.println("List中包含元素value5");
		}

		// 3.List中根据索引值将元素值改变（替换）
		list.set(0, "value1");
		System.out.println("替换位置1的值为value1之后的list为 " + list);
		list.add(0, "addvalue1");
		System.out.println("添加值addvalue1在位置1之后的list为" + list);

		// 4.List中查看（判断）元素的索引
		System.out.println("元素值value5首次出现的索引位置为" + list.indexOf("value5"));
		System.out.println("元素值value5最后一次出现的索引位置为" + list.lastIndexOf("value5"));

		// 5.截取子list .subList(fromIndex,toIndex) [fromIndex,toIndex)
		System.out.println(list.subList(1, 3));

		// for方法遍历list
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		// 6.对比两个list中的所有元素
		List<String> list2 = new ArrayList<>();
		list2.addAll(list);
		System.out.println(list2);
		if (list.equals(list2)) {
			System.out.println("list和list2中所有元素相同");
		} else {
			System.out.println("list和list2中所有元素不一样");
		}

		if (list.hashCode() == list2.hashCode()) {
			System.out.println("我们相等");
		} else {
			System.out.println("我们不相等");
		}
		// 7.判断list是否为空
		if (list.isEmpty()) {
			System.out.println("list为空");
		} else {
			System.out.println("list不为空");
		}

		// 8.将集合转换为字符串
		System.out.println("集合list转换为字符串：" + list.toString());

		// 9.将集合转换为数组
		System.out.println("集合list转换为数组：" + list.toArray()[0]);

		// 10.集合类型转换
		// 默认类型
		List<Object> listO = new ArrayList<>();
		for (int i = 0; i < listO.size(); i++) {
			listO.add(list.get(i));
		}

		// 指定类型
		List<StringBuffer> listS = new ArrayList<>();
		for (String str : list) {
			listS.add(new StringBuffer(str));
		}

		// 11.去重复
		// 方法一
		System.out.println("去重之前" + list);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
				}
			}
		}

		System.out.println("去重之后" + list);

		// 方法二
		list.add("value1");
		System.out.println("去重之前为" + list);
		List<String> list3 = new ArrayList<>();
		for (String str : list) {
			if (Collections.frequency(list3, str) < 1) {// str在集合list3中未出现过，则添加进去
				list3.add(str);
			}
		}

		System.out.println("去重之后为" + list);

	}
}
