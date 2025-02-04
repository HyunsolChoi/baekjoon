package baekjoon;

import java.util.Scanner;

public class N1654 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int k = in.nextInt();
		int n = in.nextInt();

		long cables[] = new long[k];

		long total = 0;

		for (int i = 0; i < k; i++) {
			total += cables[i] = in.nextLong();
		}

		long left = 0; // ÁÂ

		long right = total / n + 1; // ¿ì

		long mid = (left + right) / 2; // Áß¾Ó

		while (true) {
			if(left > right)
				break;
			
			int cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += cables[i] / mid;
			}

			if (cnt < n) { // Áß¾Ó ±âÁØ ÁÂÃøÀÇ °æ¿ì
				right = mid - 1;
				mid = (left + right) / 2;
			} else if (cnt >= n) { // Áß¾Ó ±âÁØ ¿ìÃøÀÇ °æ¿ì
				left = mid + 1;
				mid = (left + right) / 2;
			}
		}

		System.out.println(mid);

		in.close();
	}

}
