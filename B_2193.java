package test_190129;

import java.util.Scanner;

//�������� ��ȯ ��, 0���� �������� �ʰ�, 1�� �ι� �����ؼ� �������� �ʴ� n�ڸ� ��ģ���� ���� ���ϱ�
public class B_2193 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=90) {
			int [] dp = new int[n+1];
			dp[1]=1;
			dp[2]=1;
			dp[3]=2;
			for(int i=4;i<=n;i++) {
				dp[i]=dp[i-2]+dp[i-1];
			}
			System.out.println(dp[n]);
		}
	}
}
