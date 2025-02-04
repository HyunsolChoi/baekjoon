package baekjoon;

import java.util.Scanner;

public class N2884 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int h = in.nextInt();
		int m = in.nextInt();

		m -= 45;

		if (m < 0) {
			m = 60 + m;
			h--;
			if (h < 0) {
				h = 24 + h;
			}
		}

		System.out.println(h + " " + m);
		in.close();
	}

}
