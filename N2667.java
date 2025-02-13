package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class N2667 {
	private static class Pos {
		int row;
		int col;

		public Pos(int r, int c) {
			col = c;
			row = r;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		LinkedList<Pos> list = new LinkedList<>();
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		int danji = 0; // 단지의 수 
		int[] start = new int[2];

		for (int i = 0; i < n; i++) {
			String line = br.readLine().trim(); // 한 줄 입력받기
		    for (int j = 0; j < n; j++) {
		        map[i][j] = Character.getNumericValue(line.charAt(j));

		        if (list.isEmpty() && map[i][j] == 1) {
		            start[0] = i;
		            start[1] = j;
		            list.add(new Pos(i, j));
		        }
		    }
		}
		
		while (!list.isEmpty()) {
			danji++;
			int count = 0; // 단지의 수, 현재 리스트 값 포함 
			boolean visit[][] = new boolean[n][n];
			visit[start[0]][start[1]] = true;
			while (!list.isEmpty()) {
				Pos cur = list.poll();
				int col = cur.col;
				int row = cur.row;
				map[row][col] = danji + 1; // 1은 기존의 맵과 혼용될 가능성
				count++;

				for (int i = 0; i < 4; i++) {
					if (row + dy[i] >= 0 && row + dy[i] < n && col + dx[i] >= 0 && col + dx[i] < n
							&& !visit[row + dy[i]][col + dx[i]] && map[row + dy[i]][col + dx[i]] == 1) {
						list.add(new Pos(row + dy[i], col + dx[i]));
						visit[row + dy[i]][col + dx[i]] = true;
					}
				}
			}
			pq.add(count);
			boolean found = false;
			for (int i = start[0]; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]==1) {
						found = true;
						start[0]=i;
						start[1]=j;
						list.add(new Pos(i,j));
						break;
					}
				}
				if(found)
					break;
			}
		}
		
		bw.write(danji + "\n"); 
		while(!pq.isEmpty()) { 
			bw.write(pq.poll()+"\n"); 
		}
		bw.flush();
		bw.close();
	}

}
