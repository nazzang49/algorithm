package test_190219;

import java.util.Scanner;

//n개의 정수로 이루어진 임의 수열이 주어질 때, 이 중 연속된 몇 개의 수를 선택하여 구할 수 있는 최대합 출력하기
public class B_1912 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			int [] dp = new int[n+1];
			int max = Integer.MIN_VALUE;
			
			//정수 입력
			for(int i=1;i<=n;i++) dp[i]=sc.nextInt();
			
			//DP 실행
			for(int i=1;i<=n;i++) {
				dp[i]=Math.max(dp[i], dp[i-1]+dp[i]);
				if(max<dp[i]) {
					max=dp[i];
				}
			}
			System.out.println(max);
		}	
	}
}
