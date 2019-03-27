package test_190327;

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

//NxN 크기의 게임 보드판 위에서 규칙에 따라 뱀의 길이가 길어질 때, 게임이 종료되는 시간 출력하기
public class B_3190 {

	static int [][] map;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int n;
	static char [] chDir;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		chDir = new char[101];
		int k = sc.nextInt();
		//사과 위치 입력
		for(int i=0;i<k;i++) {
			map[sc.nextInt()][sc.nextInt()]=2;
		}
		int l = sc.nextInt();
		//방향 전환 입력
		for(int i=0;i<l;i++) {
			chDir[sc.nextInt()]=sc.next().charAt(0);
		}
		//시작 위치
		int x = 1;int y = 1;
		//최초 방향(0동, 1남, 2서, 3북)
		int dir = 0;
		//경과 시간
		int time = 0;
		Queue<Pos> q = new LinkedList<>();
		while(true) {
			//1) 다음 지점 탐색(벽 or 자기 자신인지 확인 + 사과 or 빈칸인지 확인)
			if(x<=0||y<=0||x>n||y>n||map[x][y]==1) {
				System.out.println(time);
				break;
			}
			if(map[x][y]!=2&&!q.isEmpty()) {
				Pos p = q.poll();
				map[p.x][p.y]=0;
			}
			map[x][y]=1;
			q.add(new Pos(x, y));
			//2) 좌표 이동
			x+=dx[dir];
			y+=dy[dir];
			time++;
			//3) 방향 전환
			if(chDir[time]=='D') dir++;
			if(chDir[time]=='L') dir--;
			if(dir<0) dir=3;
			if(dir>3) dir=0;
		}
	}
}
