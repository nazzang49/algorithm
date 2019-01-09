package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//가중치 없는 방향 그래프 nxn 행렬이 주어질 때, 간선 정보를 파악하여 정점 간 연결 여부를 행렬로 출력하기
public class Q146 {

	static int [][] answer;
	static int [][] line;
	static boolean [] visited;
	
	//now에서 des로의 이동 경로가 있는지 체크
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=0;i<answer.length;i++) {
				//자기 자신에게 가는 경우는 제외
				if(tmp==i) {
					continue;
				}
				//아직 방문하지 않았고, 현재 정점과 연결된 정점이라면
				if(line[tmp][i]==1&&!visited[i]) {
					visited[i]=true;
					answer[now][i]=1;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			line = new int[n][n];
			answer = new int[n][n];
			visited = new boolean[n];
			
			//최초 간선 정보 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//1(연결 O) 0(연결 X)
					line[i][j]=sc.nextInt();
				}
			}
			//탐색 실행(i에서 j로 가는 경로가 있는지)
			for(int i=0;i<n;i++) {
				bfs(i);
				visited = new boolean[n];
			}
			//정답 출력
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(answer[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
