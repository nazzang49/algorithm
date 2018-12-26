package solution;

import java.util.Scanner;

//�Ľ�Į �ﰢ������ n��° ���� k��° ��ġ�� �ִ� �� ����ϱ�
public class Q92 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=k&&k<=n&&n<=30) {
			int [][] dp = new int[n][n];
			dp[0][0]=1;
			dp[1][0]=1;
			dp[1][1]=1;
			for(int i=0;i<dp.length;i++) {
				for(int j=0;j<=i;j++) {
					//j�� 0�̰ų�, i�� ������
					if(j==0||i==j) {
						dp[i][j]=1;
					}else {
						dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
					}
				}
			}
			System.out.println(dp[n-1][k-1]);
		}
	}
}
