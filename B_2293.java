package test_190116;

import java.util.Arrays;
import java.util.Scanner;

//n���� ������ ������ ���� ��, �� ���� �̿��Ͽ� k�� ���� �� ���� �� �ִ� ����� �� ���ϱ�
public class B_2293 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=100&&1<=k&&k<=100) {
			int [] dp = new int[k+1];
			int first = 0;
			//������ ��ġ �Է�
			for(int i=1;i<=n;i++) {
				int tmp = sc.nextInt();
				if(i==1) {
					first=tmp;
				}
				dp[tmp]=1;
			}
			//DP Ž��
			for(int i=first+1;i<=k;i++) {
				dp[i]=dp[first]+dp[i-first];
			}
			System.out.println(dp[k]);
		}
	}
}
