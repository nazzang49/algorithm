package test_190116;

import java.util.Scanner;

//(�պ���)0���� n������ ���� k���� ���� �� ���� n�� �Ǵ� ����� �� ���ϱ�
public class B_2225 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=200&&1<=k&&k<=200) {
			int [][] dp = new int[k+1][n+1];
			//1�� �̾� n�� �Ǵ� ����� ���� �Ѱ���
			for(int i=0;i<=n;i++) {
				dp[1][i]=1;
			}
			//k�� �̾� 0�� �Ǵ� ����� ���� �Ѱ���
			for(int i=1;i<=k;i++) {
				dp[i][0]=1;
			}
			//DP ����(2�� �̴� ������)
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
