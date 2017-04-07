package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapTest {
	private static final Map<String, String> map1 = new HashMap<String, String>();
	public static void main(String[] args){
		//1.将map转换为list
		Map<String,String> m = new HashMap<String, String>();
		m.put("key1", "value1");
		m.put("key2", "value2");
		m.put("key3", "value3");
		m.put("key0", "value0");
		
		//TreeMap 根据key排序
		Map<String,String> m1 = new TreeMap<String,String>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		
		//key list 
		List<String> keyList = new ArrayList<String>(m.keySet());
		System.out.println(keyList);
		
		//value list
		List<String> valueList = new ArrayList<String>(m.values());
		System.out.println(valueList);		
		
		//key-value list
		List<Entry<String, String>> entryList = new ArrayList<Entry<String,String>>(m.entrySet());
		System.out.println(entryList);
		
		//2.通过entry遍历map
		System.out.println("entry遍历map");
		for(Entry<String, String> entry : m.entrySet()){
			System.out.print(entry.getKey());
			System.out.print(entry.getValue());
		}
		System.out.println();
		
		//遍历输出key
		for(String key : m.keySet()){
			System.out.print(key);
		}
		
		//遍历输出value
		for(String value : m.values()){
			System.out.print(value);
		}
		
		//iterator遍历map
		System.out.println("\niterator遍历map");
		Iterator<Entry<String,String>> it = m.entrySet().iterator();
		Entry<String,String> entry;
		while(it.hasNext()){
		    entry = it.next();
			System.out.print(entry.getKey());
			System.out.print(entry.getValue());
		}
		System.out.println();
		
		//iterator遍历key
		System.out.println("iterator遍历key");
		Iterator<String> itKey = m.keySet().iterator();
		while(itKey.hasNext()){
			System.out.print(itKey.next());
		}
		
		//iterator遍历value
		System.out.println("\niterator遍历value");
		Iterator<String> itValue = m.values().iterator();
		while(itValue.hasNext()){
			System.out.print(itValue.next());
		}
		
		//3.通过key对map进行排序
		//comparator进行排序

		System.out.println("\n通过key对map排序");
		System.out.println("comparator进行排序");
		Collections.sort(entryList, new Comparator<Entry<String,String>>(){
			
			@Override
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				return e1.getKey().compareTo(e2.getKey());
			}
			
		});
		
		System.out.println(entryList);
		
		//SortedMap进行排序，需要实现Comparable接口
		System.out.println("sortedMap进行排序，需要实现comparable接口");
		System.out.println("排序前");
		m.put("akey", "avalue");
		System.out.println(m);
		SortedMap<String, String> sortedMap = new TreeMap<String, String>(new Comparator<String>(){


			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
			
		});
		sortedMap.putAll(m);
		System.out.println("排序后");
		System.out.println(sortedMap);
		
		//4.通过value对map排序
		System.out.println("通过value对map排序");
		m.put("bkey", "bvalue");
		System.out.println("排序前");
		System.out.println(m);
		//collections   value排序
		Collections.sort(valueList, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		//list value 排序
		valueList.sort(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		
		Collections.sort(entryList, new Comparator<Entry<String,String>>(){

			@Override
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
			
		});
		System.out.println("排序后\n" + m);
		
		//4.初始化一个static的常量map
		//final实现不可变map
//		map1.put("sfkey", "sfvalue");
		
		//collections.unmodifiableMap方式实现
//		System.out.println("不可变map");
//		Map<String, String> um = Collections.unmodifiableMap(m);
//		um.put("ukey", "uvalue");
		
		//5.hashmap、treemap、hashtable之间的不同
		
		//6.map中的反向查询
		
		//7.map的复制
		System.out.println("map的复制,synchronizedMap实现复制map与原map同步");
		Map<String, String> copiedMap = Collections.synchronizedMap(m);
		System.out.println("添加值之前\n" + copiedMap);
		m.put("sykey", "syvalue");
		System.out.println("添加值之后\n" + copiedMap);
		
		//8.创建一个空的map
		System.out.println("输出空map");
		Map<Object, Object> eMap = Collections.emptyMap();
//		eMap.put("haha", "heh");
		System.out.println(eMap);
		
		//list排序
		System.out.println(entryList);
		entryList.sort(new Comparator<Entry<String,String>>(){

			@Override
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				return e1.getKey().compareTo(e2.getKey());
			}
			
		});
		System.out.println(entryList);
		
		//9.map删除元素
		m.remove("key1");
		System.out.println(m);
		

	}
}
