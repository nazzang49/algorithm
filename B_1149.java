package test_190116;

import java.util.Scanner;

//ĥ�ؾ� �ϴ� ���� ���� n, ����, �Ķ�, �ʷ� ����Ʈĥ ����� �־��� �� ��� ���� ĥ�ϴ� ����� �ּڰ� ���ϱ�
public class B_1149 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			//2���� �迭�� ���� ��� �Է�
			int [][] dp = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dp[i][j]=sc.nextInt();
				}
			}
			//DP ����(1����� Ž�� ����)
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
