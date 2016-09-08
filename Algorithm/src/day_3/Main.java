package day_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		float[] inp = new float[n];
		for (int i = 0; i < n; i++) {
			inp[i] = scanner.nextFloat();
		}
		scanner.close();

		sort(inp, 0, inp.length - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(inp[i] + " ");
		}
	}
	public static void sort(float a[], int left, int right) {
		int i = left, j = right;
		float x = a[(left + right) / 2];
		do {
			// tìm phần tử sai vị trí
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			// Hoán đổi nếu i nằm trước j
			if (i <= j) {
				float temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		} while (i < j);
		if (left < j) {
			sort(a, left, j);
		}
		if (right > i) {
			sort(a, i, right);
		}
	}
	public static void sort(float[] a, int n) {
		int gap = n;
		float shrink = 1.3f;
		boolean sorted = false;

		while (gap > 1 || sorted == false) {
			// Update the gap value for a next comb
			gap = (int) (gap / shrink);
			if (gap < 1) {
				gap = 1;
			}
			int i = 0;
			if (gap == 1) {
				sorted = true;
			}

			// A single " comb " over the input list
			while (i + gap < n) {
				if (a[i] > a[i + gap]) {
					float temp = a[i];
					a[i] = a[i + gap];
					a[i + gap] = temp;
					if (gap == 1) {
						sorted = false;
					}
				}
				i++;
			}
		}
	}
}