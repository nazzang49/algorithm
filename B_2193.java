package test_190129;

import java.util.Scanner;

//이진수로 변환 시, 0으로 시작하지 않고, 1이 두번 연속해서 등장하지 않는 n자리 이친수의 갯수 구하기
public class B_2193 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=90) {
			int [] dp = new int[n+1];
			dp[1]=1;
			dp[2]=1;
			dp[3]=2;
			for(int i=4;i<=n;i++) {
				dp[i]=dp[i-2]+dp[i-1];
			}
			System.out.println(dp[n]);
		}
	}
}
