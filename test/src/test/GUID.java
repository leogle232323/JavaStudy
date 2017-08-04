package test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GUID {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(getGuid());
		}
		System.out.println(list);
	}

	public static String getGuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}