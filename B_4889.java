package test_190125;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//��ȣ�� ���Ե� Ư�� ���ڿ��� �־��� ��, �� ���ڿ��� �������� ���ڿ����� �Ǻ��ϴ� ���α׷� �ۼ��ϱ�
public class B_4889 {

	public static int result(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='{') {
				st.push('{');
			}else if(str.charAt(i)=='}') {
				if(!st.isEmpty()&&st.peek()=='{') {
					st.pop();
				}else {
					st.push('}');
				}
			}
		}
		
		int open = 0;
		int close = 0;
		//���ÿ� ����ִ� ���� ��ȣ, �ݴ� ��ȣ�� �� ���� Ž��
		for(int i=0;i<st.size();i++) {
			if(st.get(i)=='{') {
				open++;
			}else {
				close++;
			}
		}
		
		if(open%2==0) {
			open/=2;
		}else {
			open=open/2+1;
		}
		
		if(close%2==0) {
			close/=2;
		}else {
			close=close/2+1;
		}
		
		return open+close;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//���� ���� �迭
		ArrayList<String> ans = new ArrayList<>();
		int k = 1;
		while(true) {
			String str = sc.next();
			if(str.charAt(0)=='-') {
				//���� ��� �� ����
				for(int i=0;i<ans.size();i++) {
					System.out.println(ans.get(i));
				}
				break;
			}
			int tmp = result(str);
			ans.add(k+". "+tmp);
			k++;
		}
	}
}
