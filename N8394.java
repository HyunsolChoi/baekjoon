package baekjoon;
import java.util.Scanner;

public class N8394 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int prev = 1;
		int result = 2;
		int temp = 0;
		
		for(int i=2;i<n;i++) {
			temp = result;
			result = (result + prev) % 10;
			prev = temp;
		}
			
		if(n==1) {
			System.out.println(prev);
		} else if(n>=2) {
			System.out.println(result);
		} 
		
		in.close();
	}

}
