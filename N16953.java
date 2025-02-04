package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N16953 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<long[]> queue = new LinkedList<>();

		int a = in.nextInt(); // 초기값
		int b = in.nextInt(); // 목표값

		long minResult = -1;

		queue.add(new long[] { a, 1 });

		while (!queue.isEmpty()) {
			long num[] = queue.poll();

			if (num[0] * 2 <= b) {
				queue.add(new long[] { num[0] * 2, num[1] + 1 });
			}

			if (num[0] * 10 + 1 <= b) {
				queue.add(new long[] { num[0] * 10 + 1, num[1] + 1 });
			}
			
			if (num[0] == b ) {
				minResult = num[1];
				break;
			}
		}

		System.out.println(minResult);

		in.close();
	}
}
