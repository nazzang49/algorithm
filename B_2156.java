package test_190131;

import java.util.Scanner;

//시음할 수 있는 와인 n개가 놓여있고, 연속해서 3잔의 와인을 마실 수 없을 때 와인을 마실 수 있는 최대값 구하기
public class B_2156 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=10000) {
			int [] wine = new int[n+1];
			int [] dp = new int[n+1];
			//와인 용량 입력
			for(int i=1;i<=n;i++) {
				wine[i]=sc.nextInt();
			}
			dp[1]=wine[1];
			dp[2]=wine[1]+wine[2];
			//DP 실행
			//총 세가지 케이스 가능
			//OOX, OXO, XOO
			for(int i=3;i<=n;i++) {
				dp[i]=Math.max(dp[i-3]+wine[i-1]+wine[i], Math.max(dp[i-2]+wine[i], dp[i-1]));
			}
			System.out.println(dp[n]);
		}
	}
}
