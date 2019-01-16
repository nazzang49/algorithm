package test_190116;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x, y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//준규가 nxm 미로에 갇혀있고, 각 방에는 사탕이 놓여져 있을 때 1행 1열에서 n행 m열로 이동하는 과정에서 얻게되는 사탕 개수의 최대값 구하기
public class B_11048 {

	static int n;
	static int m;
	static int [][] dp;
	static int [][] map;
	//세가지 방식으로 다음 지점 이동 가능
	static int [][] move= {{1,0},{0,1},{1,1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<3;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				
				//탐색 가능 범위를 벗어나는 경우
				if(nx<0||ny<0||nx>=n||ny>=m) {
					continue;
				}
				//현재 저장된 값 vs 이전 위치까지의 누적값 + 현재 위치에서 얻을 수 있는 사탕 갯수
				dp[nx][ny]=Math.max(dp[nx][ny], dp[p.x][p.y]+map[nx][ny]);
				q.add(new Pos(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=m&&m<=1000) {
			map = new int[n][m];
			//얻을 수 있는 사탕의 최대 개수 비교해서 저장할 배열
			dp = new int[n][m];
			//각 방에 놓여있는 사탕 개수 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//BFS 탐색 실시
			dp[0][0]=map[0][0];
			bfs(0,0);
			System.out.println(dp[n-1][m-1]);
		}
	}
}
