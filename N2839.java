package baekjoon;

import java.util.Scanner;

public class N2839 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.close();
		
		int divisiblePos = -1;
		int cntOf3kg = 0;
		
		if(n%5==0) {
			System.out.println(n/5);
			return;
		}
		
		while(n>0) {
			if(n%5==0) {
				divisiblePos = n;
				break;
			}
			n-=3;
			cntOf3kg ++;
		}
		
		if(divisiblePos!=-1||n==0)
			System.out.println(cntOf3kg + n/5);
		else
			System.out.println(-1);
	}

}
