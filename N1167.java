package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class N1167 {
	private static class Node {
		ArrayList<Integer> list = new ArrayList<>(); // 연결 노드 리스트
	}

	private static class Process {
		int pos;
		int dist;

		public Process(int p, int d) {
			pos = p;
			dist = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, Node> nodes = new HashMap<>();

		int V = Integer.parseInt(st.nextToken());

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken());
			nodes.put(v - 1, new Node());

			int node = Integer.parseInt(st.nextToken());
			while (node != -1) {
				nodes.get(v - 1).list.add(node - 1);
				int dist = Integer.parseInt(st.nextToken());
				if (node > v)
					map.put((v - 1) + " " + (node - 1), dist);
				else
					map.put((node - 1) + " " + (v - 1), dist);

				node = Integer.parseInt(st.nextToken());
			}
		}

		LinkedList<Process> list = new LinkedList<>();

		int totalMaxDist = 0;
		int maxNode = 0;
		list.add(new Process(maxNode, 0));

		for (int i = 0; i < 2; i++) {
			boolean visit[] = new boolean[V];
			visit[maxNode] = true;
			totalMaxDist = 0;

			while (!list.isEmpty()) { // 너비 우선 탐색
				Process cur = list.poll();
				if (cur.dist > totalMaxDist) {
					totalMaxDist = cur.dist;
					maxNode = cur.pos;
				}

				for (int node = 0; node < nodes.get(cur.pos).list.size(); node++) {
					int idx = nodes.get(cur.pos).list.get(node);
					if (!visit[idx]) { // 아직 방문하지 않은 지점
						if (cur.pos < idx) {
							if (map.containsKey(cur.pos + " " + idx)) {
								list.add(new Process(idx, cur.dist + map.get(cur.pos + " " + idx)));
								visit[idx] = true;
							}
						} else {
							if (map.containsKey(idx + " " + cur.pos)) {
								list.add(new Process(idx, cur.dist + map.get(idx + " " + cur.pos)));
								visit[idx] = true;
							}
						}
					}
				}
			}
			if (i == 0)
				list.add(new Process(maxNode, 0));
		}

		bw.write(totalMaxDist + "\n");
		bw.flush();
		bw.close();
	}

}
