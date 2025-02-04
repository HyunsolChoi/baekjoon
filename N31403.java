package baekjoon;

import java.util.Scanner;

public class N31403 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		int stringA = a;
		
		for (int i = b; i >= 1; i = i / 10) {
			stringA*=10;
		}

		System.out.println(a + b - c);
		System.out.println(stringA + b - c);
		in.close();
	}

}
