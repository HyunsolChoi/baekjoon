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

		nums.add(in.nextInt()); // ���� ù��° ������ �Է�

		// n - 1 ���� ������ �Է� �� ������������ �ߺ����� nums�� ����
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

		// ���� ���� ���������� list �ʱ�ȭ
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
