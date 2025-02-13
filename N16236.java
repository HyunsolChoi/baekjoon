package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N16236 {
	private static class Pos {
		int row;
		int col;
		int time;

		public Pos(int r, int c, int t) {
			col = c;
			row = r;
			time = t;
		}
	}

	private static class Shark {
		int ate = 0;
		int size = 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Pos> list = new LinkedList<>();

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		int n = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][n];
		Shark baby = new Shark();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					list.add(new Pos(i, j, 0));
					map[i][j] = 0;
				}
			}
		}

		int totalTime = 0;

		while (true) {
			boolean visit[][] = new boolean[n][n];
			visit[list.peek().row][list.peek().col] = true;
			Pos nearFish = new Pos(0, 0, Integer.MAX_VALUE);

			while (!list.isEmpty()) {
				Pos cur = list.poll();
				int row = cur.row;
				int col = cur.col;

				if(cur.time < nearFish.time) {
					for (int i = 0; i < 4; i++) {
						if (row + dy[i] >= 0 && row + dy[i] < n && col + dx[i] >= 0 && col + dx[i] < n) {
							if (!visit[row + dy[i]][col + dx[i]]) {
								if (map[row + dy[i]][col + dx[i]] == 0 || map[row + dy[i]][col + dx[i]] == baby.size) {
									list.add(new Pos(row + dy[i], col + dx[i], cur.time + 1));
									visit[row + dy[i]][col + dx[i]] = true;
								} else if (map[row + dy[i]][col + dx[i]] < baby.size) {
									visit[row + dy[i]][col + dx[i]] = true;
									if (nearFish.time > cur.time + 1) {
										nearFish.time = cur.time + 1;
										nearFish.row = row + dy[i];
										nearFish.col = col + dx[i];
									} else if (nearFish.time == cur.time + 1) {
										if (row + dy[i] < nearFish.row) {
											nearFish.row = row + dy[i];
											nearFish.col = col + dx[i];
										}else if(row + dy[i] == nearFish.row) {
											if (col + dx[i] < nearFish.col) 
												nearFish.col = col + dx[i];
										}
									}
								}
							}
						}
					}
				}
			}

			if (nearFish.time < Integer.MAX_VALUE) { // 먹을 수 있는 가장 가까운 물고기를 찾은 경우
				baby.ate++;
				if (baby.ate == baby.size) {
					baby.size++;
					baby.ate = 0;
				}
				totalTime += nearFish.time;
				map[nearFish.row][nearFish.col] = 0;
				list = new LinkedList<>();
				list.add(new Pos(nearFish.row, nearFish.col, 0));
			} else {
				break;
			}
		}
		bw.write(totalTime + "\n");
		bw.flush();
		bw.close();
	}

}
