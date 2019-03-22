package test_190322;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS, BFS를 수행한 결과 출력하기
public class B_1260 {

	static int n;
	static int m;
	static boolean [][] line;
	static boolean [] v;
	
	//깊이 우선 탐색
	public static void dfs(int now) {
		System.out.print(now+" ");
		for(int i=1;i<=n;i++) {
			//아직 방문하지 않았고, 현재 정점과 연결된 정점이면
			if(!v[i]&&line[now][i]) {
				v[i]=true;
				dfs(i);
			}
		}
	}
	
	//넓이 우선 탐색
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		v[now]=true;
		q.add(now);
	
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur+" ");
			for(int i=1;i<=n;i++) {
				//아직 방문하지 않았고, 현재 정점과 연결된 정점이면
				if(!v[i]&&line[cur][i]) {
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
		int start = sc.nextInt();
		
		if(n<=1000&&m<=10000) {
			v = new boolean[n+1];
			line = new boolean[n+1][n+1];
			
			//간선 정보 입력(양방향 연결)
			for(int i=0;i<m;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				line[s][e]=line[e][s]=true;
			}
			
			//탐색 및 출력
			v[start]=true;
			dfs(start);
			Arrays.fill(v, false);
			System.out.println();
			bfs(start);
		}	
	}
}
