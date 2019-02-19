package test_190219;

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

//각 지점의 높이가 적힌 지도가 주어질 때, 출발 -> 도착으로 가는 경로 중 내리막길만 골라 도착할 수 있는 경우의 수 구하기
public class B_1520 {

	static int n;
	static int m;
	static int [][] map;
	//상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int cnt = 0;
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.x==n-1&&p.y==m-1) {
				cnt++;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				
				//다음 지점 = 영역 밖
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				//다음 지점 = 내리막길
				if(map[nx][ny]<map[p.x][p.y]) {
					q.add(new Pos(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=500&&m<=500) {
			map = new int[n][m];
			
			//지점 높이 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//BFS 탐색 실행
			bfs(0,0);
			System.out.println(cnt);
		}	
	}
}
