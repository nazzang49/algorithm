package test_181103;

import java.util.Scanner;

//시음 가능한 탄산음료의 개수 구하기
public class B_5032 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int f = sc.nextInt();
		int c = sc.nextInt();
		int cnt = 0;
		
		if(0<=f&&f<1000&&0<=e&&e<1000&&1<c&&c<2000) {
			cnt+=(e+f)/c;
			cnt+=cnt/c;
			System.out.println(cnt);
		}
		
	}

}
