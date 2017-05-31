package test;

/**
 * 冒泡排序： 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。 2.
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 23, 45, 67, 12, 35, 78, 3, 57, 0, 45 };
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
					count++;
				}
			}
		}
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println("\n交换" + count + "次");
	}
}
