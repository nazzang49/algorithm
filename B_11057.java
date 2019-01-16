package test_190116;

import java.util.Scanner;

//���� ���� n�� �־����� ��, ������ ��(�ڸ����� �ڷ� ������ �� ���� ���� ������)�� ������ ���ϴ� ���α׷� �ۼ��ϱ�
public class B_11057 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			//2���� �迭�� ���(�� �ε��� = n�ڸ��� �ǹ� / �� �ε��� = ������ �ڸ����� 0~9�� �� �ǹ�)
			int [][] dp = new int[n+1][10];
			//���ڸ� ���� �� ������ ���� ����(1�� �ʱ�ȭ)
			for(int i=0;i<=9;i++) {
				dp[1][i]=1;
			}
			//���ڸ� ������ DP ����(n�ڸ� ���� ������ �ڸ� ���� j�� �� ���� �� �ִ� ������ ���� ����)
			for(int i=2;i<=n;i++) {
				for(int j=0;j<=9;j++) {
					for(int k=0;k<=j;k++) {
						dp[i][j]+=dp[i-1][k];
						dp[i][j]%=10007;
					}
				}
			}
			//������ �ڸ����� 0~9�� ������ ��� ��� ���Ѵ�
			long sum = 0;
			for(int i=0;i<=9;i++) {
				sum+=dp[n][i];
			}
			System.out.println(sum);
		}
	}
}
