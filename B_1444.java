package test_190121;

import java.util.Scanner;

//숌 언어를 해석하여 중복없이 사용된 알파벳의 총 갯수 구하기
public class B_1444 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int cnt = 0;
		
		//입력으로 주어지는 문장의 최대 길이는 3000자
		if(n.length()<=3000) {
			//새로운 알파벳 형태가 등장하면 배열의 값 +1 증가
			int [] alpha = new int[58];
			//한 문자씩 새로운 알파벳 형태인지 확인
			for(int i=0;i<n.length()-1;i++) {
				if(alpha[n.charAt(i)-'A']==0) {
					//인접한 알파벳이 규칙에 성립하는지(소문자-대문자 관계)
					if(Math.abs(n.charAt(i)-n.charAt(i+1))==32) {
						alpha[n.charAt(i)-'A']++;
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
