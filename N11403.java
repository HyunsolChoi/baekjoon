package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		int n = Integer.parseInt(st.nextToken());

		int graph[][] = new int[n][n];
		int result[][] = new int[n][n];
		boolean visit[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				result[i][j] = 0; // 결과값 초기화, 안정성을 위해 별도로 작성
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {// i 행의 1인 j 큐에 삽입
				if (graph[i][j] == 1) {
					queue.add(j);
					visit[j] = true;
				} else
					visit[j] = false;
			}

			while (!queue.isEmpty()) {
				int canGo = queue.poll();
				result[i][canGo] = 1;
				
				for(int j=0;j<n;j++) {
					if(graph[canGo][j]==1&&!visit[j]) {
						queue.add(j);
						visit[j] = true;
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				bw.write(result[i][j] + " ");
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
