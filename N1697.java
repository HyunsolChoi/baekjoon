package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1697 {
	private static class Pos {
		int x;
		int time;

		public Pos(int X, int C) {
			x = X;
			time = C;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Pos> list = new LinkedList<>();

		int N = Integer.parseInt(st.nextToken()); // 0 ~ 100,000 Á¤¼ö
		int K = Integer.parseInt(st.nextToken());

		int dist[] = new int[100001];

		if (N == K)
			bw.write(0 + "\n");
		else
			list.add(new Pos(N, 0));

		while (!list.isEmpty()) {
			Pos cur = list.poll();
			int x = cur.x;
			int time = cur.time;

			if (x == K) {
				bw.write(time + "\n");
				break;
			}

			if (x > 0) {
				if (x * 2 != N && x * 2 <= 100000 && (dist[x * 2] == 0 || dist[x * 2] > time)) {
					list.add(new Pos(x * 2, time + 1));
					dist[x * 2] = time + 1;
				}
				if (x - 1 != N && (dist[x - 1] == 0 || dist[x - 1] > time)) {
					list.add(new Pos(x - 1, time + 1));
					dist[x - 1] = time + 1;
				}
			}
			if (x + 1 != N && x + 1 <= 100000 && (dist[x + 1] == 0 || dist[x + 1] > time)) {
				list.add(new Pos(x + 1, time + 1));
				dist[x + 1] = time + 1;
			}
		}

		bw.flush();
		bw.close();
	}

}
