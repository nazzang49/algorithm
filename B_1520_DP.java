package test_190219;

import java.util.Scanner;

//1520번 문제 by DP+DFS
public class B_1520_DP {
	
	static int n;
	static int m;
	static int [][] map;
	static int [][] dp;
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};

	public static int dfs(int x, int y) {
		//도착 지점이면
		if(x==n-1&&y==m-1) {
			return 1;
		}
		//두번 이상 도달한 지점이면
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int nx = x+move[i][0];
			int ny = y+move[i][1];
			
			//다음 지점 = 영역 밖
			if(nx<0||ny<0||nx>=n||ny>=m) continue;
			
			//다음 지점 = 영역 내, 내리막길
			if(map[x][y]>map[nx][ny]) {
				cnt+=dfs(nx,ny);
			}
		}
		return dp[x][y]=cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=500&&m<=500) {
			map = new int[n][m];
			dp = new int[n][m];
			
			//지점 높이 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
					//초기화
					dp[i][j]=-1;
				}
			}
			//DFS 실행
			System.out.println(dfs(0,0));
		}	
	}
}
