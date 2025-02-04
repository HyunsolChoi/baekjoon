package baekjoon;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N2751 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
		 
		 int n = scanner.nextInt();   
		 
		 // n 사이즈를 가지는 정수형 리스트 생성
		 ArrayList<Integer> list = new ArrayList<>();

		 for(int i=0; i<n; i++) {
			 // i번 index에 n번 값을 반복 입력, 중복 입력은 없다는 조건하에 동작 ( 1<= n <= 1,000,000 )
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
