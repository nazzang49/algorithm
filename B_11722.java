package test_190129;

import java.util.Scanner;

//가장 긴 감소하는 부분 수열 길이 구하기
public class B_11722 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			int [] arr = new int[n+1];
			int [] dp = new int[n+1];
			//전체 수열 입력
			for(int i=1;i<=n;i++) {
				arr[i]=sc.nextInt();
			}
			//DP 실행
			for(int i=1;i<=n;i++) {
				dp[i]=1;
				for(int j=1;j<i;j++) {
					//앞에 있는 수가 현재 수보다 크고, dp 값이 증가하면(dp 값 갱신=길이 증가)
					if(arr[i]<arr[j]&&dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
					}
				}
			}
			System.out.println(dp[n]);
		}
	}
}
