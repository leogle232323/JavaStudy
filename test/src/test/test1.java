package test;

import javax.swing.JFrame;

public class test1 {
	public static void main(String[] args) {
		String[] split = JFrame.class.getName().split("\\.");
		System.out.println(split[split.length - 1]);
		System.out.println(JFrame.class.getName().replace(split[split.length - 1], "ad.Ad" + split[split.length - 1]));
		System.out.println(int.class == Integer.TYPE);
		try {
			String s = String.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Object o = null;
		try {
			try {
				o = Class.forName("java.lang.Object").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(o.toString());
	}
}
