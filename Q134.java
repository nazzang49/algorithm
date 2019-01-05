package solution;

import java.util.Scanner;

//n번째 피보나치 수를 구하는 프로그램 작성하기
public class Q134 {

	//(방법 1 - 재귀함수)
	public static int fibo(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return fibo(n-2)+fibo(n-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//20까지 가능
		if(1<=n&&n<=20) {
			System.out.println(fibo(n));
			//(방법 2 - 동적 프로그래밍)
			int [] dp = new int[n+1];
			dp[0]=0;
			dp[1]=1;
			
			for(int i=2;i<=n;i++) {
				dp[i]=dp[i-2]+dp[i-1];
			}
			System.out.println(dp[n]);
		}
	}
}
