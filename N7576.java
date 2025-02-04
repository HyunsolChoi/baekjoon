package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7576 {
	private static class Tomato {
		int row;
		int col;
		int day;

		public Tomato(int r, int c, int d) {
			row = r;
			col = c;
			day = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Tomato> queue = new LinkedList<>();

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int box[][] = new int[n][m];
		boolean visit[][] = new boolean[n][m];

		int cntOfZero = 0;
		int result = 0;
		int num;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				num = Integer.parseInt(st.nextToken());
				box[i][j] = num;
				if (num == 1) {
					queue.add(new Tomato(i, j, 0));
				} else if (num == 0)
					cntOfZero++;
			}
		}

		int changeToOne = 0;

		while (!queue.isEmpty()) {
			Tomato t = queue.poll();
			int col = t.col;
			int row = t.row;
			int day = t.day;
			if (day > result)
				result = day;

			int left = col - 1;
			int right = col + 1;
			int up = row - 1;
			int down = row + 1;

			if (left >= 0 && box[row][left] == 0 && !visit[row][left]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[row][left] = true;
				box[row][left] = 1;
				changeToOne++;
				queue.add(new Tomato(row, left, day + 1));
			}
			
			if (right < m && box[row][right] == 0 && !visit[row][right]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[row][right] = true;
				box[row][right] = 1;
				changeToOne++;
				queue.add(new Tomato(row, right, day + 1));
			}
			
			if (up >= 0 && box[up][col] == 0 && !visit[up][col]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[up][col] = true;
				box[up][col] = 1;
				changeToOne++;
				queue.add(new Tomato(up, col, day + 1));
			}
			
			if (down < n && box[down][col] == 0 && !visit[down][col]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[down][col] = true;
				box[down][col] = 1;
				changeToOne++;
				queue.add(new Tomato(down, col, day + 1));
			}
		}

		if(changeToOne==cntOfZero) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
	}

}
