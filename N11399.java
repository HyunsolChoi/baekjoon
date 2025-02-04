package baekjoon;
import java.util.LinkedList;
import java.util.Scanner;

public class N11399 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		LinkedList<Integer> nums = new LinkedList<>();
		
		int waitingTime = 0;
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			nums.add(i, in.nextInt());  // 뒤에 추가
			
			for(int j = 0; j < i; j++) {
				if(nums.get(i) < nums.get(j)) {
					// j번째보다 작으면 해당 위지에 값 추가, 이후는 밀려남
					nums.add(j, nums.get(i));
					// 삭제
					nums.remove(i+1);
					break;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			waitingTime = waitingTime + nums.get(i);
			result += waitingTime;
		}
		
		System.out.println(result);
		
		in.close();
	}

}
