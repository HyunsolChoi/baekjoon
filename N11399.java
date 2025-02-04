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
			nums.add(i, in.nextInt());  // �ڿ� �߰�
			
			for(int j = 0; j < i; j++) {
				if(nums.get(i) < nums.get(j)) {
					// j��°���� ������ �ش� ������ �� �߰�, ���Ĵ� �з���
					nums.add(j, nums.get(i));
					// ����
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
