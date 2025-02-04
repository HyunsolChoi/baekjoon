package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7569 {
	private static class Tomato {
		int row;
		int col;
		int day;
		int floor;

		public Tomato(int r, int c, int d, int f) {
			row = r;
			col = c;
			day = d;
			floor = f;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Tomato> queue = new LinkedList<>();

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int box[][][] = new int[h][n][m];
		boolean visit[][][] = new boolean[h][n][m];

		int cntOfZero = 0;
		int result = 0;
		int num;

		for (int z = 0; z < h; z++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					num = Integer.parseInt(st.nextToken());
					box[z][i][j] = num;
					if (num == 1) {
						queue.add(new Tomato(i, j, 0, z));
					} else if (num == 0)
						cntOfZero++;
				}
			}
		}

		int changeToOne = 0;

		while (!queue.isEmpty()) {
			Tomato t = queue.poll();
			int col = t.col;
			int row = t.row;
			int floor = t.floor;
			int day = t.day;
			if (day > result)
				result = day;

			int left = col - 1;
			int right = col + 1;
			int up = row - 1;
			int down = row + 1;
			int upFloor = floor+ 1;
			int downFloor = floor -1;

			if (left >= 0 && box[floor][row][left] == 0 && !visit[floor][row][left]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[floor][row][left] = true;
				box[floor][row][left] = 1;
				changeToOne++;
				queue.add(new Tomato(row, left, day + 1, floor));
			}

			if (right < m && box[floor][row][right] == 0 && !visit[floor][row][right]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[floor][row][right] = true;
				box[floor][row][right] = 1;
				changeToOne++;
				queue.add(new Tomato(row, right, day + 1, floor));
			}

			if (up >= 0 && box[floor][up][col] == 0 && !visit[floor][up][col]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[floor][up][col] = true;
				box[floor][up][col] = 1;
				changeToOne++;
				queue.add(new Tomato(up, col, day + 1, floor));
			}

			if (down < n && box[floor][down][col] == 0 && !visit[floor][down][col]) { // box 범위 내에서, 아직 익지 않은 토마토이며, 방문하지않음.
				visit[floor][down][col] = true;
				box[floor][down][col] = 1;
				changeToOne++;
				queue.add(new Tomato(down, col, day + 1, floor));
			}
			
			if(upFloor < h && box[upFloor][row][col] == 0 && !visit[upFloor][row][col]) {
				visit[upFloor][row][col] = true;
				box[upFloor][row][col] = 1;
				changeToOne++;
				queue.add(new Tomato(row, col, day + 1, upFloor));
			}
			
			if(downFloor >= 0 && box[downFloor][row][col] == 0 && !visit[downFloor][row][col]) {
				visit[downFloor][row][col] = true;
				box[downFloor][row][col] = 1;
				changeToOne++;
				queue.add(new Tomato(row, col, day + 1, downFloor));
			}
		}

		if (changeToOne == cntOfZero) {
			bw.write(result+"\n");
		} else {
			bw.write(-1+"\n");
		}
		bw.flush();
		bw.close();
	}

}
