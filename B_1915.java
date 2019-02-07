package test_190207;

import java.util.Scanner;

//NxM 행렬 중 1로만 이루어진 가장 큰 정사각형의 넓이 구하기
public class B_1915 {

	static int n;
	static int m;
	static int [][] map;
	static int [][] dp;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=m&&m<=1000) {
			map = new int[n+1][m+1];
			dp = new int[n+1][m+1];
			
			//숫자 입력
			for(int i=1;i<=n;i++) {
				String str = sc.next();
				for(int j=1;j<=m;j++) {
					map[i][j]=str.charAt(j-1)-'0';
					if(map[i][j]==1) dp[i][j]=1;
				}
			}
			
			//가장 긴 변의 길이 갱신
			int max = Integer.MIN_VALUE;
			
			//탐색 실행
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					if(map[i][j]==1) {
						//위쪽, 왼쪽, 대각선 위쪽 중 가장 작은 값 + 1
						dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[j-1][i]))+1;
						if(max<dp[i][j]) {
							max = dp[i][j];
						}
					}
				}
			}
			System.out.println(max*max);
		}else {
			System.out.println("입력 조건을 확인해주세요.");
			System.exit(0);
		}
	}
}
