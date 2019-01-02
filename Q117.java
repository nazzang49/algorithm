package solution;

import java.util.Scanner;

//�ҸӴϰ� ȣ���̷κ��� �����ϰ� �Ѿ�� �� n, �� �� ȣ���̿��� �ǳ��� ���� ���� k�� �־��� �� ù°���� ��°���� �ǳ� ���� ���� ���ϱ�
public class Q117 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(3<=n&&n<=30&&1<=k&&k<=100000) {
			int [] dp = new int[n+1];
			dp[0]=0;
			
			//dp[n]=k�� �Ǵ� ���� �ùٸ� �Ǻ���ġ ���� �ϼ�
			while(dp[n]!=k) {
				if(dp[n]<k) {
					dp[2]++;
				}else if(dp[n]>k) {
					dp[1]++;
					dp[2]=dp[1];
				}
				
				for(int i=3;i<=n;i++) {
					dp[i]=dp[i-2]+dp[i-1];
				}
			}
			System.out.println(dp[1]);
			System.out.println(dp[2]);
		}
	}
}
