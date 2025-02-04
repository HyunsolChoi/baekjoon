package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2579 {

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);

			// 방향 배열
			int[] dx = {0, 0, -1, 1};
	        int[] dy = {1, -1, 0, 0};
			
			int cnt = 1;
			
			while(true) {
				Queue<int[]> queue = new LinkedList<>();
				int n = in.nextInt();
				
				if(n==0)
					break;
				
				int cave[][] = new int[n][n]; // 도둑 루피의 크기 (=cost)
				int rupee[][] = new int[n][n]; // 감소 루피 (작을 수록 좋음) (=distance) =경로 누적합
				
				// i는 행, k는 열
				for(int i=0;i<n;i++) {
					for(int k=0;k<n;k++){
						cave[i][k] = in.nextInt();
						rupee[i][k] = Integer.MAX_VALUE;
					}
				}
				
				rupee[0][0] = cave[0][0]; // 시작점
				queue.add(new int[]{0, 0}); // 시작점 추가
				
				while (!queue.isEmpty()) {
					int[] current = queue.poll();
		            int x = current[0];
		            int y = current[1];
		            
		            for (int d = 0; d < 4; d++) {
		                int nx = x + dx[d];
		                int ny = y + dy[d];

		                if (nx >= 0 && nx < n && ny >= 0 && ny < n && (rupee[nx][ny] > rupee[x][y] + cave[nx][ny])) {
		                    queue.add(new int[]{nx, ny});
		                    rupee[nx][ny] = rupee[x][y] + cave[nx][ny];
		                }
		            }
				}
				
				System.out.println("Problem " + cnt + ": " + rupee[n-1][n-1]);
				cnt++;
			}
			
			in.close();
	}
}
