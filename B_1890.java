package test_190201;

import java.util.Scanner;

//nxn ũ���� �������� �� ĭ�� ������ �Ǵ� �Ʒ��� �̵��� �� �ִ� ĭ�� ���� �������� ��, ������������ �̵��� �� �ִ� ��� ����� �� ����ϱ�
public class B_1890 {

	static int n;
	static int [][] map;
	static long [][] dp;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=100) {
			//�̵��� �� �ִ� ĭ �� �Է�
			map = new int[n+1][n+1];
			dp = new long[n+1][n+1];
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//���� ����
			dp[1][1]=1;
			//DP ����
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(dp[i][j]==0||(i==n&&j==n)) continue;
					//Ư�� ������ ������ ��� ������ ���� ��� ����� �� +1
					if(i+map[i][j]<=n) dp[i+map[i][j]][j]+=dp[i][j];
					if(j+map[i][j]<=n) dp[i][j+map[i][j]]+=dp[i][j];
				}
			}
			System.out.println(dp[n][n]);
		}
	}
}
