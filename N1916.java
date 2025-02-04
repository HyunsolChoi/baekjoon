package baekjoon;

import java.util.*;

public class N1916 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();  // ���� ��
        int m = in.nextInt();  // ���� ��

        // ���� ����Ʈ ����
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        // �׷��� �Է�
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();  // ��� ����
            int v = in.nextInt();  // ���� ����
            int w = in.nextInt();  // ���
            graph[u].add(new int[] { v, w });
        }

        int src = in.nextInt();  // ���� ����
        int dst = in.nextInt();  // ���� ����

        // ���ͽ�Ʈ�� �˰��� ����
        long[] cost = new long[n + 1];
        Arrays.fill(cost, Long.MAX_VALUE);  // �ʱ� ��� ���Ѵ�� ����
        cost[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] { src, 0 });  // {����, ���}

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
