package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N3197 {

	private static class Pos {
		int row;
		int col;

		public Pos(int r, int c) {
			row = r;
			col = c;
		}
	}
	
	static Pos s1 = null;
	static Pos s2 = null;
	static LinkedList<Pos> list = new LinkedList<>(); // 다음 날에 녹을 애들 리스트
	static char lake[][];
	static boolean visit[][]; // 다목적 
	static int R;
	static int C;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	private static void getMeltingSoon() {
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (lake[i][j] == 'X' && !visit[i][j]) {
					visit[i][j] = true; // 녹을 얼음인지 검사 여부 ( 녹을 얼음인지에 대한 여부가 아님 )
					for (int w = 0; w < 4; w++) {
						if (i + dy[w] >= 0 && i + dy[w] < R && j + dx[w] >= 0 && j + dx[w] < C) {
							if (lake[i + dy[w]][j + dx[w]] == '.') {
								list.add(new Pos(i, j));
								break;
							}
						}
					}
				}
			}
		}
	}

	private static void setMelting() {
		while (!list.isEmpty()) {
			Pos cur = list.poll();
			lake[cur.row][cur.col] = '.';
		}
	}

	private static boolean canMeet() {
		LinkedList<Pos> ls = new LinkedList<>();
		visit = new boolean[R][C];
		ls.add(s1);
		visit[s1.row][s1.col] = true;

		boolean found = false;
		while (!ls.isEmpty()) {
			Pos cur = ls.remove(0);
			int row = cur.row;
			int col = cur.col;

			for (int w = 0; w < 4; w++) {
				if (row + dy[w] >= 0 && row + dy[w] < R && col + dx[w] >= 0 && col + dx[w] < C) {
					if (!visit[row + dy[w]][col + dx[w]] && lake[row + dy[w]][col + dx[w]] == '.') {
						ls.add(new Pos(row + dy[w], col + dx[w]));
						visit[row + dy[w]][col + dx[w]] = true;
					} else if (lake[row + dy[w]][col + dx[w]] == 'L') {
						found = true;
						break;
					}
				}
			}
			if (found)
				break;
		}

		return found;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		lake = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				lake[i][j] = line.charAt(j);
				if (line.charAt(j) == 'L') {
					if (s1 == null)
						s1 = new Pos(i, j);
					else
						s2 = new Pos(i, j);
				}
			}
		}
		
		int day = 0;

		while (true) {
			if(day>0)
				setMelting();
			
			if(canMeet())
				break;
			
			getMeltingSoon();
			
			day++;
			
			if(list.size()==0) // 녹을 애들 없으면 불필요한 실행 단축
				break;
		}
		
		bw.write(day+"\n");
		bw.flush();
		bw.close();
	}

}
