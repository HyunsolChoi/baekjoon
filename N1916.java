package baekjoon;

import java.util.*;

public class N1916 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();  // 도시 수
        int m = in.nextInt();  // 버스 수

        // 인접 리스트 생성
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        // 그래프 입력
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();  // 출발 도시
            int v = in.nextInt();  // 도착 도시
            int w = in.nextInt();  // 비용
            graph[u].add(new int[] { v, w });
        }

        int src = in.nextInt();  // 시작 도시
        int dst = in.nextInt();  // 도착 도시

        // 다익스트라 알고리즘 수행
        long[] cost = new long[n + 1];
        Arrays.fill(cost, Long.MAX_VALUE);  // 초기 비용 무한대로 설정
        cost[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] { src, 0 });  // {도시, 비용}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curCost = current[1];

            if (curCost > cost[curNode]) continue;

            for (int[] neighbor : graph[curNode]) {
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];

                if (cost[nextNode] > cost[curNode] + nextCost) {
                    cost[nextNode] = cost[curNode] + nextCost;
                    pq.add(new int[] { nextNode, (int) cost[nextNode] });
                }
            }
        }

        System.out.println(cost[dst]);

        in.close();
    }
}
