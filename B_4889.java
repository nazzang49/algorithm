package test_190125;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//괄호가 포함된 특정 문자열이 주어질 때, 이 문자열이 안정적인 문자열인지 판별하는 프로그램 작성하기
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
		//스택에 들어있는 여는 괄호, 닫는 괄호의 각 갯수 탐색
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
		
		//정답 저장 배열
		ArrayList<String> ans = new ArrayList<>();
		int k = 1;
		while(true) {
			String str = sc.next();
			if(str.charAt(0)=='-') {
				//정답 출력 및 종료
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
