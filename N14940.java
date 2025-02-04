package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N14940 {

	private static class Pos {
		int row;
		int col;
		int dist;

		public Pos(int r, int c, int d) {
			row = r;
			col = c;
			dist = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Pos> queue = new LinkedList<>();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n][m];
		int result[][] = new int[n][m]; // 기본 0
		boolean visit[][] = new boolean[n][m]; // 기본 false

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					visit[i][j] = true;
					queue.add(new Pos(i, j, 0));
				} else if (map[i][j] == 1)
					result[i][j] = -1;
			}
		}

		int dRow[] = { 0, 0, -1, 1 }; // 좌, 우, 상, 하
		int dCol[] = { -1, 1, 0, 0 };
		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			result[cur.row][cur.col] = cur.dist;

			for (int i = 0; i < 4; i++) {
				if(cur.row + dRow[i] < n && cur.col + dCol[i] < m && cur.row + dRow[i] >= 0 && cur.col + dCol[i] >= 0) {
					if (map[cur.row + dRow[i]][cur.col + dCol[i]] == 1 && !visit[cur.row + dRow[i]][cur.col + dCol[i]]) {
						queue.add(new Pos(cur.row + dRow[i], cur.col + dCol[i], cur.dist + 1));
						visit[cur.row + dRow[i]][cur.col + dCol[i]] = true;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				bw.write(result[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
