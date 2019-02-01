package test_190201;

import java.util.Scanner;

//���η� ��ĭ, ���η� nĭ�� ������ �츮�� ���� �� ��Ģ�� �°�(���� Ȥ�� ���η� �پ��ְ� �� �� ����) ���ڸ� ��ġ�ϴ� ��� ����� �� ����ϱ�
public class B_1309 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			//�ִ� n���� ��ġ ����(���� ���� ���·� ��ġ ����)
			int [][] dp = new int[n+1][3];
			
			//������ ���� ��� �� ���(0)
			dp[1][0]=1;
			//���ʸ� �� ���(1)
			dp[1][1]=1;
			//�����ʸ� �� ���(2)
			dp[1][2]=1;
			
			for(int i=2;i<=n;i++) {
				dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
				dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
				dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
			}
			System.out.println(dp[n][0]+dp[n][1]+dp[n][2]);
		}
	}
}
