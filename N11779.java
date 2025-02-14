package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N11779 {

	private static class Node {
		ArrayList<Integer> canGo = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		int count = 0;
	}

	private static int getMin(LinkedList<Integer> list, long dist[], boolean found[]) {
		long minDist = Long.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < list.size(); i++) {
			if (!found[list.get(i)] && dist[list.get(i)] < minDist) {
				minDist = dist[list.get(i)];
				minIdx = list.get(i);
			}
		}
		return minIdx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<>(); // 알고리즘 자료에서 주황색 노드들, v-s 집합 중 접근 가능한, 이중에서 가장 값이 작은 dist를
														// extraMin에서 반환해야함

		int n = Integer.parseInt(st.nextToken());

		Node node[] = new Node[n]; // 각 노드별 인접
		int costs[][] = new int[n][n]; // 간선, 각 버스 비용은 0 <= 버스비용 <= 100,000
		boolean near[] = new boolean[n]; // 현재 접근 가능 여부, list에 속해있는지 여부
		boolean found[] = new boolean[n]; // 이미 최적의 값을 찾은 노드
		boolean ok[][] = new boolean[n][n]; // 유효한 costs 값 여부, 중복 시 최소값 구분을 위해 사용
		long dist[] = new long[n]; // 출발지로부터의 거리

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			node[i] = new Node();
			dist[i] = Long.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			// 배열과 값 일치를 위해 - 1
			int dep = Integer.parseInt(st.nextToken()) - 1;
			int arr = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			if(!ok[dep][arr])
				costs[dep][arr] = cost;
			else if(costs[dep][arr] > cost)
				costs[dep][arr] = cost;
			
			node[dep].canGo.add(arr); // 갈 수 있는 리스트에 추가
			ok[dep][arr] = true;
		}

		st = new StringTokenizer(br.readLine());
		int departure = Integer.parseInt(st.nextToken()) - 1;
		int arrival = Integer.parseInt(st.nextToken()) - 1;

		found[departure] = true;
		dist[departure] = 0;
		node[departure].sb.append(departure + 1);
		node[departure].count = 1;
		int cur = departure;

		for (int k = 0; k < n - 1; k++) {

			for (int i = 0; i < node[cur].canGo.size(); i++) {
				if (!near[node[cur].canGo.get(i)] && !found[node[cur].canGo.get(i)]) { // s-v 집단 중 리스트에 포함 안된 곳
					near[node[cur].canGo.get(i)] = true;
					list.add(node[cur].canGo.get(i)); // 갈수있음 리스트에 추가
					if (dist[node[cur].canGo.get(i)] == Long.MAX_VALUE) { // dist 초기값일 경우, 현재 위치까지의 dist + cost 로 초기화
						dist[node[cur].canGo.get(i)] = dist[cur] + costs[cur][node[cur].canGo.get(i)];
						node[node[cur].canGo.get(i)].sb = new StringBuffer(
								node[cur].sb + " " + (node[cur].canGo.get(i) + 1));
						node[node[cur].canGo.get(i)].count = node[cur].count + 1;
					}
				}
			}

			int u = getMin(list, dist, found);
			cur = u;
			found[u] = true;

			for (int j = 0; j < node[u].canGo.size(); j++) {
				if (!found[node[u].canGo.get(j)]) {
					if (dist[node[cur].canGo.get(j)] == Long.MAX_VALUE
							|| (dist[node[u].canGo.get(j)] > dist[u] + costs[u][node[u].canGo.get(j)])) {
						dist[node[u].canGo.get(j)] = dist[u] + costs[u][node[u].canGo.get(j)];
						node[node[u].canGo.get(j)].sb = new StringBuffer(node[u].sb + " " + (node[u].canGo.get(j) + 1));
						node[node[u].canGo.get(j)].count = node[u].count + 1;
					}
				}
			}
		}
		bw.write(dist[arrival] + "\n");
		bw.write(node[arrival].count + "\n");
		bw.write(node[arrival].sb.toString() + "\n");
		bw.flush();
		bw.close();
	}

}
