package test_190322;

import java.util.Scanner;

//로봇 청소기와 빈방 위치, 현재 바라보는 방향이 주어질 때, 청소를 실시할 수 있는 모든 방의 갯수 구하기
public class B_14503 {

	static int n;
	static int m;
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int [][] map;
	static boolean [][] v;
	static int cnt = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=50&&m<=50) {
			map = new int[n][m];
			v = new boolean[n][m];
			
			//시작 위치 및 방향
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dir = sc.nextInt();
			
			//빈방 및 벽의 위치 입력
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			while(true) {
				//현재 위치 = 방문하지 않은 빈방
				if(!v[x][y]) {
					cnt++;
					v[x][y]=true;
				}
				boolean flag = false;
				for(int i=1;i<=4;i++) {
					int nDir = (4+dir-i)%4;
					int nx = x+move[nDir][0];
					int ny = y+move[nDir][1];
					if(nx<0||ny<0||nx>=n||nx>=m||v[nx][ny]||map[nx][ny]==1) continue;
					flag = true;
					x = nx;
					y = ny;
					dir = nDir;
					break;
				}
				//사방이 방문한 곳이거나 벽이면(후진 가능 여부 판별)
				if(!flag) {
					int nDir = (2+dir)%4;
					int nx = x+move[nDir][0];
					int ny = y+move[nDir][1];
					//후진 위치 = 벽 (프로그램 종료)
					if(map[nx][ny]==1) break;
					x = nx;
					y = ny;
				}
			}
			System.out.println(cnt);
		}
	}
}
