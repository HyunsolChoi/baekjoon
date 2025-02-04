package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class N11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> npq = new PriorityQueue<>(Collections.reverseOrder());

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) {
				pq.add(x);
			} else if (x < 0) {
				npq.add(x);
			} else {
				if (pq.isEmpty() && npq.isEmpty())
					bw.write(0 + "\n");
				else if (pq.isEmpty())
					bw.write(npq.poll() + "\n");
				else if (npq.isEmpty())
					bw.write(pq.poll() + "\n");
				else {
					if (pq.peek() < -npq.peek())
						bw.write(pq.poll() + "\n");
					else
						bw.write(npq.poll() + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
