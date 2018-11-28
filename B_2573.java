package test_181128;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x,y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//각 빙산의 높이, 바다와 인접한 면의 개수가 주어질 때 빙산이 녹아 최초 2개 이상 영역으로 분리되는 최소 시간(년) 구하기
public class B_2573 {

	static int r;
	static int c;
	static int [][] map;
	static boolean [][] visited;
	//영역 유무 변수
	static int area = 0;
	//최소 시간 변수
	static int cnt = 0;
	//상하좌우 어디든 빙산이 있으면 아직은 연결된 것
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			//현 위치 기준 인접 바다의 개수
			int sea = 0;
			
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				//다음 지점이 영역 밖이면
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//다음 지점이 방문하지 않은 빙산이면(좌표 저장)
				if(!visited[nextx][nexty]&&map[nextx][nexty]>0) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
				}
				//다음 지점이 바다이면(인접 바다의 개수만큼 빙산 높이 감소)
				if(map[nextx][nexty]==0) {
					sea++;
				}
			}
			map[p.x][p.y]-=sea;
			sea=0;
			//이미 다 녹았으면 0(바다)로 변경
			if(map[p.x][p.y]<0) {
				map[p.x][p.y]=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(3<=r&&r<=300&&3<=c&&c<=300) {
			map = new int[r][c];
			visited = new boolean[r][c];
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					int tmp = sc.nextInt();
					if(0<=tmp&&tmp<=10) {
						map[i][j]=tmp;
					}
				}
			}
			//배열의 첫행 첫열, 마지막행 마지막열은 항상 0(바다)
			map[0][0]=0;
			map[r-1][c-1]=0;
			while(true) {
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//탐색하지 않았고 빙산이면
						if(!visited[i][j]&&map[i][j]>0) {
							area++;
							System.out.println("cnt : "+cnt);
							System.out.println("area : "+area);
							visited[i][j]=true;
							bfs(i,j);
						}
					}
				}
				//영역이 1개면 다시 탐색 진행
				if(area==1) {
					cnt++;
					//재탐색 할 때 방문 배열 및 영역 유무 변수 초기화
					visited = new boolean[r][c];
					area=0;
				}
				//영역이 1개 이상이면 반복 중단
				else {
					System.out.println(cnt);
					System.exit(0);
				}
			}
		}
	}
}
