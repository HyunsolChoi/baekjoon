package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N9019 {
	static int regB;

	private static boolean Same(Process r) {
		return r.regA == regB;
	}

	private static int Right(int r) {
		int d4 = r % 10;
		r /= 10;
		r += d4 * 1000;
		return r;
	}

	private static int Left(int r) {
		r *= 10;
		int d1 = r / 10000;
		r %= 10000;
		r += d1;
		return r;
	}

	private static int Sub(int r) {
		r -= 1;
		if (r < 0)
			r = 9999;
		return r;
	}

	private static int Double(int r) {
		r = r * 2;
		if (r > 9999)
			r = r % 10000;
		return r;
	}

	private static class Process {
		public int regA;
		public StringBuilder sb;

		public Process(int r, StringBuilder s) {
			this.regA = r;
			this.sb = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Process> list;

		int T = Integer.parseInt(st.nextToken());
		boolean visit[];

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			list = new LinkedList<>();
			visit = new boolean[10000];
			list.add(new Process(Integer.parseInt(st.nextToken()), new StringBuilder()));
			visit[list.getFirst().regA] = true;
			regB = Integer.parseInt(st.nextToken());

			while (!list.isEmpty()) {
				Process cur = list.removeFirst();
				if (Same(cur)) {
					bw.write(cur.sb.toString() + "\n");
					break;
				}
				String str = cur.sb.toString();
				if (cur.regA != 0) {
					if (!visit[Double(cur.regA)]) {
						list.add(new Process(Double(cur.regA), new StringBuilder(str + "D")));
						visit[Double(cur.regA)] = true;
					}
					if (!visit[Left(cur.regA)]) {
						list.add(new Process(Left(cur.regA), new StringBuilder(str + "L")));
						visit[Left(cur.regA)] = true;
					}
					if (!visit[Right(cur.regA)]) {
						list.add(new Process(Right(cur.regA), new StringBuilder(str + "R")));
						visit[Right(cur.regA)] = true;
					}
				}
				if (!visit[Sub(cur.regA)]) {
					list.add(new Process(Sub(cur.regA), new StringBuilder(str + "S")));
					visit[Sub(cur.regA)] = true;
				}
			}
		}
		bw.flush();
		bw.close();
	}

}
