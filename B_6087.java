package test_181204;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x, y, w;
	
	//좌표와 이동 방향 나타낼 변수 설정
	public Pos(int x, int y, int w) {
		this.x=x;
		this.y=y;
		this.w=w;
	}
}

public class B_6087 {

	static char [][] map;
	static boolean [][] visited;
	//최소로 필요한 거울 개수 저장
	static int [][] dp;
	//인접 지역 탐색
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int r;
	static int c;
	static int x_des;
	static int y_des;
	
	//남=0, 북=1, 동=2, 서=3
	public static void bfs(int x, int y, int w) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y, w));
		
		while(!q.isEmpty()) {
			Pos p =  q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				//다음 지점이 영역 밖이면
				if(nx<0||ny<0||nx>=c||ny>=r) continue;
				
				//다음 지점 = 도착 지점(이미 방문한 상태면 dp만 비교)
				if(map[nx][ny]=='C'&&visited[nx][ny]) {
					//방향 같으면(180도), 아래 절대값이 0또는 2
					if(Math.abs(move[p.w][0]-move[i][0])!=1) {
						dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]);	
					}
					//방향 다르면(90도), 절대값이 1
					else {
						dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]+1);
					}
					x_des=nx;
					y_des=ny;
				}
				//다음 지점이 방문하지 않은 곳이면(방향 테스트)
				if(!visited[nx][ny]) {
					//시작 지점 바로 다음이면
					if(p.w==4) {
						visited[nx][ny]=true;
						dp[nx][ny]=dp[p.x][p.y];
						q.add(new Pos(nx, ny, i));
						continue;
					}
					//현 위치의 방향과 다음 지점으로의 이동 방향이 같으면(거울 설치 X)
					if(p.w==i) {
						dp[nx][ny]=dp[p.x][p.y];
						visited[nx][ny]=true;
						q.add(new Pos(nx, ny, i));
					}
					//방향 다르면(거울 설치 O)
					else {
						dp[nx][ny]=dp[p.x][p.y]+1;
						visited[nx][ny]=true;
						q.add(new Pos(nx, ny, i));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100) {
			map = new char[c][r];
			visited = new boolean[c][r];
			dp = new int[c][r];
			//입력
			for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=str.charAt(j);
					//벽은 미리 방문한 것으로 간주
					if(map[i][j]=='*') {
						visited[i][j]=true;
					}
				}
			}
			//탐색
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j]=='C') {
						visited[i][j]=true;
						bfs(i,j,4);
					}
				}
			}
			//도착 지점 dp 출력
			System.out.println(dp[x_des][y_des]);
		}
	}
}
