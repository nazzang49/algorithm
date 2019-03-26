package test_190325;

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

//바이러스와 빈칸, 벽의 위치가 주어질 때, 벽 3개를 세워 만들 수 있는 안전 영역의 최대 칸 수 구하기(백트래킹 + BFS)
public class B_14502 {

	static int n;
	static int m;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int [][] map;
	static int [][] copy;
	static int finalCnt = 0;
	
	public static void cloneMap() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j]=map[i][j];
			}
		}
	}
	
	//세워진 벽의 갯수에 따라 탐색 실행
	public static void bfs(int num) {
		if(num==3) {
			int cnt = 0;
			cloneMap();
			Queue<Loc> q = new LinkedList<>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					//바이러스면
					if(copy[i][j]==2) {
						q.add(new Loc(i, j));
					}
				}
			}
			while(!q.isEmpty()) {
				Loc l = q.poll();
				
				for(int i=0;i<4;i++) {
					int nx = l.x+dx[i];
					int ny = l.y+dy[i];
					
					//다음 지점 = 영역 밖
					if(nx<0||ny<0||nx>=n||ny>=m) continue;
					
					//다음 지점 = 빈칸 and 미방문
					if(copy[nx][ny]==0) {
						//바이러스 감염
						copy[nx][ny]=2;
						q.add(new Loc(nx, ny));
					}
				}
			}
			//안전 영역 조사
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(copy[i][j]==0) cnt++;
				}
			}
			finalCnt = Math.max(finalCnt, cnt);
			return;
		}
		//탐색
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//벽이면
				if(map[i][j]==0) {
					map[i][j]=1;
					bfs(num+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=8&&m<=8) {
			map = new int[n][m];
			copy = new int[n][m];
			//현재 상황 지도 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=copy[i][j]=sc.nextInt();
				}
			}
			//탐색
			bfs(0);
			System.out.println(finalCnt);
		}	
	}
}
