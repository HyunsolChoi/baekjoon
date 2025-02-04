package baekjoon;

import java.util.Scanner;

public class N11053 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int seq[] = new int[n];
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			seq[i] = in.nextInt();
			dp[i] = 1;
		}
		
		int max = 1;

		for (int i = 1; i < n; i++) {
			for (int k = i - 1; k >= 0; k--) {
				if (seq[i] > seq[k] &&  dp[i] <= dp[k]) {
					dp[i] = dp[k] + 1;
					if(dp[i] > max) {
						max = dp[i];
						break;
					}
				}
			}
		}

		System.out.println(max);
		
		in.close();
	}
}
