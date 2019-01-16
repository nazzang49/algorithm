package test_190116;

import java.util.Scanner;

//ī���� Pn(n���� ����ִ� ī����)�� ����� �־��� �� ���� ���� Ȯ���� ī�带 ���� �� �����ؾ� �ϴ� ����� �ִ� ���ϱ�
public class B_11052 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�����ϰ��� �ϴ� ī���� ����
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			int [] p = new int[n+1];
			int [] dp = new int[n+1];
			//ī���Ѻ� ��� �Է�
			for(int i=1;i<=n;i++) {
				p[i]=sc.nextInt();
			}
			//DP ����
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=i;j++) {
					dp[i]=Math.max(dp[i], dp[i-j]+p[j]);
				}
			}
			System.out.println(dp[n]);
		}
	}
}
