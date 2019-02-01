package test_190201;

import java.util.Scanner;

//nxn 크기의 게임판의 각 칸에 오른쪽 또는 아래로 이동할 수 있는 칸의 수가 적혀있을 때, 도착지점까지 이동할 수 있는 모든 경로의 수 출력하기
public class B_1890 {

	static int n;
	static int [][] map;
	static long [][] dp;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=100) {
			//이동할 수 있는 칸 수 입력
			map = new int[n+1][n+1];
			dp = new long[n+1][n+1];
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//시작 지점
			dp[1][1]=1;
			//DP 실행
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(dp[i][j]==0||(i==n&&j==n)) continue;
					//특정 지점을 지나는 경로 갯수에 현재 경로 경우의 수 +1
					if(i+map[i][j]<=n) dp[i+map[i][j]][j]+=dp[i][j];
					if(j+map[i][j]<=n) dp[i][j+map[i][j]]+=dp[i][j];
				}
			}
			System.out.println(dp[n][n]);
		}
	}
}
