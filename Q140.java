package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//그래프가 주어질 때, 모든 노드를 방문할 때 얻을 수 있는 스패닝 트리(특정 간선을 지날 때 획득하는 가중치들의 총합)의 최소값 구하기
//DFS와 BFS 탐색 중 최소값 출력
public class Q140 {

	static int [][] point;
	static boolean [] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int now, int sum, int count) {
		if(count==point.length-1) {
			if(min>=sum) {
				min=sum;
			}
		}else {
			count++;
			for(int i=1;i<point.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=point[now][i];
					dfs(i,sum,count);
					sum-=point[now][i];
					visited[i]=false;
				}
			}			
		}
	}
	
	public static void bfs(int now, int sum) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=1;i<point.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=point[tmp][i];
					q.add(i);
				}
			}
		}
		if(min>=sum) {
			min=sum;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=10000&&1<=m&&m<=100000) {
			visited = new boolean[n+1];
			point = new int[n+1][n+1];
			//간선 정보 및 가중치 점수 입력
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				int tmp3 = sc.nextInt();
				if(Math.abs(tmp3)<=1000000) {
					point[tmp1][tmp2]=point[tmp2][tmp1]=tmp3;
				}
			}
			//탐색 실행(DFS, BFS 순서)
			for(int i=1;i<=n;i++) {
				visited[i]=true;
				dfs(i,0,1);
				visited[i]=false;
			}
			visited = new boolean[n+1];
			for(int i=1;i<=n;i++) {
				bfs(i,0);
				visited = new boolean[n+1];
			}
			System.out.println(min);
		}
	}
}
