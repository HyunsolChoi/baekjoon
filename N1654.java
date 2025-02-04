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

		long left = 0; // ��

		long right = total / n + 1; // ��

		long mid = (left + right) / 2; // �߾�

		while (true) {
			if(left > right)
				break;
			
			int cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += cables[i] / mid;
			}

			if (cnt < n) { // �߾� ���� ������ ���
				right = mid - 1;
				mid = (left + right) / 2;
			} else if (cnt >= n) { // �߾� ���� ������ ���
				left = mid + 1;
				mid = (left + right) / 2;
			}
		}

		System.out.println(mid);

		in.close();
	}

}
