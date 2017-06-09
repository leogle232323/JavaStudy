package test;

public class TwoDimentionalArray {

	public static void main(String[] args) {
		int[][] arr = { { 2, 3 }, { 4, 5, 6 } };
		int[][] arr1 = new int[][] { { 1, 3 }, { 2, 3, 4 } };

		// foreach循环遍历输出二维数组
		for (int x[] : arr) {
			for (int a : x) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

		for (int x[] : arr1) {
			for (int a : x) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}
}
