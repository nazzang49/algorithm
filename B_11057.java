package test_190116;

import java.util.Scanner;

//수의 길이 n이 주어졌을 때, 오르막 수(자릿수가 뒤로 갈수록 더 높은 수가 나오는)의 개수를 구하는 프로그램 작성하기
public class B_11057 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			//2차원 배열로 계산(행 인덱스 = n자리수 의미 / 열 인덱스 = 마지막 자릿수가 0~9일 때 의미)
			int [][] dp = new int[n+1][10];
			//한자리 숫자 중 오르막 수의 갯수(1로 초기화)
			for(int i=0;i<=9;i++) {
				dp[1][i]=1;
			}
			//두자리 수부터 DP 진행(n자리 수의 마지막 자리 수가 j일 때 얻을 수 있는 오르막 수의 갯수)
			for(int i=2;i<=n;i++) {
				for(int j=0;j<=9;j++) {
					for(int k=0;k<=j;k++) {
						dp[i][j]+=dp[i-1][k];
						dp[i][j]%=10007;
					}
				}
			}
			//마지막 자리수가 0~9인 각각의 경우 모두 더한다
			long sum = 0;
			for(int i=0;i<=9;i++) {
				sum+=dp[n][i];
			}
			System.out.println(sum);
		}
	}
}
