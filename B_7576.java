package test_181127;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//토마토를 담는 격자 형태의 상자가 있을 때, 모든 토마토가 다 익는데 걸리는 최소 일수 구하기
//최소 일수 or -1(다 익을 수 없는 경우) or 0(이미 다 익어 있는 경우)
import java.util.Scanner;

class Loc {
	int x, y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class B_7576 {

	static int r;
	static int c;
	static int answer;
	static int [][] map;
	static boolean [][] visited;
	//상하좌우 인접 지점 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [][] dp;
	static ArrayList<Loc> list = new ArrayList<>();
	
	//더 이상 탐색할 지점이 없고, 인접 지점이 모두 익은 경우(1)가 기준
	public static void bfs(ArrayList list) {
		Queue<Loc> q = new LinkedList<>();
		
		for(int i=0;i<list.size();i++) {
			q.add((Loc)list.get(i));
		}
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				//다음 지점이 영역 밖이라면
				if(nextx<0||nexty<0||nextx>=c||nexty>=r) {
					continue;
				}
				//다음 지점이 아직 익지 않은 토마토라면
				if(map[nextx][nexty]==0&&!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Loc(nextx, nexty));
					//현 위치 + 1일
					dp[nextx][nexty]=dp[l.x][l.y]+1;
					map[nextx][nexty]=1;
				}
			}
			if(q.isEmpty()) {
				answer=dp[l.x][l.y];
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		if(2<=r&&r<=1000&&2<=c&&c<=1000) {
			map = new int[c][r];
			visited = new boolean[c][r];
			dp = new int[c][r];
			//이미 익은 토마토, 덜 익은 토마토, 비어 있는 칸을 저장
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
					//이미 익은 토마토이면
					if(map[i][j]==1) {
						visited[i][j]=true;
						list.add(new Loc(i, j));
					}
				}
			}
			//이미 익은 토마토의 지점에서 동시 탐색 진행
			bfs(list);
			
			//탐색 종료 후 아직 익지 않은 토마토가 있을 경우 판별
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j]==0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
