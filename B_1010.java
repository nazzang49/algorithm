package test_190219;

import java.util.Scanner;

//강 서쪽과 강 동쪽의 다리를 놓는 작업을 진행할 때, 최대한 많이 지을 수 있는 경우의 수 구하기
public class B_1010 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int [] ans = new int[k];
		int cnt = 0;
		
		while(cnt!=k) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n<=m&&m<=30) {
				int [][] dp = new int[n+1][m+1];
				//1개 - m개 매칭
				for(int i=1;i<=m;i++) {
					dp[1][i]=i;
				}
				//n==m(무조건 1개 경우의 수만 존재)
				for(int i=1;i<=n;i++) {
					dp[i][i]=1;
				}
				//DP 실행
				for(int i=2;i<=n;i++) {
					for(int j=3;j<=m;j++) {
						dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
					}
				}
				ans[cnt]=dp[n][m];
			}
			cnt++;
		}
		//정답 출력
		for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
	}
}
