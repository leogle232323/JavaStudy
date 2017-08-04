package test;

import java.util.HashMap;
import java.util.Map;

public class NullStudy {
	static Object obj;

	private static void iAmStaticMethod() {
		System.out.println("I am static method, can be called by null reference!");
	}

	private void iAmNonStaticMethod() {
		System.out.println("I am non static method, don't date to call me by null!");
	}

	public static void main(String[] args) {
		System.out.println(obj);

		// 1.自动拆箱导致空指针异常
		try {
			Integer I1 = null;
			int i = I1;
			System.out.println(i);
		} catch (Exception e) {
			System.out.println("1.自动拆箱导致空指针异常！");
		}

		// 规避方法instanceof
		Integer I2 = null;
		int i2;
		if (I2 instanceof Integer) {
			i2 = I2;
			System.out.println(i2);
		} else {
			System.out.println("I2为null！");
		}

		// 2.自动装箱导致空指针异常
		Map<Integer, Integer> mp = new HashMap<>();
		try {
			int[] numbers = { 1, 3, 3, 4, 5, 3, 8, 5, 10, 1, 10, 3, 10 };
			for (int in : numbers) {
				// int count = mp.get(in);
				// mp.put(in, count++);
				// 规避代码
				// if (mp.get(in) instanceof Integer) {
				// int count = mp.get(in);
				// mp.put(in, ++count);
				// } else {
				// mp.put(in, 1);
				// }
				// 正确方法
				// if (mp.get(in) == null) {
				// mp.put(in, 1);
				// } else {
				// mp.put(in, mp.get(in) + 1);
				// }

				// containsKey方法
				if (mp.containsKey(in)) {
					mp.put(in, mp.get(in) + 1);
				} else {
					mp.put(in, 1);
				}
			}
		} catch (Exception e) {
			System.out.println("2.自动装箱导致空指针异常！");
		} finally {
			System.out.println("输出map:" + mp);
		}

		// 3.instanceof运用（检查类型强制转换）
		Integer isNull = null;
		if (isNull instanceof Integer) {
			System.out.println("isNull is instance of Integer");
		} else {
			System.out.println("isNull is not instance of Integer");
		}

		// 4.值为null的引用型变量可以调用静态方法，不能调用非静态方法（静态方法使用静态绑定）
		try {
			NullStudy ns = null;
			ns.iAmStaticMethod();// 静态方法调用null引用
			ns.iAmNonStaticMethod();// 非静态方法调用null引用
		} catch (Exception e) {
			System.out.println("4.使用非静态方法调用值为null的引用型变量报错，空指针异常！");
		}

		// 5.null比较，仅可使用==或!=操作比较null值
		String str1 = null;
		String str2 = null;
		Object o1 = null;
		Integer IN = null;
		Boolean B = null;
		// null == null
		if (str1 == str2) {
			System.out.println("null == null is true in Java!");
		}
		// null != null
		if (!(null != null)) {
			System.out.println("null != null is false in Java!");
		}
		// Object null == String null
		if (o1 == str1) {
			System.out.println("Object null == String null is true in Java!");
		}
		// Object null == Boolean null
		if (B == o1) {
			System.out.println("Object null == Boolean null is true in Java!");
		}
	}
}
