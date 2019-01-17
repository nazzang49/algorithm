package test_190117;

import java.util.Scanner;

//두 개의 단어가 주어질 때, 두 단어를 같도록 만들기 위해 제거해야 하는 알파벳의 총 갯수 구하기
public class B_1919 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		if(1<=str1.length()&&str1.length()<=1000&&1<=str2.length()&&str2.length()<=1000) {
			//각각의 문자열에 어떠한 알파벳이 몇번 쓰였는지 저장
			int [] str1_char = new int[26];
			int [] str2_char = new int[26];
			
			for(int i=0;i<str1.length();i++) {
				str1_char[str1.charAt(i)-'a']++;
			}
			for(int i=0;i<str2.length();i++) {
				str2_char[str2.charAt(i)-'a']++;
			}
			int cnt = 0;
			for(int i=0;i<str1_char.length;i++) {
				cnt+=Math.abs(str1_char[i]-str2_char[i]);
			}
			System.out.println(cnt);
		}
	}
}
