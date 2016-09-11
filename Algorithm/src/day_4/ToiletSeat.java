package day_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToiletSeat {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("D:\\input_toilet_seat.txt"));
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toCharArray();
		int length = input.length;
		int policy1 = 0, policy2 = 0, policy3 = 0;
		if (length >= 2 || length <= 1000) {
			policy1 = policy1(input);
			policy2 = policy2(input);
			policy3 = policy3(input);
		}
		System.out.println(policy1);
		System.out.println(policy2);
		System.out.println(policy3);
		scanner.close();
	}

	public static int policy1(char[] input) {
		int count = 0;
		if (input[0] == 'D' && input[1] == 'U') {
			count++;
		} else if (input[0] == 'D' && input[1] == 'D') {
			count--;
		}
		for (int i = 1; i < input.length; i++) {
			if (input[i] == 'D') {
				count += 2;
			}
		}
		return count;
	}

	public static int policy2(char[] input) {
		int count = 0;
		if (input[0] == 'U' && input[1] == 'U') {
			count--;
		} else if (input[0] == 'U' && input[1] == 'D') {
			count++;
		}
		for (int i = 1; i < input.length; i++) {
			if (input[i] == 'U') {
				count += 2;
			}
		}
		return count;
	}

	public static int policy3(char[] input) {
		int count = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[i - 1] == 'U' && input[i] == 'D') {
				count++;
			} else if (input[i - 1] == 'D' && input[i] == 'U') {
				count++;
			}
		}
		return count;
	}
}