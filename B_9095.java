package test_190129;

import java.util.Scanner;

//정수 n이 주어졌을 때, n을 1,2,3의 합으로 표현할 수 있는 경우의 수 출력하기
public class B_9095 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			//정답 배열 선언
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
