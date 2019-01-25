package test_190125;

import java.util.Scanner;

//입력으로 주어진 크로아티아어의 영문 변형을 보고, 몇 개의 크로아티아 알파벳인지 출력하는 프로그램 작성하기
public class B_2941 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int cnt = 0;
		
		//단어의 길이 최대 = 100
		if(str.length()<=100) {
			//단어 탐색
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='-') {
					continue;
				}else if(str.charAt(i)=='=') {
					if(i-2>=0&&str.substring(i-2, i).equals("dz")) {
						cnt--;
					}
					continue;
				}else if(str.charAt(i)=='j') {
					if(i-1>=0&&(str.charAt(i-1)=='l'||str.charAt(i-1)=='n')) {
						continue;
					}
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
