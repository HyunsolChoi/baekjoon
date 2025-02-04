package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char op;
		int num;

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) { // test case
			TreeMap<Integer, Integer> map = new TreeMap<>();
			st = new StringTokenizer(br.readLine());

			int q = Integer.parseInt(st.nextToken());

			for (int c = 0; c < q; c++) { // opation
				st = new StringTokenizer(br.readLine());
				op = st.nextToken().charAt(0);

				num = Integer.parseInt(st.nextToken());

				if (op == 'I') {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else if (op == 'D' && !map.isEmpty()) {
					if (num == 1) {
						int maxKey = map.lastKey();
						if (map.get(maxKey) == 1)
							map.remove(maxKey);
						else
							map.put(maxKey, map.get(maxKey) - 1);
					} else if (num == -1) {
						int minKey = map.firstKey();
						if (map.get(minKey) == 1)
							map.remove(minKey);
						else
							map.put(minKey, map.get(minKey) - 1);
					}
				}
			}

			if (map.isEmpty())
				bw.write("EMPTY\n");
			else
				bw.write(map.lastKey() + " " + map.firstKey() + "\n");
		}
		bw.flush();
		bw.close();
	}
}
