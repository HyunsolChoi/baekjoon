package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16928 {
	private static class Location {
		int pos;
		int cnt;

		public Location(int p, int c) {
			pos = p;
			cnt = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Location> queue = new LinkedList<>();

		int n = Integer.parseInt(st.nextToken()); // 사다리의 수
		int m = Integer.parseInt(st.nextToken()); // 뱀의 수

		int ways[] = new int[101];
		int result = 0;

		int s, d;

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			ways[s] = d;
		}

		queue.add(new Location(1, 0));

		while (!queue.isEmpty()) {
			Location cur = queue.poll();
			int pos = cur.pos;
			int cnt = cur.cnt;

			int noWayMax = 0;

			for (int i = 1; i <= 6 && pos + i <= 100; i++) {
				if (ways[pos + i] != 0) {
					queue.add(new Location(ways[pos + i], cnt + 1));
				} else if (pos + i == 100) {
					result = cnt + 1;
					noWayMax = 0;
					queue.clear();
					break;
				} else {
					noWayMax = i;
				}
			}

			if (noWayMax != 0) {
				queue.add(new Location(pos + noWayMax, cnt + 1)); // 사다리, 뱀을 아무것도 타지않는 경로의 최댓값
			}
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}

}
