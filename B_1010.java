package test_190219;

import java.util.Scanner;

//�� ���ʰ� �� ������ �ٸ��� ���� �۾��� ������ ��, �ִ��� ���� ���� �� �ִ� ����� �� ���ϱ�
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
				//1�� - m�� ��Ī
				for(int i=1;i<=m;i++) {
					dp[1][i]=i;
				}
				//n==m(������ 1�� ����� ���� ����)
				for(int i=1;i<=n;i++) {
					dp[i][i]=1;
				}
				//DP ����
				for(int i=2;i<=n;i++) {
					for(int j=3;j<=m;j++) {
						dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
					}
				}
				ans[cnt]=dp[n][m];
			}
			cnt++;
		}
		//���� ���
		for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
	}
}
