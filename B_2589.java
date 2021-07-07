package test_181125;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P{
	int x,y;
	
	public P(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//보물섬 지도에서 육지와 바다의 분포가 주어질 때, 보물은 최단거리이면서 가장 긴 시간이 걸리는 육지 두 곳에 묻혀있음
public class B_2589 {

	static char [][] map;
	static boolean [][] visited;
	static int [][] dp;
	static int r;
	static int cnt1 = 0;
	static int cnt2 = 0;
	static int c;
	static int max = 0;
	//상하좌우 이동 지점
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static ArrayList<Integer> x = new ArrayList<>();
	static ArrayList<Integer> y = new ArrayList<>();
	
	public static void bfs(int x, int y) {
		Queue<P> q = new LinkedList<>();
		q.add(new P(x, y));
		
		while(!q.isEmpty()) {
			P p = q.poll();
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				//영역을 벗어날 경우
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//다음 지점이 육지일 경우
				if(map[nextx][nexty]=='L'&&!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new P(nextx, nexty));
					dp[nextx][nexty]=dp[p.x][p.y]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(1<=r&&r<=50&&1<=c&&c<=50) {
			map = new char[r][c];
			visited = new boolean[r][c];
			dp = new int[r][c];
			
			for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='L') {
						cnt1++;
					}
				}
			}
			while(cnt2<cnt1) {
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//탐색 시작 지점 (육지)
						if(!visited[i][j]&&map[i][j]=='L') {
							boolean flag = false;
							for(int k=0;k<x.size();k++) {
								//이미 시작 지점으로 활용한 좌표이면
								if(x.get(k)==i&&y.get(k)==j) {
									flag=true;
									break;
								}
							}
							if(!flag) {
								visited[i][j]=true;
								bfs(i,j);
								x.add(i);
								y.add(j);
								cnt2++;
							}
						}	
					}
				}
				//오름차순 정렬
				int tmp = 0;
				for(int i=0;i<dp.length;i++) {
					for(int j=0;j<dp[i].length;j++) {
						if(dp[i][j]>tmp) {
							tmp=dp[i][j];
						}
					}
				}
				if(max<tmp) {
					max=tmp;
				}
				//방문 여부 및 DP 초기화
				visited = new boolean[r][c];
				dp = new int[r][c];
			}
			System.out.println(max);
		}
	}
}
