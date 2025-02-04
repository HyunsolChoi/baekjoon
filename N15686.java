package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class N15686 {
	private static ArrayList<int[]> bhc = new ArrayList<>();
	private static ArrayList<int[]> house = new ArrayList<>();
	private static int minDist = Integer.MAX_VALUE;
	private static int M = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		M = in.nextInt();

		int map[][] = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
				if (map[i][j] == 2)
					bhc.add(new int[] { i, j });
				else if (map[i][j] == 1)
					house.add(new int[] { i, j });
			}
		
		ArrayList<int[]> selected = new ArrayList<>();
		combination(0,0,selected);
		
		System.out.println(minDist);
		
		in.close();
	}

	public static void combination(int start, int depth, ArrayList<int[]> selected) {
		if (depth == M) {
			int dist = getChickenDistance(selected);
			minDist = minDist > dist ? dist : minDist;
			return;
		}

		for (int i = start; i < bhc.size(); i++) {
			selected.add(bhc.get(i));
			combination(i + 1, depth + 1, selected);
			selected.remove(selected.size() - 1);
		}
	}

	public static int getChickenDistance(ArrayList<int[]> selected) {
		int minChickenDist = Integer.MAX_VALUE;
		int totalMinDist = 0;
		
		for (int[] home : house) {
			minChickenDist = Integer.MAX_VALUE;
			for (int[] chicken : selected) {
				int dist = Math.abs(chicken[0] - home[0]) + Math.abs(chicken[1] - home[1]);
				minChickenDist = minChickenDist > dist ? dist : minChickenDist;
			}
			totalMinDist +=  minChickenDist;
		}

		return totalMinDist;
	}

}
