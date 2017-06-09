package test;

/**
 * 冒泡排序:依次比较相邻的两个元素，将小数放在前面，大数放在后面。 N个数字要完成排序，总共要进行N-1趟,每趟排序N-i次
 */
public class BubbleSort {
	public static void main(String[] args) {
		bubbleSort();
	}

	public static void bubbleSort() {
		int[] arr = { 23, 45, 67, 12, 35, 78, 3, 57, 0, 45, 1, 5, 33, 5, -1, 99, -666 };
		int count = 0;
		int compare = 0;
		for (int i = 0; i < arr.length - 1; i++) {// 外层循环控制排序趟数
			for (int j = 0; j < arr.length - i - 1; j++) {// 内层循环控制每一趟排序多少次
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					compare++;
					count++;
				} else {
					compare++;
				}
			}
		}

		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println("\n交换" + count + "次");
		System.out.println("比较" + compare + "次");
	}
}
