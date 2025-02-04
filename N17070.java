package baekjoon;

import java.util.Scanner;

public class N17070 {
	private static int home[][];
	private static int ways = 0;
	private static int n = 0;

	private static void move(int r, int c, int pos) {

		if (r == n - 1 && c == n - 1) { // 도착한 경우
			ways++;
			return;
		}

		if (pos == 0) { // 가로
			if (c + 1 >= n || home[r][c + 1] == 1) // 우측이 벽이거나 집의 끝일 경우
				return;

			move(r, c + 1, 0);

			if (r + 1 >= n || home[r + 1][c] == 1 || home[r + 1][c + 1] == 1) // 하단이 벽이거나 대각선이 벽이거나 집의 끝인 경우
				return;

			move(r + 1, c + 1, 2);

		} else if (pos == 1) { // 세로
			if (r + 1 >= n || home[r + 1][c] == 1) // 하단이 벽이거나 집의 끝일 경우
				return;

			move(r + 1, c, 1);

			if (c + 1 >= n || home[r][c + 1] == 1 || home[r + 1][c + 1] == 1)
				return;

			move(r + 1, c + 1, 2);

		} else { // 대각선
			boolean right = false;
			boolean down = false;
			if (c + 1 < n && home[r][c + 1] != 1) { // 우측이 벽이거나 집의 끝일 경우
				move(r, c + 1, 0);
				right = true;
			}

			if (r + 1 < n && home[r + 1][c] != 1) { // 하단이 벽이거나 집의 끝일 경우
				move(r + 1, c, 1);
				down = true;
			}

			if (right && down && home[r + 1][c + 1] != 1)
				move(r + 1, c + 1, 2);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		home = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				home[i][j] = in.nextInt();

		move(0, 1, 0); // 가장 좌측 상단에서 가로로 시작

		System.out.println(ways);

		in.close();
	}

}
