package test_190121;

import java.util.Scanner;

//단어가 주어질 때, 단어에 사용된 각 알파벳의 개수를 공백으로 모두 출력하기
public class B_10808 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<100) {
			int [] alpha = new int[26];
			for(int i=0;i<str.length();i++) {
				alpha[str.charAt(i)-'a']++;
			}
			//정답 출력
			for(int i=0;i<alpha.length;i++) {
				System.out.print(alpha[i]+" ");
			}
		}	
	}
}
