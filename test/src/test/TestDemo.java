/**
 *某公司有若干车辆，每辆车都有主人属性（String） 、品牌属性（String）和价格属性（int）
 *请统计每个品牌的平均价格，并打印出品牌和它的平均价格（面向对象方式实现，以车为对象）
 */

package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Car {
	private String owner;
	private String brand;
	private int price;

	public Car(String owner, String brand, int price) {
		this.owner = owner;
		this.brand = brand;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public int getPrice() {
		return price;
	}

	public String getOwner() {
		return owner;
	}
}

public class TestDemo {

	public static void main(String[] args) {

		Car car01 = new Car("lily", "奥迪", 1000);
		Car car02 = new Car("lucy", "奥迪", 2000);
		Car car03 = new Car("zhangsan", "奥迪", 3003);
		Car car04 = new Car("lisi", "奔驰", 100120);
		Car car05 = new Car("wangwu", "奔驰", 11000);
		Car car06 = new Car("liuliu", "宝马", 331000);
		Car car07 = new Car("haha", "保时捷", 123000);
		Car car08 = new Car("cici", "法拉利", 144);

		List<Car> listCar = new ArrayList<Car>();
		listCar.add(car01);
		listCar.add(car02);
		listCar.add(car03);
		listCar.add(car04);
		listCar.add(car05);
		listCar.add(car06);
		listCar.add(car07);
		listCar.add(car08);

		// 存储每种车型总价
		Map<String, Integer> map = new HashMap<>();
		// 存储每种车型数量
		Map<String, Integer> carNum = new HashMap<>();
		int price = 0;
		for (Car car : listCar) {
			if (map.containsKey(car.getBrand())) {
				price = map.get(car.getBrand());
				price += car.getPrice();
				map.put(car.getBrand(), price);
				carNum.put(car.getBrand(), carNum.get(car.getBrand()) + 1);
			} else {
				price = car.getPrice();
				map.put(car.getBrand(), price);
				carNum.put(car.getBrand(), 1);
			}
		}

		for (String brand : map.keySet()) {
			System.out.println("brand" + brand + "price" + (double) map.get(brand) / carNum.get(brand));
		}

	}
}