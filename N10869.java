package baekjoon;

import java.util.Scanner;

public class N10869 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		int b = in.nextInt();

		System.out.println((a + b) + "\n" + (a - b) + "\n" + (a * b) + "\n" + (a / b) + "\n" + (a % b));

		in.close();
	}

}
