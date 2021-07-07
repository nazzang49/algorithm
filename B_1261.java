package test_190216;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x,y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//(1,1)에서 (n,m) 위치로 이동하기까지 부수어야 하는 벽의 최소 갯수 구하기
public class B_1261 {

	static int n;
	static int m;
	static int [][] map;
	static int [][] dp;
	//상하좌우 이동 가능하지만, 오른쪽과 아래로만 이동한다고 간주
	static int [][] move = {{1,0},{0,1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<2;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				
				//다음 지점이 영역 밖이면
				if(nx<0||ny<0||nx>=m||ny>=n) continue;
				
				//다음 지점 = 1(벽)
				if(map[nx][ny]==1) {
					dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]+1);
					q.add(new Pos(nx, ny));
				}
				
				//다음 지점 = 0(빈방)
				if(map[nx][ny]==0) {
					dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]);
					q.add(new Pos(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100) {
			map = new int[m][n];
			dp = new int[m][n];
			
			//빈방(0), 벽(1) 정보 입력
			for(int i=0;i<m;i++) {
				String str = sc.next();
				Arrays.fill(dp[i], 10001);
				for(int j=0;j<n;j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			
			dp[0][0]=0;
			//BFS + DP 탐색 실행
			bfs(0,0);
			System.out.println(dp[m-1][n-1]);
		}	
	}
}
