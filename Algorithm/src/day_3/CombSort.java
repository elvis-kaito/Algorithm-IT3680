package day_3;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class CombSort {
	public static final String PATH_INPUT_FILE = "combsort.inp";
	public static final String PATH_OUTPUT_FILE = "combsort.out";
	private static int DISK_BLOCK_SIZE = 4096;

	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		try {
			FileInputStream fis = new FileInputStream(PATH_INPUT_FILE);
			BufferedInputStream bis = new BufferedInputStream(fis, DISK_BLOCK_SIZE);
			DataInputStream dis = new DataInputStream(bis);
			Scanner scanner = new Scanner(dis);
			scanner.useDelimiter(" ");
			int n = Integer.parseInt(scanner.nextLine());
			float[] inp = new float[n];
			for (int i = 0; i < n; i++) {
				inp[i] = scanner.nextFloat();
			}
			scanner.close();

			sort(inp, inp.length);
			FileWriter fw = new FileWriter(PATH_OUTPUT_FILE);
			BufferedWriter bw = new BufferedWriter(fw, DISK_BLOCK_SIZE);
			for (int i = 0; i < n; i++) {
				bw.write(String.valueOf(inp[i]));
				if (i != n - 1) {
					bw.write(" ");
				}
			}
			bw.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime + "ms");
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