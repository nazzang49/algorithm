package test_190325;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	
	int x, y, cnt;
	
	public Pos(int x, int y, int cnt) {
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}

//NxM 크기의 미로가 입력으로 주어질 때, 출발부터 도착지까지 반드시 거쳐야 하는 칸의 수 최소값 구하기
public class B_2178 {

	static int n;
	static int m;
	static int [][] map;
	static boolean [][] v;
	//상하좌우 이동 가능
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	
	public static void bfs(int x, int y, int cnt) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y, cnt));
	
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			//도착점이면(가장 빨리 도착하는 경우)
			if(p.x==n-1&&p.y==m-1) {
				System.out.println(p.cnt);
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				//다음 지점 = 영역 밖
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				//다음 지점 = 이동 가능 and 미방문
				if(map[nx][ny]==1&&!v[nx][ny]) {
					v[nx][ny]=true;
					q.add(new Pos(nx, ny, p.cnt+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100) {
			map = new int[n][m];
			v = new boolean[n][m];
			
			//지도 입력
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<str.length();j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			
			//BFS 탐색
			bfs(0,0,1);
		}	
	}
}
