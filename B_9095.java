package test_190129;

import java.util.Scanner;

//���� n�� �־����� ��, n�� 1,2,3�� ������ ǥ���� �� �ִ� ����� �� ����ϱ�
public class B_9095 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			//���� �迭 ����
			int [] ans = new int[t];
			int k = 0;
			while(k<t) {
				int n = sc.nextInt();
				if(n<=11) {
					int [] dp = new int[n+1];
					dp[1]=1;
					dp[2]=2;
					dp[3]=4;
					for(int i=4;i<=n;i++) {
						dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
					}
					ans[k]=dp[n];
				}
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
