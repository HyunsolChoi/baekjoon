package baekjoon;

import java.util.*;

public class N1043 {
	static ArrayList<int[]> party = new ArrayList<>();

	private static void delFromList(int knower) { // 매개변수의 번호가 포함된 리스트를 도출, 삭제하고 함께 있는 인원들에 대해서 재귀호출
		if (party.size() == 0) // 리스트가 더 이상 작아질 수 없으면 반환
			return;

		for (int i = 0; i < party.size(); i++) {
			boolean haveKnower = false; // 매개변수 (진실을 아는 자) 가 파티에 포함되어있는지
			int members[] = party.get(i); // 파티의 멤버 배열
			for (int member : members) { // 멤버 한명씩 비교
				if (member == knower) { // 지신을 아는 자가 있다면
					haveKnower = true; // true set 후 break
					break;
				}
			}
			if (haveKnower) { // 진실을 아는 자 포함 여부에 따라
				party.remove(i); // 파티 목록에서 해당 파티를 삭제
				i = -1; // 재귀를 하므로 여러개 삭제 후 다시 돌아오면 list를 뛰어넘는 경우가 생길 수 있으므로 맨 청듬부어 비교되도록
				for (int member : members) { // 해당 파티의 멤버 중
					if (member != knower) // 지금 진실을 아는 자가 아닌 모든 이들에 대해서
						delFromList(member); // delFromList 재귀 호출
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); // 사람의 수 N
		int m = in.nextInt(); // 파티의 수 M

		int cntOfKnowers = in.nextInt(); // 진실을 아는 자의 수 

		int knowersOfTruth[] = new int[cntOfKnowers]; // 진실을 아는 자들의 배열 

		for (int i = 0; i < cntOfKnowers; i++) // 진실을 아는 자들 입력
			knowersOfTruth[i] = in.nextInt();

		for (int i = 0; i < m; i++) { // M개의 파티 입력
			int sizeOfParty = in.nextInt();
			int arr[] = new int[sizeOfParty]; // 파티 멤버 번호 저장 배열 
			for (int p = 0; p < sizeOfParty; p++) { // 파티 멤버 번호 입력
				arr[p] = in.nextInt();
			}
			party.add(arr); // 입력 파티 배열 리스트에 삽입
		}

		for (int i = 0; i < cntOfKnowers; i++) // 초기 지신을 아는 자들 delFromList 매개변수로 삽입
			delFromList(knowersOfTruth[i]);

		System.out.println(party.size());

		in.close();
	}

}
