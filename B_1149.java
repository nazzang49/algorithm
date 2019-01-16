package test_190116;

import java.util.Scanner;

//칠해야 하는 집의 개수 n, 빨강, 파랑, 초록 페인트칠 비용이 주어질 때 모든 집을 칠하는 비용의 최솟값 구하기
public class B_1149 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			//2차원 배열로 색깔별 비용 입력
			int [][] dp = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dp[i][j]=sc.nextInt();
				}
			}
			//DP 실행(1행부터 탐색 시작)
			for(int i=1;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(j==0) {
						dp[i][j]=Math.min(dp[i-1][1], dp[i-1][2])+dp[i][j];
					}else if(j==1) {
						dp[i][j]=Math.min(dp[i-1][0], dp[i-1][2])+dp[i][j];
					}else {
						dp[i][j]=Math.min(dp[i-1][0], dp[i-1][1])+dp[i][j];
					}
				}
			}
			System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
		}
	}
}
