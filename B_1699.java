package test_190203;

import java.util.Scanner;

//Ư�� �ڿ��� n�� �׺��� �۰ų� ���� ���������� ������ ǥ���� ��, ����ϴ� ���� ���� �ּҰ� ���ϱ�
public class B_1699 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			//DP ����
			int [] dp = new int[n+1];
			for(int i=1;i<=n;i++) {
				//���� ��� ��쿡 ���� �ִ� ���� ���� ����(1�� ������ �ո����� ǥ���Ǵ� ���)
				dp[i]=i;
				for(int j=1;j*j<=i;j++) {
					if(dp[i]>dp[i-(j*j)]+1) dp[i]=dp[i-(j*j)]+1;
				}
			}
			System.out.println(dp[n]);
		}
	}
}
