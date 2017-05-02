package test;

public class PrintRhombus {

	public static void main(String[] args) {
		printEmptyRhombus();
		printSolidRhombus();
	}

	public static void printEmptyRhombus() {
		int hangshu = 11;
		int yiban = hangshu / 2 + 1;
		int yibanduo = hangshu / 2;
		System.out.println("空心菱形：");
		for (int k = 1; k <= yiban; k++) {
			for (int i = 1; i <= (yiban - k); i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int i = 1; i <= ((k - 2) * 2 + 1); i++) {
				System.out.print(" ");
			}
			if (k != 1) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int k = yibanduo; k >= 1; k--) {
			for (int i = 1; i <= (yiban - k); i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int i = 1; i <= ((k - 2) * 2 + 1); i++) {
				System.out.print(" ");
			}
			if (k != 1) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void printSolidRhombus() {
		int hangshu = 11;
		System.out.println("实心菱形：");
		for (int i = 1; i <= hangshu; i++) {
			if (i <= hangshu / 2 + 1) {
				for (int k = 1; k <= hangshu / 2 + 1 - i; k++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= i; k++) {
					System.out.print("* ");
				}
				System.out.println();
			} else {
				for (int k = 1; k <= (i - (hangshu / 2 + 1)); k++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= (2 * (hangshu / 2 + 1) - i); k++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
	}
}