package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N2178 { // 항상 도착지까지 이동할 수 있다는 전제
	private static class Pos {
		private int row;
		private int col;
		private int cnt;

		public Pos(int a, int b, int c) {
			row = a;
			col = b;
			cnt = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		LinkedList<Pos> list = new LinkedList<>();
		int dx[] = { -1, 0, 1, 0 }; // 좌 - 하 - 우 - 상
		int dy[] = { 0, 1, 0, -1 };

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n][m];
		boolean visit[][] = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		list.add(new Pos(0, 0, 1));

		while (!list.isEmpty()) {
			Pos cur = list.poll();

			for (int i = 0; i < 4; i++) {
				int row = cur.row + dy[i];
				int col = cur.col + dx[i];

				// 유효하며 방문한 적이 없는 곳
				if (row >= 0 && row < n && col >= 0 && col < m && map[row][col] == 1 && !visit[row][col]) {
					if (row == n - 1 && col == m - 1) {
						bw.write(cur.cnt + 1 + "\n");
						bw.flush();
						bw.close();
						return;
					}
					visit[row][col] = true;
					list.add(new Pos(row, col, cur.cnt + 1));
				}
			}
		}
	}
}
