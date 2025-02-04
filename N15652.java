package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class N15652 {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {			
			Scanner in = new Scanner(System.in);
			
			int n = in.nextInt();
			int m = in.nextInt();
			
			// 시작은 모두 1은 시점부터 시작하므로: 
			LinkedList<Integer> list = new LinkedList<>();
			
			for(int i=0;i<m;i++)
				list.add(1);
			
			boolean exit = true;
			
			while(exit) {
				for(int i=0;i<m;i++) {
					System.out.print(list.get(i)+" ");
				}
				System.out.println();
				
				// 리스트의 값 증가 반복문
				for(int i=m-1; i>=0; i--) {
					// 현재 리스트 값 증가
					list.set(i, list.get(i) + 1);
					
					if(list.get(i) > n) { // 증가했는데 이 값이 n보다 크면
						// 가장 앞 리스트가 아니라면
						if(i>0) {
							continue;
						} else {
							exit = false;
							break;
						}
					} else {
						// 문제없음
						for(int k=i;k<m;k++) {
							list.set(k, list.get(i)); // 그 이후 리스트 앞에 리스트 값으로 초기화
						}
						break;
					}
					
				}
			}
			
			in.close();
	}
}
