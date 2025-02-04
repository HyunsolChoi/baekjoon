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

		int n = in.nextInt(); // n은 홀수

		int nums[] = new int[n];

		int total = 0;
		int min = 4001;
		int max = -4001;

		int maxCnt = 0;
		int maxCntPos = -1; // 가장 빈도수가 많은, 중복이 있을 경우 가장 작은 값을 가르킴
		int secCntPos = -1;

		for (int i = 0; i < n; i++) {
			int a = in.nextInt(); // 입력값은 절댓값 4000 이하의 정수
			total += nums[i] = a;
			if (a > max)
				max = a;
			if (a < min)
				min = a;
			cnts[4000 - a]++; // a가 크면 클수록 인덱스 값이 작아짐, 반대로 a가 작으면 인덱스는 커짐
			if (cnts[4000 - a] > maxCnt) {
				maxCnt = cnts[4000 - a];
				maxCntPos = 4000 - a;
				secCntPos = -1;
			} else if (cnts[4000 - a] == maxCnt) { // 최빈값 중복
				int b = (maxCntPos > 4000) ? 4000 - maxCntPos : -(maxCntPos - 4000); // 현재 최빈값 
				if (a < b) { // 현재 최빈값보다 작다면 가장 작은 최빈값 위치를 바꿔줌
					secCntPos = maxCntPos; // 두번째 최빈값에 기존 최빈값을 삽입
					maxCntPos = 4000 - a;
				} else { // 현재 최빈값보다 클 때 (같을 수는 없음)
					if (secCntPos != -1) { // 이미 기존의 두번째 최빈값이 있는 경우
						b = (secCntPos > 4000) ? 4000 - secCntPos : -(secCntPos - 4000); // 현재 두번째 최빈값 
						if (b > a) // 입력 최빈값이 더 작다면 이를 두번째 최빈값으로 설정, 아니라면 기존 값 유지
							secCntPos = 4000 - a;
					} else { // 기존의 두번째 최빈값이 없다면 현재 값으로 지정
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

		System.out.println(Math.round((float) total / n)); // 산술평균, 첫번째 출력
		System.out.println(nums[n / 2]); // 오름차순 정렬 후 중앙값, 두번째 출력
		System.out.println(result); // 최빈값, 중복 시 두번째
		System.out.println(Math.abs(max - min)); // 범위, 네번째 출력

		in.close();
	}

}
