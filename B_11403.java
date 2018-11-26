package test_181126;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//가중치 없는 방향 그래프가 주어질 때, 모든 정점 i에서 j로 가는 경로의 존재 유무 구하기
public class B_11403 {

	//노드 간 연결 여부 저장된 간선 배열
	static int [][] map;
	static int [][] answer;
	static boolean [] visited;
	static int n;
	//탐색 시작 지점인 현재 위치 저장
	static int k;
	
	//현위치 노드 인접 지점부터 탐색 시작
	public static void bfs(int [][] map) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			q.add(i);
			Arrays.fill(visited, false);
			while(!q.isEmpty()) {
				int s = q.poll();
				for(int j=0;j<n;j++) {
					if(map[s][j]==1&&!visited[j]) {
						visited[j]=true;
						answer[i][j]=1;
						q.add(j);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			map = new int[n][n];
			answer = new int[n][n];
			visited = new boolean[n];
			
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//탐색 시작
			bfs(map);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(answer[i][j]+" ");
				}
				System.out.println();
			}
		}	
	}
}
