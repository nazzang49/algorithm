package test_190118;

import java.util.Scanner;

//평문, 암호화 키, 암호화 규칙이 주어질 때 암호화된 문장 출력하기
public class B_1718 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//평문
		String str = sc.nextLine();
		//암호화키
		String pw = sc.next();
		
		if(str.length()<=30000) {
			String ans = "";
			for(int i=0;i<str.length();i++) {
				//공백은 그대로 공백 유지
				if(str.charAt(i)==' ') {
					ans+=' ';
				}
				//공백이 아닌 경우(알파벳인 경우)
				else {
					//암호화키에서 몇번째 알파벳인지 저장
					int idx = pw.charAt(i%pw.length())-96;
					System.out.println(idx);
					//암호화한 문자가 알파벳 범위를 벗어나면(a보다 작아지면)
					if(str.charAt(i)-idx<97) {
						ans+=(char)(str.charAt(i)-idx-97+123);
					}else {
						System.out.println((char)(str.charAt(i)-idx));
						ans+=(char)(str.charAt(i)-idx);
					}
				}
			}
			System.out.println(ans);
		}
	}
}
