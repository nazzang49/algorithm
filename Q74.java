package solution;

import java.util.ArrayList;
import java.util.Scanner;

//특정 문자열과 금지 문자열이 입력 될 때, 해당 문자열에서 금지 문자열을 반복해서 삭제하고 남은 최종 문자열 출력하기
public class Q74 {

	static ArrayList<Character> answer = new ArrayList<>();
	
	public static void result(String ban) {
		for(int i=0;i<answer.size();i++) {
			if(answer.get(i)==ban.charAt(0)) {
				boolean flag = false;
				for(int j=1;j<ban.length();j++) {
					if(answer.get(i+j)!=ban.charAt(j)) {
						flag=true;
						break;
					}
				}
				//금지 문자열이 있는 경우
				if(!flag) {
					for(int k=0;k<ban.length();k++) {
						answer.remove(i);
					}
					result(ban);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ban = sc.next();
		
		if(str.length()<=1000000&&ban.length()<=str.length()) {
			for(int i=0;i<str.length();i++) {
				answer.add(str.charAt(i));
			}
			result(ban);
			//정답 출력
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i));
			}
		}
	}
}
