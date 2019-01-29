package test_190129;

import java.util.Scanner;

//Ư�� ������ �κ� ���� �� ���̰� ���� �� �κ� ���� ������ ���� ���ϱ�
public class B_11053 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			int [] arr = new int[n+1];
			int [] dp = new int[n+1];
			//���� �Է�
			for(int i=1;i<=n;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=1;i<=n;i++) {
				dp[i]=1;
				for(int j=1;j<i;j++) {
					//���ʿ� ��ġ�� ���� ���� ������ �۰�, dp ���� �� ũ��(dp �� ����)
					if(arr[j]<arr[i]&&dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
					}
				}
			}
			System.out.println(dp[n]);
		}
	}
}
