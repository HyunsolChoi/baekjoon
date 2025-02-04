package baekjoon;

import java.util.Scanner;

public class N2753 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int result = 0; // À±³â ¿©ºÎ 

		int year= in.nextInt();
		
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) 
					result = 1;
			} else
				result = 1;
		}
		
		System.out.println(result);
		
		in.close();
	}

}
