package day_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class InitInput {
	public static final String PATH_FILE = "/home/namtran/Documents/Algorithm SS2016/input_sequence.txt";

	public static void main(String[] args) throws IOException {
		Scanner inp = new Scanner(System.in);
		System.out.print("Nhập số phần tử: ");
		int numberOfInteger = inp.nextInt();
		inp.close();
		try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_FILE, false), true)) {
			writer.println(numberOfInteger);
			Random random = new Random();
			for (int i = 0; i < numberOfInteger; i++) {
				String token = "";
				token += random.nextInt();
				if (i != numberOfInteger - 1) {
					token += ", ";
				}
				writer.print(token);
			}
			System.out.println("Done");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}
