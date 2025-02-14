package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N14938 {
	static int n;

	private static int getMin(boolean found[], int dist[]) {
		int min = Integer.MAX_VALUE;
		int minIdx = 0;

		for (int i = 0; i < n; i++) {
			if (!found[i] && dist[i] < min) {
				min = dist[i];
				minIdx = i;
			}
		}
		return minIdx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int item[] = new int[n];
		int cost[][] = new int[n][n];
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int maxItem = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			maxItem = maxItem < item[i] ? item[i] : maxItem;
			for (int j = 0; j < n; j++) 
				cost[i][j] = Integer.MAX_VALUE / 2 - 1;
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int dep = Integer.parseInt(st.nextToken()) - 1;
			int arr = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());

			if(cost[dep][arr]!=0)
				if(cost[dep][arr]<=dist)
					continue;
			cost[dep][arr] = dist;
			cost[arr][dep] = dist;
		}

		for (int dep = 0; dep < n; dep++) {
			boolean found[] = new boolean[n];
			int dist[] = new int[n];
			int totalItem = 0;
			for (int i = 0; i < n; i++) {
				dist[i] = cost[dep][i];
			}
			found[dep] = true;
			dist[dep] = 0;
			for (int i = 0; i < n - 2; i++) {
				int u = getMin(found, dist);
				found[u] = true;
				for (int w = 0; w < n; w++) {
					if (!found[w]) {
						if (dist[w] > dist[u] + cost[u][w])
							dist[w] = dist[u] + cost[u][w];
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (dep == i || dist[i] <= m) {
					totalItem += item[i];
				}
			}
			if (maxItem < totalItem)
				maxItem = totalItem;
		}

		bw.write(maxItem + "\n");
		bw.flush();
		bw.close();
	}

}
