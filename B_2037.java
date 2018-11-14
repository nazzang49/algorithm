package test_181106;

import java.util.Scanner;

//특정 문자 메시지를 작성하는데 걸리는 시간 구하기
public class B_2037 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int w = sc.nextInt();
		int seconds = 2;
		
		if(1<=p&&p<=1000&&1<=w&&w<=1000) {
			String tmp = sc.next();
			if(tmp.length()<1000) {
				for(int i=1;i<tmp.length();i++) {
					//현재 문자 = 직전 문자인 경우
					if(tmp.charAt(i-1)==tmp.charAt(i)-1) {
						seconds+=10;
					}
				}
			}
		}
	}
}
