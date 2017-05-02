package test;

import java.util.UUID;

public class GUID {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
	}

	public static String getGuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}