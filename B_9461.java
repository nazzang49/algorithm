package test_190129;

import java.util.Scanner;

//파도반 수열에서 n번째 숫자 출력하기
public class B_9461 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			int [] ans = new int[t];
			int k = 0;
			while(k<t) {
				int n = sc.nextInt();
				int [] dp = new int[n+1];
				dp[1]=1;
				dp[2]=1;
				dp[3]=1;
				for(int i=4;i<=n;i++) {
					dp[i]=dp[i-3]+dp[i-2];
				}
				ans[k]=dp[n];
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
