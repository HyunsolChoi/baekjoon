package baekjoon;

import java.util.Scanner;

public class N10250 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int h = in.nextInt();
			int w = in.nextInt();
			int n = in.nextInt();

			int room = n % h == 0 ? h * 100 : (n % h) * 100;
			room += n % h == 0 ? n / h : n / h + 1;

			System.out.println(room);
		}

		in.close();
	}

}
