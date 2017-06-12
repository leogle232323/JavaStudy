package test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GUID {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			UUID uuid = UUID.randomUUID();
			list.add(uuid.toString());
		}

	}

	public static String getGuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}