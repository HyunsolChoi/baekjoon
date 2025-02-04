package baekjoon;

import java.util.Scanner;

public class N2920 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nums[] = new int[8];

		for (int i = 0; i < 8; i++) {
			nums[i] = in.nextInt();
		}

		int result = nums[0] == 1 ? 0 : nums[0] == 8 ? 1 : 2; // 0:asc 1:des 2:mix

		if (result == 0) {
			int prev = nums[0];
			for (int i = 1; i < 8; i++) {
				if (nums[i] < prev) {
					result = 2;
				}
				prev = nums[i];
			}
		} else if(result == 1){
			int prev = nums[0];
			for (int i = 1; i < 8; i++) {
				if (nums[i] > prev) {
					result = 2;
				}
				prev = nums[i];
			}
		}

		System.out.println(result == 0 ? "ascending" : result == 1 ? "descending" : "mixed");

		in.close();
	}

}
