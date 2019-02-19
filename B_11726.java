package test_190219;

import java.util.Scanner;

//2xN 크기의 바닥을 1x2, 2x1 크기의 타일로 채우는 방법 구하기
public class B_11726 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			int [] dp = new int[n+1];
			dp[1]=1;
			dp[2]=2;
			for(int i=3;i<=n;i++) {
				dp[i]=(dp[i-1]+dp[i-2])%10007;
			}
			System.out.println(dp[n]);
		}
		sc.close();
	}
}
