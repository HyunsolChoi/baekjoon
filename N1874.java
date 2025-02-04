package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class N1874 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int n = in.nextInt();

		int nums[] = new int[n];

		for (int i = 0; i < n; i++)
			nums[i] = in.nextInt();

		int idx = 0;
		boolean wrong = false;
		int v = 1;
		while(v<=n) {
			if(!stack.isEmpty()) { // ������ ������� ���� ���¿���
				if(stack.peek()==nums[idx]) { // ������ �ֻ���� ���� ã�ƾ��� ������ ���ٸ�
					sb.append("-\n");
					idx++;
					stack.pop();
				} else { // ������ �ֻ���� ���� ã�ƾ��� ������ �ٸ��� ���ÿ� ����
					if(stack.peek() > v) {
						wrong = true;
						break;
					}
					sb.append("+\n");
					stack.add(v);
					v++;
				}
			} else {
				sb.append("+\n");
				stack.add(v);
				v++;
			}
		}
		
		if(!wrong) {
			while(!stack.isEmpty()) {
				if(stack.pop() == nums[idx]) {
					idx++;
					sb.append("-\n");
				} else {
					wrong = true;
					break;
				}
			}
		}
		
		if(wrong) {
			System.out.println("NO");
		} else {
			System.out.print(sb);
		}
		

		in.close();
	}

}
