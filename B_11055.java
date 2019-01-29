package test_190129;

import java.util.Scanner;

//특정 수열의 증가 부분 수열 중 그 합의 최댓값 구하기
public class B_11055 {

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
			int max = Integer.MIN_VALUE;
			//DP 실행
			for(int i=1;i<=n;i++) {
				dp[i]=arr[i];
				for(int j=1;j<i;j++) {
					//앞에 있는 수가 현재 수보다 작고, 그 합이 더 커지면(dp 값 갱신)
					if(arr[j]<arr[i]) {
						dp[i]+=arr[j];
					}
				}
				if(max<dp[i]) {
					max=dp[i];
				}
			}
			System.out.println(max);
		}
	}
}
