package test_190115;

import java.util.Scanner;

//어떠한 자연수 n이 주어질 때, 해당 자연수를 1로 만드는 규칙 세가지 활용 횟수 최소값 구하기
public class B_1463 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10, 6)) {
			int [] dp = new int[n+1];
			for(int i=2;i<=n;i++) {
				//2와 3의 공배수
				if(i%2==0&&i%3==0) {
					dp[i]=Math.min(dp[i-1]+1, Math.min(dp[i/2]+1, dp[i/3]+1));
				}
				//2로만 나눠지는 수
				else if(i%2==0) {
					dp[i]=Math.min(dp[i-1]+1, dp[i/2]+1);					
				}
				//3으로만 나눠지는 수
				else if(i%3==0) {
					dp[i]=Math.min(dp[i-1]+1, dp[i/3]+1);
				}
				//2또는 3 어느것으로도 나눠지지 않는 수
				else {
					dp[i]=dp[i-1]+1;
				}
			}
			System.out.println(dp[n]);
		}
	}
}
