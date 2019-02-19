package test_190219;

import java.util.Scanner;

//n���� ������ �̷���� ���� ������ �־��� ��, �� �� ���ӵ� �� ���� ���� �����Ͽ� ���� �� �ִ� �ִ��� ����ϱ�
public class B_1912 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			int [] dp = new int[n+1];
			int max = Integer.MIN_VALUE;
			
			//���� �Է�
			for(int i=1;i<=n;i++) dp[i]=sc.nextInt();
			
			//DP ����
			for(int i=1;i<=n;i++) {
				dp[i]=Math.max(dp[i], dp[i-1]+dp[i]);
				if(max<dp[i]) {
					max=dp[i];
				}
			}
			System.out.println(max);
		}	
	}
}
