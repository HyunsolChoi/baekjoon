package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class N15666 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList<Integer> nums = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		int input = 0;

		int n = in.nextInt();
		int m = in.nextInt();

		nums.add(in.nextInt()); // 가장 첫번째 정수값 입력

		// n - 1 개의 정수값 입력 및 오름차순으로 중복없이 nums에 저장
		for (int i = 1; i < n; i++) {
			input = in.nextInt();
			if (!nums.contains(input)) {
				for (int k = 0; k <= nums.size(); k++) {
					if (k == nums.size() || nums.get(k) > input) {
						nums.add(k, input);
						break;
					}
				}
			}
		}

		// 가장 작은 정수값으로 list 초기화
		for (int i = 0; i < m; i++) {
			list.add(nums.get(0));
		}

		while (true) {
			for (int i = 0; i < m; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

			boolean stop = false;
			for (int i = m - 1; i >= 0; i--) {
				for (int idx = 1; idx < nums.size(); idx++) {
					if(list.get(i)<nums.get(idx)) {
						for(int j=i;j<m;j++) 
							list.set(j, nums.get(idx));
						
						stop = true;
						break;
					}
				}
				if(stop) 
					break;
			}
			if(!stop)
				break;
		}

		in.close();
	}

}
