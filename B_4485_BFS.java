package test_190216;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int x,y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//젤다가 (0,0)에서 (n-1, n-1)로 이동하는데 획득하게 되는 도독루피의 수를 최소로 하기 위한 프로그램 작성하기
public class B_4485_BFS {

	static int n;
	static int [][] map;
	static int [][] dp;
	static int [][] move = {{1,0},{0,1}};
	
	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			for(int i=0;i<2;i++) {
				int nx = l.x+move[i][0];
				int ny = l.y+move[i][1];
				
				//다음 지점 = 영역 밖
				if(nx>=n||ny>=n) continue;
				
				//다음 지점 = 영역 내(최소값 갱신 "현재 최소값과 이전 좌표까지의 최소값 + 다음 좌표 도둑루피 값 비교")
				dp[nx][ny]=Math.min(dp[nx][ny], dp[l.x][l.y]+map[nx][ny]);
				q.add(new Loc(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=125) {
			dp = new int[n][n];
			map = new int[n][n];
			
			//각 좌표별 도둑루피 크기 입력
			for(int i=0;i<n;i++) {
				Arrays.fill(dp[i], 100001);
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//BFS + DP 탐색 실행
			dp[0][0]=map[0][0];
			bfs(0,0);
			System.out.println(dp[n-1][n-1]);
		}
	}
}
