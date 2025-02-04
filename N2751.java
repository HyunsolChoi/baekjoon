package baekjoon;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N2751 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
		 
		 int n = scanner.nextInt();   
		 
		 // n ����� ������ ������ ����Ʈ ����
		 ArrayList<Integer> list = new ArrayList<>();

		 for(int i=0; i<n; i++) {
			 // i�� index�� n�� ���� �ݺ� �Է�, �ߺ� �Է��� ���ٴ� �����Ͽ� ���� ( 1<= n <= 1,000,000 )
			 list.add(scanner.nextInt());
		 }
		 
		 Collections.sort(list);
		 
		 for(int value : list) {
			 sb.append(value).append('\n');
		 }
		 
		 System.out.println(sb);
		 
		 scanner.close();
	}
}
