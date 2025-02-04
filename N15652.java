package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class N15652 {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {			
			Scanner in = new Scanner(System.in);
			
			int n = in.nextInt();
			int m = in.nextInt();
			
			// ������ ��� 1�� �������� �����ϹǷ�: 
			LinkedList<Integer> list = new LinkedList<>();
			
			for(int i=0;i<m;i++)
				list.add(1);
			
			boolean exit = true;
			
			while(exit) {
				for(int i=0;i<m;i++) {
					System.out.print(list.get(i)+" ");
				}
				System.out.println();
				
				// ����Ʈ�� �� ���� �ݺ���
				for(int i=m-1; i>=0; i--) {
					// ���� ����Ʈ �� ����
					list.set(i, list.get(i) + 1);
					
					if(list.get(i) > n) { // �����ߴµ� �� ���� n���� ũ��
						// ���� �� ����Ʈ�� �ƴ϶��
						if(i>0) {
							continue;
						} else {
							exit = false;
							break;
						}
					} else {
						// ��������
						for(int k=i;k<m;k++) {
							list.set(k, list.get(i)); // �� ���� ����Ʈ �տ� ����Ʈ ������ �ʱ�ȭ
						}
						break;
					}
					
				}
			}
			
			in.close();
	}
}
