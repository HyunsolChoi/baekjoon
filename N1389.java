package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1389 {
	private static class Pos {
		int pos;
		int val;

		public Pos(int p, int v) {
			pos = p;
			val = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Pos> list;

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int dist[][] = new int[n][n];
		int value[] = new int[n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a - 1][b - 1] = 1;
			dist[b - 1][a - 1] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			list = new LinkedList<>();
			int foundCnt = 0;
			boolean visit[] = new boolean[n];
			visit[i] = true;
			int val = 0;
			for (int j = 0; j < n; j++) {
				if (dist[i][j] != 0 && i != j) {
					list.add(new Pos(j, 1));
					foundCnt++;
					visit[j] = true;
					val += 1;
				}
			}
			while (!list.isEmpty() && foundCnt < n - 1) {
				Pos cur = list.poll();
				for (int b = 0; b < n; b++) {
					if (dist[cur.pos][b] != 0 && !visit[b]) {
						list.add(new Pos(b, cur.val + 1));
						visit[b] = true;
						val += cur.val+1;
						foundCnt++;
					}
				}
			}
			value[i] = val;
		}

		int smallBacon = 0;
		int smallBaconNum = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if(smallBaconNum > value[i]) {
				smallBacon = i + 1;
				smallBaconNum = value[i];
			}
		}
		bw.write(smallBacon + "");

		bw.flush();
		bw.close();
	}

}
