package test_190117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

//균형 잡힌 문자열(소,중,대괄호의 열고 닫기)인지 판별하는 프로그램 작성하기
public class B_4949 {

	static ArrayList<String> ans = new ArrayList<>();
	
	public static boolean result(String str) {
		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			//여는 괄호는 저장
			if(str.charAt(i)=='['||str.charAt(i)=='{'||str.charAt(i)=='(') {
				st.push(str.charAt(i));
			}
			//괄호의 쌍이 형성되는 순간 저장했던 여는 괄호 제거
			else if(!st.isEmpty()&&st.peek()=='['&&str.charAt(i)==']') {
				st.pop();
			}else if(!st.isEmpty()&&st.peek()=='{'&&str.charAt(i)=='}') {
				st.pop();
			}else if(!st.isEmpty()&&st.peek()=='('&&str.charAt(i)==')') {
				st.pop();
			}
		}
		if(st.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				for(int i=0;i<ans.size();i++) {
					System.out.println(ans.get(i));
				}
				System.exit(0);
			}
			boolean flag = result(str);
			if(flag) {
				ans.add("YES");
			}else {
				ans.add("NO");
			}
		}
	}
}
