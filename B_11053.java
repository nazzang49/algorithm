package test_190129;

import java.util.Scanner;

//특정 수열의 부분 집합 중 길이가 가장 긴 부분 증가 수열의 길이 구하기
public class B_11053 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			int [] arr = new int[n+1];
			int [] dp = new int[n+1];
			//수열 입력
			for(int i=1;i<=n;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=1;i<=n;i++) {
				dp[i]=1;
				for(int j=1;j<i;j++) {
					//앞쪽에 위치한 수가 현재 수보다 작고, dp 값이 더 크면(dp 값 갱신)
					if(arr[j]<arr[i]&&dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
					}
				}
			}
			System.out.println(dp[n]);
		}
	}
}
