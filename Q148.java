package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//방향 없는 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 프로그램 작성하기
public class Q148 {

	//간선 존재 여부
	static boolean [][] line;
	//정점 방문 여부
	static boolean [] visited;
	//연결 요소 갯수
	static int cnt = 0;
	
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=1;i<visited.length;i++) {
				if(!visited[i]&&line[tmp][i]) {
					visited[i]=true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=1000&&0<=m&&m<=n*(n-1)/2) {
			line = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			
			//간선 정보 입력
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				line[tmp1][tmp2]=line[tmp2][tmp1]=true;
			}
			//탐색 실행
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					cnt++;
					visited[i]=true;
					bfs(i);
				}
			}
			System.out.println(cnt);
		}
	}
}
