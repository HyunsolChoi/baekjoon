package baekjoon;

import java.util.Scanner;

public class N2096 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] minCur = new int[3];
		int[] maxCur = new int[3];

		int n = in.nextInt();

		int nums[][] = new int[n][3];

		for (int i = 0; i < n; i++) {
			nums[i][0] = in.nextInt();
			nums[i][1] = in.nextInt();
			nums[i][2] = in.nextInt();
		}

		int minPrev[] = nums[0].clone();
		int maxPrev[] = nums[0].clone();

		for (int i = 1; i < n; i++) {
			minCur[0] = nums[i][0] + Math.min(minPrev[0], minPrev[1]);
			minCur[1] = nums[i][1] + Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]);
			minCur[2] = nums[i][2] + Math.min(minPrev[1], minPrev[2]);

			maxCur[0] = nums[i][0] + Math.max(maxPrev[0], maxPrev[1]);
			maxCur[1] = nums[i][1] + Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]);
			maxCur[2] = nums[i][2] + Math.max(maxPrev[1], maxPrev[2]);

			minPrev = minCur.clone();
			maxPrev = maxCur.clone();
		}
		
		System.out.println(Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]) + " " + Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]));
		in.close();
	}

}
