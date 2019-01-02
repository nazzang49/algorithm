package solution;

import java.util.Scanner;

//할머니가 호랑이로부터 무사하게 넘어온 날 n, 그 날 호랑이에게 건네준 떡의 개수 k가 주어질 때 첫째날과 둘째날에 건넨 떡의 개수 구하기
public class Q117 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(3<=n&&n<=30&&1<=k&&k<=100000) {
			int [] dp = new int[n+1];
			dp[0]=0;
			
			//dp[n]=k가 되는 순간 올바른 피보나치 수열 완성
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
