package test_190115;

import java.util.Scanner;

//n개의 파일 이름이 주어질 때, 파일 이름의 특정 패턴 추출하여 출력하기
public class B_1032 {

	//두 개의 문자열 중 공통된 문자열 추출
	public static String result(String str1, String str2) {
		String tmp = "";
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)==str2.charAt(i)) {
				boolean flag = false;
				tmp+=str1.charAt(i);
				for(int j=i+1;j<str1.length();j++) {
					if(str1.charAt(j)!=str2.charAt(j)) {
						flag=true;
						break;
					}
					tmp+=str1.charAt(j);
				}
				if(flag) {
					break;
				}
			}
		}
		return tmp;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=50) {
			String [] words = new String[n];
			//단어 입력
			for(int i=0;i<words.length;i++) {
				String str = sc.next();
				//단어의 길이는 최대 50
				if(str.length()<=50) {
					words[i]=str;
				}
			}
			//초기 추출한 공통 문자열
			String tmp = result(words[0],words[1]);
			//탐색 실행(각 자리에 있는 알파벳 비교 -> 모두 같은 경우 출력할 문자열 생성 시작)
			for(int i=2;i<words.length;i++) {
				tmp = result(tmp,words[i]);
			}
			int len = words[0].length()-tmp.length();
			for(int i=0;i<len;i++) {
				tmp+='?';
			}
			System.out.println(tmp);
		}
	}
}
