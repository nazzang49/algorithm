package test_190129;

import java.util.Scanner;

//Ư�� ������ �־��� ��, �ش� ���� �� �κ����� �ִ밪 ���ϱ�
public class B_1912 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			int max = Integer.MIN_VALUE;
			int [] dp = new int[n];
			//���� �Է�
			for(int i=0;i<n;i++) {
				dp[i]=sc.nextInt();
			}
			//DP ����
			for(int i=1;i<n;i++) {
				//���ӵ� ���� ��, ���� �ڽ� �� �� ū �� ����
				dp[i]=Math.max(dp[i], dp[i-1]+dp[i]);
				if(max<dp[i]) {
					max=dp[i];
				}
			}
			System.out.println(max);
		}
	}
}
