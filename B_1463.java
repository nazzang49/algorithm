package test_190115;

import java.util.Scanner;

//��� �ڿ��� n�� �־��� ��, �ش� �ڿ����� 1�� ����� ��Ģ ������ Ȱ�� Ƚ�� �ּҰ� ���ϱ�
public class B_1463 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10, 6)) {
			int [] dp = new int[n+1];
			for(int i=2;i<=n;i++) {
				//2�� 3�� �����
				if(i%2==0&&i%3==0) {
					dp[i]=Math.min(dp[i-1]+1, Math.min(dp[i/2]+1, dp[i/3]+1));
				}
				//2�θ� �������� ��
				else if(i%2==0) {
					dp[i]=Math.min(dp[i-1]+1, dp[i/2]+1);					
				}
				//3���θ� �������� ��
				else if(i%3==0) {
					dp[i]=Math.min(dp[i-1]+1, dp[i/3]+1);
				}
				//2�Ǵ� 3 ��������ε� �������� �ʴ� ��
				else {
					dp[i]=dp[i-1]+1;
				}
			}
			System.out.println(dp[n]);
		}
	}
}
