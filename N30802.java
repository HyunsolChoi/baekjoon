package baekjoon;

import java.util.Scanner;

public class N30802 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int shirts[] = new int[6];

		int n = in.nextInt();

		for (int i = 0; i < 6; i++)
			shirts[i] = in.nextInt();

		int T = in.nextInt();
		int P = in.nextInt();

		int result_T = 0;

		for (int i = 0; i < 6; i++)
			for (int left = shirts[i]; left > 0; left -= T)
				result_T++;

		int result_P = n / P;

		int left_P = n - result_P * P;

		System.out.print(result_T + "\n" + result_P + " " + left_P);

		in.close();
	}

}
