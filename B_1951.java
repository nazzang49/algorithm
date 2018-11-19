package test_181119;

import java.util.Scanner;

//1부터 입력된 자연수까지의 수를 활자로 표현할 때, 필요한 활자의 개수 구하기
public class B_1951 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//필요한 활자 개수
		int cnt = 0;
		
		if(1<=n&&n<=2000000000) {
			for(int i=1;i<=n;i++) {
				String str = String.valueOf(i);
				for(int j=0;j<str.length();j++) {
					cnt++;
				}
			}
			System.out.println(cnt%1234567);
		}
	}
}
