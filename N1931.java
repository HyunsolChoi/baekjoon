package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1931 {
	private static class Meeting {
		long start;
		long end;

		public Meeting(long s, long e) {
			start = s;
			end = e;
		}
	}

	private static class MeetingQ {
		long end;
		int idx;
		int cnt;

		public MeetingQ(long e, int i, int c) {
			end = e;
			idx = i;
			cnt = c;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Meeting> list = new ArrayList<>();
		Queue<MeetingQ> queue = new LinkedList<>();
		int result = -1;
		
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(new Meeting(in.nextLong(), in.nextLong()));
		}

		// ���۽ð� ���� �������� ����, �ߺ� �� �ð��� ���� ���� ��
		Collections.sort(list, new Comparator<Meeting>() {
			public int compare(Meeting m1, Meeting m2) {
				int result = Long.compare(m1.end, m2.end);
				if (result == 0) {
					return Long.compare(m1.start, m2.start);
				}
				return result;
			}
		});
		
		queue.add(new MeetingQ(list.get(0).end, 0, 1)); // ���� ���� �����ϴ� �ָ� ť�� ����

		while (!queue.isEmpty()) {
			MeetingQ m = queue.poll();
			
			if(m.cnt > result)
				result = m.cnt;

			for (int i = m.idx + 1; i < list.size(); i++) {
				if (list.get(i).start >= m.end) { // ���� ���� ã�� ���� ���� �����ϴ� ȸ��
					queue.add(new MeetingQ(list.get(i).end, i, m.cnt + 1)); //
					break;
				}
			}
		}
		
		
		System.out.println(result);

		in.close();
	}

}
