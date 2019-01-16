package test_190116;

import java.util.Scanner;

//(합분해)0부터 n까지의 숫자 k개를 더해 그 합이 n이 되는 경우의 수 구하기
public class B_2225 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=200&&1<=k&&k<=200) {
			int [][] dp = new int[k+1][n+1];
			//1개 뽑아 n이 되는 경우의 수는 한가지
			for(int i=0;i<=n;i++) {
				dp[1][i]=1;
			}
			//k개 뽑아 0이 되는 경우의 수는 한가지
			for(int i=1;i<=k;i++) {
				dp[i][0]=1;
			}
			//DP 실행(2개 뽑는 경우부터)
			for(int i=2;i<=k;i++) {
				for(int j=1;j<=n;j++) {
					for(int m=0;m<=j;m++) {
						dp[i][j]+=dp[i-1][m];
					}
				}
			}
			System.out.println(dp[k][n]);
		}
	}
}
