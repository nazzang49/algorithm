package test_190111;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class B_1987 {

	static int r;
	static int c;
	//규칙에 맞춰 최대 이동할 수 있는 칸수
	static int cnt = 1;
	static char [][] map;
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	//알파벳 등장 여부 저장할 배열
	static int [] alpha = new int[26];
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		alpha[map[x][y]-'A']++;

		//탐색할 위치가 있으면 계속해서 실행
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				//탐색 지점이 범위를 벗어나면
				if(nx<0||ny<0||nx>=r||ny>=c) {
					continue;
				}
				//아직 방문하지 않았고, 처음 등장한 알파벳이면(이동 가능)
				if(alpha[map[nx][ny]-'A']==0&&!visited[nx][ny]) {
					alpha[map[nx][ny]-'A']++;
					visited[nx][ny]=true;
					cnt++;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		if(1<=r&&r<=20&&1<=c&&c<=20) {
			map = new char[r][c];
			visited = new boolean[r][c];
			//알파벳 입력
			for(int i=0;i<r;i++) {
				String str = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			//탐색 실행(0행 0열에서부터 탐색 시작)
			bfs(0,0);
			System.out.println(cnt);
		}
	}
}
