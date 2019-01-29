package test_190129;

import java.util.Scanner;

//특정 수열이 주어질 때, 해당 수열 중 부분합의 최대값 구하기
public class B_1912 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			int max = Integer.MIN_VALUE;
			int [] dp = new int[n];
			//수열 입력
			for(int i=0;i<n;i++) {
				dp[i]=sc.nextInt();
			}
			//DP 실행
			for(int i=1;i<n;i++) {
				//연속된 수의 합, 현재 자신 중 더 큰 수 저장
				dp[i]=Math.max(dp[i], dp[i-1]+dp[i]);
				if(max<dp[i]) {
					max=dp[i];
				}
			}
			System.out.println(max);
		}
	}
}
