package baekjoon;

import java.util.Scanner;

public class N1330 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double a = in.nextInt();
		double b = in.nextInt();

		System.out.println(a > b ? ">" : a < b ? "<" : "==");

		in.close();
	}

}
