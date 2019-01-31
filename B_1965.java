package test_190131;

import java.util.Scanner;

//������ü ����� ���ڵ��� ������ �� ���� ��, ��Ģ�� ���� �ѹ��� ���� �� �ִ� ���� ������ �ִ밪 ���ϱ�
public class B_1965 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//������ �ִ� ���� = 1000
		if(n<=1000) {
			int [] arr = new int[n+1];
			int [] dp = new int[n+1];
			//���� ũ�� �Է�
			for(int i=1;i<=n;i++) {
				arr[i]=sc.nextInt();
			}
			int max = 0;
			//DP ����
			for(int i=1;i<=n;i++) {
				//i��° ������ �ʱ� ���� ���� = 1
				dp[i]=1;
				for(int j=1;j<i;j++) {
					//���� ���� ũ�� < ���� ���� ũ��
					if(arr[i]>arr[j]&&dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
						if(max<dp[i]) {
							max=dp[i];
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
