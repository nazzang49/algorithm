package solution;

import java.util.Scanner;
import java.util.Stack;

//길이가 다른 여러개의 쇠막대기를 겹친 상태로 레이저를 수직으로 발사할 때(VPS 문자열 활용) 발생하는 쇠막대기 조각 개수 구하기
public class Q4 {

	//쇠막대기 조각 개수 구하는 메소드
	public static int vps(String str) {
		int cnt = 0;
		boolean flag = false;
		//스택 활용
		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				flag = true;
				st.push('(');
			}else {
				st.pop();
				//연속해서 ')' 기호이면(커팅 한번 실시+1)
				if(!flag) {
					cnt++;
				}else {
					//커팅할 때
					if(st.size()!=0) {
						cnt+=st.size();
					}	
				}
				flag = false;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//소괄호만 입력 가능
		String str = sc.next();
		int cnt = vps(str);
		System.out.println(cnt);
	}
}
