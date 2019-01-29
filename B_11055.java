package test_190129;

import java.util.Scanner;

//Ư�� ������ ���� �κ� ���� �� �� ���� �ִ� ���ϱ�
public class B_11055 {

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
			int max = Integer.MIN_VALUE;
			//DP ����
			for(int i=1;i<=n;i++) {
				dp[i]=arr[i];
				for(int j=1;j<i;j++) {
					//�տ� �ִ� ���� ���� ������ �۰�, �� ���� �� Ŀ����(dp �� ����)
					if(arr[j]<arr[i]) {
						dp[i]+=arr[j];
					}
				}
				if(max<dp[i]) {
					max=dp[i];
				}
			}
			System.out.println(max);
		}
	}
}
