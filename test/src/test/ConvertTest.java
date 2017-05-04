package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * map、list、set、数组之间转换
 */
public class ConvertTest {
	static Map<String, String> mp = new HashMap<>();
	static List<String> list = new ArrayList<>();
	static Set<String> set = new HashSet<>();
	static {
		mp.put("key1", "value1");
		mp.put("key2", "value2");
		mp.put("key3", "value3");
		mp.put("key4", "value4");
		mp.put(null, "value4");

		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");

		set.add("hhh");
		set.add("enenene");
		set.add("eonj");
		set.add("nljljl");
	}

	public static void main(String[] args) {
		mapToList();
		mapToSet();

		arrayToSet();
		setToArray();

		listToSet();
		setToList();

		listToArray();
		arrayToList();
	}

	public static void mapToList() {
		// 1.将key转换为List
		List<String> listKey = new ArrayList<>(mp.keySet());
		System.out.println("mapkey转换为list:" + listKey);

		// 2.将value转换为List
		List<String> listValue = new ArrayList<>(mp.values());
		System.out.println("mapvalue转换为list:" + listValue);

		// 3.将key-value转换为List
		List<Entry<String, String>> listKeyValue = new ArrayList<>(mp.entrySet());
		System.out.println("mapkeyvalue转换为list:" + listKeyValue);
	}

	public static void mapToSet() {
		// 1.将key转换为Set
		Set<String> setKey = new HashSet<>(mp.keySet());
		System.out.println("mapkey转换为set:" + setKey);

		// 2.将value转换为Set
		Set<String> setValue = new HashSet<>(mp.values());
		System.out.println("mapvalue转换为set:" + setValue);

		// 3.将key-value转换为Set
		Set<Entry<String, String>> setKeyValue = new HashSet<>(mp.entrySet());
		System.out.println("mapkeyvalue转换为set:" + setKeyValue);
	}

	public static void arrayToSet() {
		String[] arr = { "aa", "bb", "cc", "dd", "ee" };
		Set<String> set = new HashSet<>(Arrays.asList(arr));
		System.out.println("数组转换为set:" + set);
	}

	public static void setToArray() {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		set.add("dd");

		String[] arr = new String[set.size()];
		set.toArray(arr);
		System.out.println("set转换为数组:" + Arrays.toString(arr));
		System.out.println(arr[0]);
	}

	public static void listToSet() {
		Set<String> set = new HashSet<String>(list);
		System.out.println("将list转换为set:" + set);
	}

	public static void setToList() {
		List<String> list = new ArrayList<>(set);
		System.out.println("将set转换为list:" + list);
	}

	public static void listToArray() {
		Object[] arr = list.toArray();
		System.out.println("list转换为array:" + arr[0]);
	}

	public static void arrayToList() {
		String[] arr = { "aaa", "bbb", "ccc" };
		List<String> list = Arrays.asList(arr);
		System.out.println("array转换为list" + list);
	}

}
