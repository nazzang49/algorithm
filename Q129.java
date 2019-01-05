package solution;

import java.util.Scanner;
import java.util.Stack;

//일반 연산식을 후위표기식으로 변환한 결과 출력하기
public class Q129 {

	//연산자만 담을 스택 배열
	static Stack<Character> st = new Stack<>();
	//후위표기식으로 변환한 결과 저장할 버퍼 변수
	static StringBuilder sb = new StringBuilder();
	
	//')'연산자 등장 시(괄호의 우선순위가 가장 높으므로, 먼저 변환)
	public static void close() {
		while(true) {
			char a = st.pop();
			if(a=='(') {
				break;
			}
			//괄호 이외의 연산자이면
			else {
				sb.append(a);
			}
		}
	}
	
	//연산자끼리의 우선순위 검사
	public static void operand(char a) {
		while(true) {
			//우선순위 조건에 만족할 때까지 앞서 저장된 연산자 하나씩 출력(만족하는 순간, 현재 연산자 저장)
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
			//정수이면 저장
			else {
				sb.append(str.charAt(i));
			}
		}
		//남아있는 연산자 모두 출력
		for(int i=0;i<st.size();i++) {
			sb.append(st.pop());
		}
		System.out.println(sb.toString());
	}
}
