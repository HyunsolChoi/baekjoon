package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N6064 {
	static int m, n;

	private static int GCD() {
		int s = m > n ? n : m;
		int max = 1;
		for (int i = 1; i <= s; i++) {
			if (n % i == 0 && m % i == 0)
				max = i;
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			boolean found = false;
			long cnt = 1;
			int N = 1;

			long lcm = (m * n) / GCD();

			int offset = x - 1;

			int op = 0;
			while (cnt <= lcm) {
				cnt = 1 + offset + m * op++;
				N = (int) (cnt > n ? (cnt % n == 0 ? n : cnt % n) : cnt);
				if (N == y) {
					bw.write(cnt + "\n");
					found = true;
					break;
				}
			}
			if (!found)
				bw.write(-1 + "\n");

		}
		bw.flush();
		bw.close();
	}

}
