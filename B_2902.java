package test_190128;

import java.util.Scanner;

//긴 형태의 문자열이 주어졌을 때, 축약된 문자열로 바꾸는 프로그램 작성하기
public class B_2902 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<=100) {
			String ans = "";
			ans+=str.charAt(0);
			//탐색 실행
			for(int i=1;i<str.length()-1;i++) {
				//하이픈 다음 문자는 정답 문자열에 추가
				if(str.charAt(i)=='-') {
					ans+=str.charAt(i+1);
				}
			}
			System.out.println(ans);
		}
	}
}
