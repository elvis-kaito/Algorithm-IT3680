package spoj;

import java.util.Scanner;

public class CharacterPatterns1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCase = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < numberOfTestCase; i++) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			for (int j = 0; j < row; j++) {
				for(int k = 0; k < col; k++){
					if (j % 2 == 0) {
						if (k % 2 == 0) {
							System.out.print("*");
						} else {
							System.out.print(".");
						}
					} else {
						if (k % 2 == 0) {
							System.out.print(".");
						} else {
							System.out.print("*");
						}
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		scanner.close();
	}

}
