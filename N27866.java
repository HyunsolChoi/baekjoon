package baekjoon;

import java.util.Scanner;

public class N27866 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.next();

		int index = in.nextInt();
		
		System.out.println(str.charAt(index-1));

		in.close();
	}

}
