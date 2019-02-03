package test_190203;

import java.util.Scanner;

//특정 자연수 n을 그보다 작거나 같은 제곱수들의 합으로 표현할 때, 사용하는 항의 갯수 최소값 구하기
public class B_1699 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			//DP 실행
			int [] dp = new int[n+1];
			for(int i=1;i<=n;i++) {
				//먼저 모든 경우에 대해 최대 항의 갯수 저장(1의 제곱의 합만으로 표현되는 경우)
				dp[i]=i;
				for(int j=1;j*j<=i;j++) {
					if(dp[i]>dp[i-(j*j)]+1) dp[i]=dp[i-(j*j)]+1;
				}
			}
			System.out.println(dp[n]);
		}
	}
}
