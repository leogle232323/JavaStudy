package test;

/**
 * 选择排序 :1.在未排序序列中到最小元素，存放到排序序列的起始位置 2.再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾
 * 3.以此类推，直到所有元素均被排序完成
 */
public class SelectedSort {

	public static void main(String[] args) {
		selectedSort1();
		selectedSort2();
	}

	/**
	 * 选择排序：第一个元素与其后所有元素作比较，选出最小值，放在第一个位置；第二个元素与其后所有元素作比较，选出最小值，放在
	 * 第二个位置...第N-1个元素与其后所有元素作比较，选出最小值，放在第（N-1）个位置
	 * 
	 */
	public static void selectedSort1() {
		int[] arr = { 23, 45, 67, 12, 35, 78, 3, 57, 0, 45, 1, 5, 33, 5, -1, 99, -666 };
		int count = 0;
		int compare = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
					count++;
					compare++;
				} else {
					compare++;
				}
			}
		}
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println("\n交换" + count + "次");
		System.out.println("比较" + compare + "次");
	}

	/**
	 * 选择排序：第一个元素与其后所有元素作比较，选出最小值，放在第一个位置；第二个元素与其后所有元素作比较，选出最小值，放在
	 * 第二个位置...第N-1个元素与其后所有元素作比较，选出最小值，放在第（N-1）个位置。此方法交换次数比较少
	 * 
	 */
	public static void selectedSort2() {
		int[] numbers = { 23, 45, 67, 12, 35, 78, 3, 57, 0, 45, 1, 5, 33, 5, -1, 99, -666 };
		int size = numbers.length;
		int temp = 0;
		int count = 0;
		int compare = 0;
		for (int i = 0; i < size - 1; i++) {
			int k = i;
			for (int j = i + 1; j < size; j++) {
				if (numbers[j] < numbers[k]) {
					k = j;
					compare++;
				} else {
					compare++;
				}

			}

			if (k != i) {
				temp = numbers[i];
				numbers[i] = numbers[k];
				numbers[k] = temp;
				count++;
			}

		}

		for (int j = 0; j < numbers.length; j++) {
			System.out.print(numbers[j] + " ");
		}

		System.out.println("\n交换" + count + "次");
		System.out.println("比较" + compare + "次");
	}
}
