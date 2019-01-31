package test_190131;

import java.util.Scanner;

//정육면체 모양의 상자들이 줄지어 서 있을 때, 규칙에 따라 한번에 넣을 수 있는 상자 갯수의 최대값 구하기
public class B_1965 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//상자의 최대 갯수 = 1000
		if(n<=1000) {
			int [] arr = new int[n+1];
			int [] dp = new int[n+1];
			//상자 크기 입력
			for(int i=1;i<=n;i++) {
				arr[i]=sc.nextInt();
			}
			int max = 0;
			//DP 실행
			for(int i=1;i<=n;i++) {
				//i번째 상자의 초기 상자 갯수 = 1
				dp[i]=1;
				for(int j=1;j<i;j++) {
					//앞쪽 상자 크기 < 뒤쪽 상자 크기
					if(arr[i]>arr[j]&&dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
						if(max<dp[i]) {
							max=dp[i];
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
