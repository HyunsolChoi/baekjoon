package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N14500 {
	public static class Pos {
		int x;
		int y;
		int value;
		int depth;
		boolean visit[][];

		public Pos(int b, int a, int val, int d, boolean vis[][]) {
			x = a;
			y = b;
			value = val;
			depth = d;
			visit = vis;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<Pos> queue = new LinkedList<>();

		int n = in.nextInt();
		int m = in.nextInt();

		int paper[][] = new int[n][m];
		boolean added[][] = new boolean[n][m];

		int result = -1;

		int left = 0;
		int right = 0;
		int up = 0;
		int down = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				paper[i][j] = in.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				for (int a = 0; a < n; a++) {
					Arrays.fill(added[a], false);
				}

				queue.add(new Pos(i, j, paper[i][j], 1, added));

				int max = 0;

				while (!queue.isEmpty()) {
					Pos cur = queue.poll();
					int x = cur.x;
					int y = cur.y;
					boolean visit[][] = cur.visit;
					visit[y][x] = true;

					if (cur.value > max)
						max = cur.value;

					left = cur.x - 1; // 왼쪽
					right = cur.x + 1; // 오른쪽
					up = cur.y - 1; // 위
					down = cur.y + 1; // 아래

					if (cur.depth >= 4)
						continue;

					if (left >= 0 && !visit[y][left]) {
						visit[y][left] = true;
						queue.add(new Pos(y, left, paper[y][left] + cur.value, cur.depth + 1, visit));
						if (cur.depth == 2 || cur.depth == 1) {
							if (right < m && !visit[y][right]) {
								queue.add(new Pos(y, left, paper[y][left] + cur.value + paper[y][right], cur.depth + 2,
										visit));
							}
							if (up >= 0 && !visit[up][x]) {
								queue.add(new Pos(y, left, paper[y][left] + cur.value + paper[up][x], cur.depth + 2,
										visit));
							}
							if (down < n && !visit[down][x]) {
								queue.add(new Pos(y, left, paper[y][left] + cur.value + paper[down][x], cur.depth + 2,
										visit));
							}
						}
						visit[y][left] = false;
					}
					if (right < m && !visit[y][right]) {
						visit[y][right] = true;
						queue.add(new Pos(y, right, paper[y][right] + cur.value, cur.depth + 1, visit));
						if (cur.depth == 2 || cur.depth == 1) {
							if (left >= 0 && !visit[y][left]) {
								queue.add(new Pos(y, right, paper[y][right] + cur.value + paper[y][left], cur.depth + 2,
										visit));
							}
							if (up >= 0 && !visit[up][x]) {
								queue.add(new Pos(y, right, paper[y][right] + cur.value + paper[up][x], cur.depth + 2,
										visit));
							}
							if (down < n && !visit[down][x]) {
								queue.add(new Pos(y, right, paper[y][right] + cur.value + paper[down][x], cur.depth + 2,
										visit));
							}
						}
						visit[y][right] = false;
					}
					if (up >= 0 && !visit[up][x]) {
						visit[up][x] = true;
						queue.add(new Pos(up, x, paper[up][x] + cur.value, cur.depth + 1, visit));
						if (cur.depth == 2 || cur.depth == 1) {
							if (right < m && !visit[y][right]) {
								queue.add(new Pos(up, x, paper[up][x] + cur.value + paper[y][right], cur.depth + 2,
										visit));
							}
							if (left >= 0 && !visit[y][left]) {
								queue.add(new Pos(up, x, paper[up][x] + cur.value + paper[y][left], cur.depth + 2,
										visit));
							}
							if (down < n && !visit[down][x]) {
								queue.add(new Pos(up, x, paper[up][x] + cur.value + paper[down][x], cur.depth + 2,
										visit));
							}
						}
						visit[up][x] = false;
					}
					if (down < n && !visit[down][x]) {
						visit[down][x] = true;
						queue.add(new Pos(down, x, paper[down][x] + cur.value, cur.depth + 1, visit));
						if (cur.depth == 2 || cur.depth == 1) {
							if (right < m && !visit[y][right]) {
								queue.add(new Pos(down, x, paper[down][x] + cur.value + paper[y][right], cur.depth + 2,
										visit));
							}
							if (left >= 0 && !visit[y][left]) {
								queue.add(new Pos(down, x, paper[down][x] + cur.value + paper[y][left], cur.depth + 2,
										visit));
							}
							if (up >= 0 && !visit[up][x]) {
								queue.add(new Pos(down, x, paper[down][x] + cur.value + paper[up][x], cur.depth + 2,
										visit));
							}
						}
						visit[down][x] = false;
					}
				}

				result = result < max ? max : result;
			}
		}

		System.out.println(result);

		in.close();
	}

}
