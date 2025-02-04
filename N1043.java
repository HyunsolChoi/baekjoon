package baekjoon;

import java.util.*;

public class N1043 {
	static ArrayList<int[]> party = new ArrayList<>();

	private static void delFromList(int knower) { // �Ű������� ��ȣ�� ���Ե� ����Ʈ�� ����, �����ϰ� �Բ� �ִ� �ο��鿡 ���ؼ� ���ȣ��
		if (party.size() == 0) // ����Ʈ�� �� �̻� �۾��� �� ������ ��ȯ
			return;

		for (int i = 0; i < party.size(); i++) {
			boolean haveKnower = false; // �Ű����� (������ �ƴ� ��) �� ��Ƽ�� ���ԵǾ��ִ���
			int members[] = party.get(i); // ��Ƽ�� ��� �迭
			for (int member : members) { // ��� �Ѹ� ��
				if (member == knower) { // ������ �ƴ� �ڰ� �ִٸ�
					haveKnower = true; // true set �� break
					break;
				}
			}
			if (haveKnower) { // ������ �ƴ� �� ���� ���ο� ����
				party.remove(i); // ��Ƽ ��Ͽ��� �ش� ��Ƽ�� ����
				i = -1; // ��͸� �ϹǷ� ������ ���� �� �ٽ� ���ƿ��� list�� �پ�Ѵ� ��찡 ���� �� �����Ƿ� �� û��ξ� �񱳵ǵ���
				for (int member : members) { // �ش� ��Ƽ�� ��� ��
					if (member != knower) // ���� ������ �ƴ� �ڰ� �ƴ� ��� �̵鿡 ���ؼ�
						delFromList(member); // delFromList ��� ȣ��
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); // ����� �� N
		int m = in.nextInt(); // ��Ƽ�� �� M

		int cntOfKnowers = in.nextInt(); // ������ �ƴ� ���� �� 

		int knowersOfTruth[] = new int[cntOfKnowers]; // ������ �ƴ� �ڵ��� �迭 

		for (int i = 0; i < cntOfKnowers; i++) // ������ �ƴ� �ڵ� �Է�
			knowersOfTruth[i] = in.nextInt();

		for (int i = 0; i < m; i++) { // M���� ��Ƽ �Է�
			int sizeOfParty = in.nextInt();
			int arr[] = new int[sizeOfParty]; // ��Ƽ ��� ��ȣ ���� �迭 
			for (int p = 0; p < sizeOfParty; p++) { // ��Ƽ ��� ��ȣ �Է�
				arr[p] = in.nextInt();
			}
			party.add(arr); // �Է� ��Ƽ �迭 ����Ʈ�� ����
		}

		for (int i = 0; i < cntOfKnowers; i++) // �ʱ� ������ �ƴ� �ڵ� delFromList �Ű������� ����
			delFromList(knowersOfTruth[i]);

		System.out.println(party.size());

		in.close();
	}

}
