package test_190129;

import java.util.Scanner;

//연속된 세개의 계단을 밟을 수 없고, 마지막 계단을 반드시 밟아야 할 때 계단에 주어진 수들을 모두 더한 결과의 최댓값 구하기
public class B_2579 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=300) {
			int [] arr = new int[n+1];
			int [] dp = new int[n+1];
			//각 계단에 주어지는 점수 입력
			for(int i=1;i<=n;i++) {
				arr[i]=sc.nextInt();
			}
			dp[1]=arr[1];
			dp[2]=arr[1]+arr[2];
			//탐색 실행
			for(int i=3;i<=n;i++) {
				//i번째 계단을 밟을 수 있는 경우는 두가지
				dp[i]=Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
			}
			System.out.println(dp[n]);
		}
	}
}
