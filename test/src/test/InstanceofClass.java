package test;

class Animal {
};

class Dog extends Animal {
	public void loyal() {
		System.out.println("dog is loyal!");
	};
};

class LazyDog extends Dog {
	public void lazy() {
		System.out.println("cat is lazy!");
	};
};

public class InstanceofClass {
	public static void main(String[] args) {
		Animal d1 = new Dog();
		if (d1 instanceof Dog) {
			// loyal方法只在Dog类中存在
			((Dog) d1).loyal();
		}

		// 值为null的引用对象不是任何对象的实例
		Animal d2 = null;
		System.out.println(d2 instanceof Animal);
		System.out.println(d2 instanceof Dog);
		System.out.println(d2 instanceof LazyDog);
		System.out.println(d2 instanceof Object);

		// 值为非null引用对象
		LazyDog d3 = new LazyDog();
		System.out.println(d3 instanceof LazyDog);
		System.out.println(d3 instanceof Dog);
		System.out.println(d3 instanceof Animal);
		System.out.println(d3 instanceof Object);

	}
}
