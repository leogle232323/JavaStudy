package test;

public class TwoDimentionalArray {

	public static void main(String[] args) {
		int[][] arr = { { 2, 3 }, { 4, 5 } };
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

		// for循环遍历输出二维数组
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

		// for循环按列输出二维数组
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}
}
