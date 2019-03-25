package test_190325;

import java.util.Scanner;

//비숍을 놓을 수 있는 위치가 주어질 때, 서로 잡아 먹히지 않는 규칙을 만족하는 비숍의 최대 갯수 구하기(흑색칸 탐색 + 백색칸 탐색)
public class B_1799 {

	static int n;
	//체스판 현재 상황
	static int [][] map;
	static int blackCnt = 0;
	static int whiteCnt = 0;
	//좌상, 우상, 좌하, 우하
	static int [] dx = {-1, -1, 1, 1};
	static int [] dy = {-1, 1, -1, 1};
	
	//현재 위치에 비숍 놓을 수 있는지 판별하는 메소드
	public static boolean isAble(boolean [][] v, int x, int y) {
		//비숍을 놓을 수 없는 자리이면 false 반환
		if(map[x][y]==0) return false;
		//대각선 모든 위치 탐색
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			for(int j=0;j<n;j++) {
				//체스판 범위 내
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					//이미 비숍이 놓아진 대각선이면 false 반환
					if(v[nx][ny]) return false;
					nx = nx+dx[i];
					ny = ny+dy[i];
				}
			}
		}
		return true;
	}
	
	//흑색칸 탐색
	public static void black(boolean [][] v, int x, int y, int cnt) {
		blackCnt = Math.max(blackCnt, cnt);
		
		//현재 행의 모든 열 탐색 끝 = 다음 행으로 이동(행이 바뀔 때 마다 지그재그로 흑색 칸 위치 변경)
		if(y>=n) {
			x++;
			y=x%2==0?0:1;
		}
		
		if(x>=n) return;
		
		//비숍 놓을 수 있는 곳이면
		if(isAble(v,x,y)) {
			v[x][y]=true;
			//2칸 이동 = 바로 옆 칸은 다른 색이므로
			black(v,x,y+2,cnt+1);
			v[x][y]=false;
		}
		
		//놓을 수 있지만 놓지 않는 경우
		black(v,x,y+2,cnt);
	}
	
	//백색칸 탐색
	public static void white(boolean [][] v, int x, int y, int cnt) {
		whiteCnt = Math.max(whiteCnt, cnt);
		
		//현재 행의 모든 열 탐색 끝 = 다음 행으로 이동(행이 바뀔 때 마다 지그재그로 흑색 칸 위치 변경)
		if(y>=n) {
			x++;
			y=x%2==0?1:0;
		}
		
		if(x>=n) return;
		
		//비숍 놓을 수 있는 곳이면
		if(isAble(v,x,y)) {
			v[x][y]=true;
			//2칸 이동 = 바로 옆 칸은 다른 색이므로
			white(v,x,y+2,cnt+1);
			v[x][y]=false;
		}
		
		//놓을 수 있지만 놓지 않는 경우
		white(v,x,y+2,cnt);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=10) {
			map = new int[n][n];
			//체스판 상황 입력(1=가능 / 0=불가능)
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//흑색 칸 = 짝수 / 백색 칸 = 홀수
			boolean [][] blackVisit = new boolean[n][n];
			black(blackVisit,0,0,0);
			boolean [][] whiteVisit = new boolean[n][n];
			white(whiteVisit,0,1,0);
			//정답 출력
			System.out.println(blackCnt+whiteCnt);
		}
	}
}
