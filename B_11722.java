package test_190129;

import java.util.Scanner;

//���� �� �����ϴ� �κ� ���� ���� ���ϱ�
public class B_11722 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			int [] arr = new int[n+1];
			int [] dp = new int[n+1];
			//��ü ���� �Է�
			for(int i=1;i<=n;i++) {
				arr[i]=sc.nextInt();
			}
			//DP ����
			for(int i=1;i<=n;i++) {
				dp[i]=1;
				for(int j=1;j<i;j++) {
					//�տ� �ִ� ���� ���� ������ ũ��, dp ���� �����ϸ�(dp �� ����=���� ����)
					if(arr[i]<arr[j]&&dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
					}
				}
			}
			System.out.println(dp[n]);
		}
	}
}
