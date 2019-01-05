package solution;

import java.util.Scanner;
import java.util.Stack;

//�Ϲ� ������� ����ǥ������� ��ȯ�� ��� ����ϱ�
public class Q129 {

	//�����ڸ� ���� ���� �迭
	static Stack<Character> st = new Stack<>();
	//����ǥ������� ��ȯ�� ��� ������ ���� ����
	static StringBuilder sb = new StringBuilder();
	
	//')'������ ���� ��(��ȣ�� �켱������ ���� �����Ƿ�, ���� ��ȯ)
	public static void close() {
		while(true) {
			char a = st.pop();
			if(a=='(') {
				break;
			}
			//��ȣ �̿��� �������̸�
			else {
				sb.append(a);
			}
		}
	}
	
	//�����ڳ����� �켱���� �˻�
	public static void operand(char a) {
		while(true) {
			//�켱���� ���ǿ� ������ ������ �ռ� ����� ������ �ϳ��� ���(�����ϴ� ����, ���� ������ ����)
			if(st.isEmpty()||st.peek()=='('||
					((a=='*'||a=='/')&&(st.peek()=='+'||st.peek()=='-'))) {
				st.push(a);
				break;
			}else {
				sb.append(st.pop());
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='*'||str.charAt(i)=='/'||str.charAt(i)=='+'||str.charAt(i)=='-') {
				operand(str.charAt(i));
			}else if(str.charAt(i)=='(') {
				st.push(str.charAt(i));
			}else if(str.charAt(i)==')') {
				close();
			}
			//�����̸� ����
			else {
				sb.append(str.charAt(i));
			}
		}
		//�����ִ� ������ ��� ���
		for(int i=0;i<st.size();i++) {
			sb.append(st.pop());
		}
		System.out.println(sb.toString());
	}
}
