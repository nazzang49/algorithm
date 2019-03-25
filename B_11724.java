package test_190325;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//방향 없는 그래프가 주어졌을 때, 연결 요소의 갯수 구하기
public class B_11724 {

	//정점 갯수
	static int n;
	//간선 갯수
	static int m;
	//연결 정보
	static boolean [][] line;
	//방문 여부
	static boolean [] v;
	//연결 요소 갯수
	static int cnt = 0;
	
	public static  void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1;i<=n;i++) {
				if(!v[i]&&line[now][i]) {
					v[i]=true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000&&m<=n*(n-1)/2) {
			line = new boolean[n+1][n+1];
			v = new boolean[n+1];
			
			//간선 정보 입력
			for(int i=0;i<m;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				line[u][v]=line[v][u]=true;
			}
			
			//BFS 탐색
			for(int i=1;i<=n;i++) {
				if(!v[i]) {
					v[i]=true;
					cnt++;
					bfs(i);
				}
			}
			System.out.println(cnt);
		}	
	}
}
