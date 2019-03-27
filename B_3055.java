package test_190327;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int x, y, w, time;
	public Loc(int x, int y, int w, int time) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.time=time;
	}
}

//지도 상에 물이 차오르는 지점이 표시될 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위한  최소시간 구하기
public class B_3055 {

	static int r;
	static int c;
	static char [][] map;
	//고슴도치 상하좌우 이동 가능
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int cnt = 0;
	
	//물의 위치 먼저 큐에 입력
	public static void bfs(ArrayList<Loc> water, int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		for(int i=0;i<water.size();i++) {
			q.add(new Loc(water.get(i).x, water.get(i).y,1,0));
		}
		q.add(new Loc(x, y, 0, 0));
		while(!q.isEmpty()) {
			Loc l = q.poll();
			//고슴도치 이동
			if(l.w==0) {
				for(int i=0;i<4;i++) {
					int nx = l.x+dx[i];
					int ny = l.y+dy[i];
					if(nx<0||ny<0||nx>=r||ny>=c) continue;
					if(map[nx][ny]=='.') {
						map[nx][ny]='S';
						q.add(new Loc(nx, ny, 0, l.time+1));
					}
					//동굴에 도착하면
					if(map[nx][ny]=='D') {
						System.out.println(l.time+1);
						System.exit(0);
					}
				}
			}
			//물 이동
			else {
				for(int i=0;i<4;i++) {
					int nx = l.x+dx[i];
					int ny = l.y+dy[i];
					if(nx<0||ny<0||nx>=r||ny>=c) continue;
					if(map[nx][ny]=='.') {
						map[nx][ny]='*';
						q.add(new Loc(nx, ny, 1, 0));
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(r<=50&&c<=50) {
			map = new char[r][c];
			ArrayList<Loc> water = new ArrayList<>();
			int x = 0;
			int y = 0;
			//지도 입력
			for(int i=0;i<r;i++) {
				String str = sc.next();
				for(int j=0;j<str.length();j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='*') {
						water.add(new Loc(i, j, 1, 0));
					}
					else if(map[i][j]=='S') {
						x=i;
						y=j;
					}
				}
			}
			//BFS 탐색
			bfs(water,x,y);
		}	
	}
}
