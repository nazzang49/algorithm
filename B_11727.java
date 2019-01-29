package test_190129;

import java.util.Scanner;

//2xN 의 직사각형을 2x1과 2x2의 타일로 채우는 모든 경우의 수 구하기
public class B_11727 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			int [] dp = new int[n+1];
			dp[1]=1;
			dp[2]=3;
			for(int i=3;i<=n;i++) {
				dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
			}
			System.out.println(dp[n]);
		}
	}
}
