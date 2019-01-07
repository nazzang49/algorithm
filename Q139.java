package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//그래프를 DFS 및 BFS로 탐색한 결과 출력하기
public class Q139 {

	static boolean [][] line;
	static boolean [] visited;
	static ArrayList<Integer> answer = new ArrayList<>();
	
	//깊이 우선 탐색(재귀)
	public static void dfs(int now) {
		for(int i=1;i<visited.length;i++) {
			//아직 방문하지 않았고, 연결된 지점이면
			if(!visited[i]&&line[now][i]) {
				visited[i]=true;
				answer.add(i);
				dfs(i);
			}
		}
	}
	
	//너비 우선 탐색(큐)
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=1;i<visited.length;i++) {
				//아직 방문하지 않았고, 연결된 지점이면
				if(!visited[i]&&line[tmp][i]) {
					visited[i]=true;
					q.add(i);
					answer.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//노드의 수(1번부터 n번까지 존재)
		int n = sc.nextInt();
		//주어지는 간선 정보의 개수
		int m = sc.nextInt();
		//탐색 시작하는 노드
		int v = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=m&&m<=10000) {
			line = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			
			//간선 여부 세팅
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				//true(노드 간 연결되어 있음)
				line[tmp1][tmp2]=line[tmp2][tmp1]=true;
			}
			
			visited[v]=true;
			answer.add(v);
			//BFS 탐색
			bfs(v);
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
			
			System.out.println();
			
			answer.clear();
			visited = new boolean[n+1];
			visited[v]=true;
			answer.add(v);
			//BFS 탐색
			dfs(v);
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
		}
	}
}
