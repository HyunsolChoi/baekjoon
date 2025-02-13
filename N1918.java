package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class N1918 {
	static StringBuffer input;
	static int i;

	private static String getBracket() { // �� ���� ��ȣ ������ ���, �ݴ� ��ȣ ������ ��ȯ
		i++; // ��ȣ ���� �ε���
		StringBuffer sb = new StringBuffer();
		LinkedList<Character> stack = new LinkedList<>();

		while (i < input.length()) {
			char c = input.charAt(i);
			if (c == '(') {
				sb.append(getBracket());
			} else if (c == ')') {
				while(!stack.isEmpty()) {
					sb.append(stack.pollLast());
				}
				return sb.toString();
			} else if (c >= 'A' && c <= 'Z') { // ������ ���
				sb.append(c);
			} else {
				if (stack.isEmpty()) {
					stack.add(c);
				} else {
					if (stack.peekLast() == '+' || stack.peekLast() == '-') {
						if (c == '+' || c == '-') {
							sb.append(stack.pollLast());
						} 
						stack.add(c);
					} else { // ���ÿ� *, /
						if (c == '*' || c == '/') {
							sb.append(stack.pollLast());
						} else {
							while(!stack.isEmpty()) {
								sb.append(stack.pollLast());
							}
						}
						stack.add(c);
					}
				}
			}
			i++;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<Character> stack = new LinkedList<>();

		input = new StringBuffer(br.readLine());
		StringBuffer sb = new StringBuffer();

		for (i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= 'A' && c <= 'Z') { // �ǿ������� ���
				sb.append(c);
			} else if (c == '(') {
				sb.append(getBracket());
			} else { // �������� ���
				if (stack.isEmpty()) {
					stack.add(c);
				} else {
					if (stack.peekLast() == '+' || stack.peekLast() == '-') {
						if (c == '+' || c == '-') {
							sb.append(stack.pollLast());
						} 
						stack.add(c);
					} else { // ���ÿ� *, /
						if (c == '*' || c == '/') {
							sb.append(stack.pollLast());
						} else {
							while(!stack.isEmpty()) {
								sb.append(stack.pollLast());
							}
						}
						stack.add(c);
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
