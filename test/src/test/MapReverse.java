package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/***
 * 遍历map，通过value查找key
 */
public class MapReverse {
	Map<Object, Object> map;

	public MapReverse(Map<Object, Object> map) {
		this.map = map;
	}

	// 获取map中指定value的key
	public ArrayList<Object> getKey(Object value) {
		ArrayList<Object> keyList = new ArrayList<Object>();
		for (Entry<Object, Object> entry : map.entrySet()) {
			if (entry.getValue().equals(value)) {
				keyList.add(entry.getKey());
			}
		}
		return keyList;
	}

	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("key1", "value1");
		m.put("key2", "value2");
		m.put("key3", "value3");
		m.put("key4", "value1");

		MapReverse ms = new MapReverse(m);
		System.out.println(ms.getKey("value1").toArray()[1]);
	}
}
