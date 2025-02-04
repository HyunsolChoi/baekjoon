package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N10026 {
	private static class Color {
		int row;
		int col;
		char color;

		public Color(int r, int c, char co) {
			row = r;
			col = c;
			color = co;
		}
	}

	static LinkedList<Color> list = new LinkedList<>();

	private static int normal(int n, boolean[][] visit, char[][] cols) {
		int i = 0, j = 0;

		int result = 0;

		while (true) {
			boolean flag = false;
			char color;

			for (int a = i; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (!visit[a][b]) {
						i = a;
						j = b;
						visit[a][b] = true;
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			if (!flag) // 찾는게 없으면 종료
				return result;
			else {
				result++;
				list.add(new Color(i, j, cols[i][j]));
				color = list.getFirst().color;
			}

			while (!list.isEmpty()) {
				Color cur = list.poll();
				int row = cur.row;
				int col = cur.col;

				int right = col + 1;
				int left = col - 1;
				int up = row - 1;
				int down = row + 1;

				if (left >= 0 && !visit[row][left]) { // 유효하고 방문한 적 없는 곳
					if (cols[row][left] == color) { // 현재 컬러와 같다면
						list.add(new Color(row, left, cols[row][left]));
						visit[row][left] = true;
					}
				}

				if (right < n && !visit[row][right]) { // 유효하고 방문한 적 없는 곳
					if (cols[row][right] == color) { // 현재 컬러와 같다면
						list.add(new Color(row, right, cols[row][right]));
						visit[row][right] = true;
					}
				}

				if (up >= 0 && !visit[up][col]) { // 유효하고 방문한 적 없는 곳
					if (cols[up][col] == color) { // 현재 컬러와 같다면
						list.add(new Color(up, col, cols[up][col]));
						visit[up][col] = true;
					}
				}

				if (down < n && !visit[down][col]) { // 유효하고 방문한 적 없는 곳
					if (cols[down][col] == color) { // 현재 컬러와 같다면
						list.add(new Color(down, col, cols[down][col]));
						visit[down][col] = true;
					}
				}
			}
		}
	}

	private static int rg_blindness(int n, boolean[][] visit, char[][] cols) {
		int i = 0, j = 0;

		int result = 0;

		while (true) {
			boolean flag = false;
			char color;

			for (int a = i; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (!visit[a][b]) {
						i = a;
						j = b;
						visit[a][b] = true;
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			if (!flag) // 찾는게 없으면 종료
				return result;
			else {
				result++;
				list.add(new Color(i, j, cols[i][j]));
				color = list.getFirst().color;
			}

			while (!list.isEmpty()) {
				Color cur = list.poll();
				int row = cur.row;
				int col = cur.col;

				int right = col + 1;
				int left = col - 1;
				int up = row - 1;
				int down = row + 1;

				if (left >= 0 && !visit[row][left]) { // 유효하고 방문한 적 없는 곳
					if (cols[row][left] == color || (cols[row][left] == 'R' && color == 'G')
							|| (cols[row][left] == 'G' && color == 'R')) { // 현재 컬러와 같거나 RG 일 때  
						list.add(new Color(row, left, cols[row][left]));
						visit[row][left] = true;
					}
				}

				if (right < n && !visit[row][right]) { // 유효하고 방문한 적 없는 곳
					if (cols[row][right] == color || (cols[row][right] == 'R' && color == 'G')
							|| (cols[row][right] == 'G' && color == 'R')) { // 현재 컬러와 같거나 RG 일 때
						list.add(new Color(row, right, cols[row][right]));
						visit[row][right] = true;
					}
				}

				if (up >= 0 && !visit[up][col]) { // 유효하고 방문한 적 없는 곳
					if (cols[up][col] == color || (cols[up][col] == 'R' && color == 'G')
							|| (cols[up][col] == 'G' && color == 'R')) { // 현재 컬러와 같거나 RG 일 때
						list.add(new Color(up, col, cols[up][col]));
						visit[up][col] = true;
					}
				}

				if (down < n && !visit[down][col]) { // 유효하고 방문한 적 없는 곳
					if (cols[down][col] == color || (cols[down][col] == 'R' && color == 'G')
							|| (cols[down][col] == 'G' && color == 'R')) { // 현재 컬러와 같거나 RG 일 때
						list.add(new Color(down, col, cols[down][col]));
						visit[down][col] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		char cols[][] = new char[n][n];
		boolean visit[][] = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				cols[i][j] = s.charAt(j);
			}
		}

		int result = 0;
		result = normal(n, visit, cols);

		visit = new boolean[n][n];

		int result_rg = 0; // 적록색약이 보는 구역의 수
		result_rg = rg_blindness(n, visit, cols);
		
		bw.write(result + " " + result_rg + "\n");
		bw.flush();
		bw.close();
	}

}
