package test_190207;

import java.util.Scanner;

//판다가 NxN 형태의 대나무 숲을 이동할 때, 규칙에 따라 생존할 수 있는 최대일수 구하기(DFS+DP)
public class B_1937 {

	static int n;
	//상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	//최장 생존일 저장할 배열
	static int [][] dp;
	//대나무 숲 정보
	static int [][] map;
	
	public static int dfs(int x, int y) {
		//이미 방문한 곳이면
		if(dp[x][y]>0) return dp[x][y];
		
		dp[x][y]=1;
		for(int i=0;i<4;i++) {
			int nx = x+move[i][0];
			int ny = y+move[i][1];
			
			//다음 지점 = 영역 밖
			if(nx<0||ny<0||nx>=n||ny>=n) {
				continue;
			}
			//다음 지점 = 대나무 높이 커질 때(이동)
			if(map[x][y]<map[nx][ny]) {
				//현재 지점 = 경로의 마지막 지점으로 간주(max 결과가 1이라면, 현재 지점이 새로운 시작점이 된다는 의미)
				dp[x][y]=Math.max(dp[x][y], dfs(nx,ny)+1);
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=500) {
			map = new int[n][n];
			dp = new int[n][n];

			//대나무 숲 정보 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			//탐색 실행
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//모든 지점마다 최장 생존일 갱신
					max=Math.max(max, dfs(i,j));
				}
			}
			System.out.println(max);
		}else {
			System.out.println("입력 조건을 확인해주세요.");
			System.exit(0);
		}
	}
}
