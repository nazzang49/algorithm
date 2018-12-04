package test_181204;

import java.util.Scanner;

//����Ʈ�� ���·� �־��� �Է°��� ���� ���� ���·� ��带 Ž���ϸ� ������ �� �� �ִ밪 ���ϱ�
public class B_1932 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] dp = new int[n][n];
		dp[0][0]=sc.nextInt();
		
		if(1<=n&&n<=500) {
			for(int i=1;i<n;i++) {
				for(int j=0;j<i+1;j++) {
					int tmp = sc.nextInt();
					//���� ����(idx=0)
					if(j==0) {
						dp[i][j]=dp[i-1][j]+tmp;
					}
					//���� ������(idx=i)
					else if(i==j) {
						dp[i][j]=dp[i-1][j-1]+tmp;
					}
					//�� �� ����(�� �� ��� �α����� ���� �����ϹǷ� �ִ밪 ���)
					else {
						dp[i][j]=Math.max(dp[i-1][j-1]+tmp, dp[i-1][j]+tmp);
					}
				}
			}
			int max=0;
			//������ �ٸ� �˻�
			for(int i=0;i<dp[n-1].length;i++) {
				if(max<dp[n-1][i]) {
					max=dp[n-1][i];
				}
			}
			System.out.println(max);
		}
	}
}
