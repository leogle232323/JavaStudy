package test;

/**
 * 选择排序： 1.在未排序序列中招到最小元素，存放到排序序列的起始位置 2.再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾
 * 3.以此类推，直到所有元素均被排序完成
 */
public class SelectedSort {

	public static void main(String[] args) {
		int[] numbers = { 23, 45, 67, 12, 35, 78, 3, 57, 0, 45 };
		int size = numbers.length;
		int temp = 0;
		int count = 0;
		for (int i = 0; i < size; i++) {
			int k = i;
			for (int j = size - 1; j > i; j--) {
				if (numbers[j] < numbers[k])
					k = j;
			}
			temp = numbers[i];
			numbers[i] = numbers[k];
			numbers[k] = temp;
			count++;
		}

		for (int j = 0; j < numbers.length; j++) {
			System.out.print(numbers[j] + " ");
		}

		System.out.println("\n交换" + count + "次");
	}

}
