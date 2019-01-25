package test_190125;

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

//현재 위치, 오두막 위치, 저격수가 숨어 있는 나무 위치, 이동 가능한 빈 공간이 주어질 때, 오두막으로 이동하는 경로 중 나무와의 최소거리가 가장 큰 경로 구하기
public class B_2917 {

	static int oduX;
	static int oduY;
	static int treeX;
	static int treeY;
	static int n;
	static int m;
	static char [][] map;
	static boolean [][] visited;
	static int [][] dp;
	//상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		dp[x][y]=Math.abs(x-treeX)+Math.abs(y-treeY);
		
		//탐색할 지점이 있으면 계속해서 실행
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				//탐색 지점 = 영역 밖
				if(nx<0||ny<0||nx>=n||ny>=m) {
					continue;
				}
				//탐색 지점 = 이동하지 않은 빈 공간
				if(!visited[nx][ny]&&map[nx][ny]=='.') {
					visited[nx][ny]=true;
					q.add(new Pos(nx, ny));
					//현 경로에서 나무와의 최소값 계속해서 유지
					dp[nx][ny]=Math.min(dp[p.x][p.y], Math.abs(nx-treeX)+Math.abs(ny-treeY));
				}
				//탐색 지점 = 오두막
				if(map[nx][ny]=='J') {
					dp[nx][ny]=Math.max(Math.min(dp[p.x][p.y], Math.abs(nx-treeX)+Math.abs(ny-treeY)), dp[nx][ny]);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		//행과 열의 크기 설정
		if(1<=n&&n<=500&&1<=m&&m<=500) {
			map = new char[n][m];
			visited = new boolean[n][m];
			dp = new int[n][m];
			
			int x = 0;
			int y = 0;
			//공간 정보 입력
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<m;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='V') {
						x=i;
						y=j;
					}else if(map[i][j]=='+') {
						treeX=i;
						treeY=j;
					}else if(map[i][j]=='J') {
						oduX=i;
						oduY=j;
					}
				}
			}
			//BFS 탐색 시작
			bfs(x,y);
			System.out.println(dp[oduX][oduY]);
		}
	}
}
