package week_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Nam Tran
 *         <p>
 *         Code tham khảo trên mạng.
 *         <p>
 *         Tư tưởng bài toán là đi tìm kích cỡ 1 miếng bánh lớn nhất để chia đủ
 *         số bánh cho mọi người.
 *         Ta sẽ chọn 1 số làm kích cỡ 1 miếng bánh, rồi kiểm tra có chia đủ số
 *         miếng bánh ko.
 *         Nếu đủ ta gán nó cho 1 biến lưu kích cỡ thỏa mãn, nếu ko ta gán cho 1
 *         biến lưu kích cỡ max của 1 miếng bánh.
 *         <p>
 *         Độ phức tạp thuật toán: O(n)
 */
public class Pie {
	static int numberOfFriend;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCases; i++) {
			// input
			String[] line1 = reader.readLine().split(" ");
			int numberOfPie = Integer.parseInt(line1[0]);
			numberOfFriend = Integer.parseInt(line1[1]) + 1;

			double[] radii = new double[numberOfPie];
			String[] line2 = reader.readLine().split(" ");
			double max = 0; // Chiếc bánh to nhất
			for (int j = 0; j < numberOfPie; j++) {
				radii[j] = Integer.parseInt(line2[j]);
				radii[j] *= radii[j] * Math.PI;
				max = max > radii[j] ? max : radii[j];
			}

			caculate(radii, max);
		}
	}

	// Tính toán rồi hiển thị ra màn hình
	static void caculate(double[] a, double max) {
		double volume = 0; // Thể tích miếng bánh
		while (max - volume > 0.0000001) { // Do làm tròn 6 chữ số sau dấu "," nên cần để > 0.0000001
			double mid = (max + volume) / 2;
			if (isValid(mid, a)) {
				volume = mid;
			} else {
				max = mid;
			}
		}
		System.out.format("%f\n", volume);
	}

	// Kiểm tra thể tích 1 miếng bánh (sizeOfPiece) thì chia ra có đủ số bánh cho mọi người (numberOfFriend) ko
	static boolean isValid(double sizeOfPiece, double[] a) {
		int numberOfPiece = 0; // Số miếng bánh
		for (int i = 0; i < a.length; i++) {
			numberOfPiece += (int) (a[i] / sizeOfPiece); // Phải ép kiểu như vậy mới đúng đc
		}
		if (numberOfPiece >= numberOfFriend) {
			return true;
		}
		return false;
	}
}
