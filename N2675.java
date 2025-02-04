package baekjoon;

import java.util.Scanner;

public class N2675 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int r = in.nextInt();
			String str = in.next();
			for(int j = 0;j<str.length();j++) {
				for(int k=0;k<r;k++)
					System.out.print(str.charAt(j));
			}
			System.out.println();
		}

		in.close();
	}

}
