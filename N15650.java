package baekjoon;
import java.util.LinkedList;
import java.util.Scanner;

public class N15650 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		// ������ ��� 1�� �������� �����ϹǷ�: 
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=1;i<=m;i++)
			list.add(i);
		
		boolean loop = true;
		
		while(loop) {
			for(int i=0;i<m;i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			
			// ����Ʈ�� �� ���� �ݺ���
			for(int i=m-1; i>=0; i--) {
				if(list.get(i) + 1 > n) { //1��
					if(i==0) {// 2��
						loop = false;
						break;
					}else {
						continue;
					}
				} else {
					list.set(i, list.get(i) + 1);
					
					if(n-list.get(i) < m - 1 - i) { // 3��
						if(i==0) {
							loop = false;
							break;
						}
						continue;
					} else {
						for(int k = i + 1; k < m; k++) {
							list.set(k, list.get(i) + k - i);
						}
						break;
					}
				}
			}
		}
		
		in.close();
	}

}
