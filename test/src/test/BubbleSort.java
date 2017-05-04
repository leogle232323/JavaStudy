package test;

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
		System.out.println("\n比较" + count + "次");
	}
}
