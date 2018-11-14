package test_181114;

import java.util.Scanner;

//00으로 이루어진 타일(00을 하나의 0으로 본다)과 1로 이루어진 타일을 조합하여 만들 수 있는 이진 수열의 개수 구하기
//수열의 규칙 = 피보나치
public class B_1904 {

	public static int fibonacci(int n) {
		if(n==0) {
			return 1;
		}else if(n==1) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//조합 가능한 이진 수열 개수
		int cnt = 0;
		
		if(1<=n&&n<=1000000) {
			cnt = fibonacci(n);
			System.out.println(cnt%15746);
		}
		
	}

}
