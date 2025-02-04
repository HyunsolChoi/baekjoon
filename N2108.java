package baekjoon;

import java.util.Scanner;

public class N2108 {

	private static void quickSort(int nums[], int p, int r) {
		if (p < r) {
			int q = partition(nums, p, r);
			quickSort(nums, p, q - 1);
			quickSort(nums, q + 1, r);
		}
	}

	private static int partition(int nums[], int p, int r) {
		int x = nums[r];
		int i = p - 1;

		for (int j = p; j <= r - 1; j++) {
			if (nums[j] < x) {
				i++;
				swap(nums, i, j);
			} else if (nums[j] == x && (j % 2) == 1) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, r);
		return i + 1;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cnts[] = new int[8001];

		int n = in.nextInt(); // n�� Ȧ��

		int nums[] = new int[n];

		int total = 0;
		int min = 4001;
		int max = -4001;

		int maxCnt = 0;
		int maxCntPos = -1; // ���� �󵵼��� ����, �ߺ��� ���� ��� ���� ���� ���� ����Ŵ
		int secCntPos = -1;

		for (int i = 0; i < n; i++) {
			int a = in.nextInt(); // �Է°��� ���� 4000 ������ ����
			total += nums[i] = a;
			if (a > max)
				max = a;
			if (a < min)
				min = a;
			cnts[4000 - a]++; // a�� ũ�� Ŭ���� �ε��� ���� �۾���, �ݴ�� a�� ������ �ε����� Ŀ��
			if (cnts[4000 - a] > maxCnt) {
				maxCnt = cnts[4000 - a];
				maxCntPos = 4000 - a;
				secCntPos = -1;
			} else if (cnts[4000 - a] == maxCnt) { // �ֺ� �ߺ�
				int b = (maxCntPos > 4000) ? 4000 - maxCntPos : -(maxCntPos - 4000); // ���� �ֺ� 
				if (a < b) { // ���� �ֺ󰪺��� �۴ٸ� ���� ���� �ֺ� ��ġ�� �ٲ���
					secCntPos = maxCntPos; // �ι�° �ֺ󰪿� ���� �ֺ��� ����
					maxCntPos = 4000 - a;
				} else { // ���� �ֺ󰪺��� Ŭ �� (���� ���� ����)
					if (secCntPos != -1) { // �̹� ������ �ι�° �ֺ��� �ִ� ���
						b = (secCntPos > 4000) ? 4000 - secCntPos : -(secCntPos - 4000); // ���� �ι�° �ֺ� 
						if (b > a) // �Է� �ֺ��� �� �۴ٸ� �̸� �ι�° �ֺ����� ����, �ƴ϶�� ���� �� ����
							secCntPos = 4000 - a;
					} else { // ������ �ι�° �ֺ��� ���ٸ� ���� ������ ����
						secCntPos = 4000 - a;
					}
				}
			}
		}
		int result = 0;

		if (secCntPos != -1)
			result = secCntPos > 4000 ? 4000 - secCntPos : -(secCntPos - 4000);
		else
			result = maxCntPos > 4000 ? 4000 - maxCntPos : -(maxCntPos - 4000);

		quickSort(nums, 0, nums.length - 1);

		System.out.println(Math.round((float) total / n)); // ������, ù��° ���
		System.out.println(nums[n / 2]); // �������� ���� �� �߾Ӱ�, �ι�° ���
		System.out.println(result); // �ֺ�, �ߺ� �� �ι�°
		System.out.println(Math.abs(max - min)); // ����, �׹�° ���

		in.close();
	}

}
