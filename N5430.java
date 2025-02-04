package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N5430 {
	private static String AC(String cmd, int n, String arr) {
		if (n == 0 && cmd.contains("D")) {
			return "error";
		}

		LinkedList<Integer> list = new LinkedList<>();
		boolean reverse = false;
		String number = "";
		for (int i = 0; i < arr.length(); i++) {
			if (arr.charAt(i) != '[' && arr.charAt(i) != ']' && arr.charAt(i) != ',') {
				number += arr.charAt(i);
			} else if (!number.equals("")) {
				list.add(Integer.parseInt(number));
				number = "";
			}
		}

		for (int i = 0; i < cmd.length(); i++) {
			if (cmd.charAt(i) == 'R') {
				reverse = !reverse;
			} else if (cmd.charAt(i) == 'D') {
				if (!list.isEmpty()) {
					if (!reverse)
						list.removeFirst();
					else
						list.removeLast();
				} else {
					return "error";
				}
			}
		}

		StringBuilder result = new StringBuilder("[");

		while (!list.isEmpty()) {
			if (reverse) {
				result.append(list.removeLast());
			} else {
				result.append(list.removeFirst());
			}
			if (!list.isEmpty()) {
				result.append(",");
			}
		}

		result.append("]");

		return result.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			String cmd = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			bw.write(AC(cmd, n, arr) + "\n");

			bw.flush();
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}
		bw.close();
	}

}
