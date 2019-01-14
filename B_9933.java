package test_190114;

import java.util.Scanner;

//민균이가 비밀번호를 입력하는 규칙이 주어질 때, 정답이 되는 비밀번호의 길이와 가운데 글자 출력하기
public class B_9933 {

	public static boolean result(String str1, String str2) {
		for(int i=0;i<str1.length();i++) {
			//뒤집은 문자가 다르면
			if(str1.charAt(i)!=str2.charAt(str2.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(2<=n&&n<=100) {
			String [] words = new String[n];
			//단어 입력
			for(int i=0;i<words.length;i++) {
				words[i]=sc.next();
			}
			//탐색 실행
			for(int i=0;i<words.length-1;i++) {
				for(int j=i+1;j<words.length;j++) {
					//단어의 길이가 같으면(서로 뒤집은 문자열인지 확인)
					if(words[i].length()==words[j].length()) {
						boolean flag = result(words[i],words[j]);
						if(flag) {
							System.out.println(words[i].length()+" "+words[i].charAt(words[i].length()/2));
							System.exit(0);
						}
					}
				}
			}
		}
	}
}
