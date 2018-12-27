package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1번부터 n까지 섬의 개수 n개, 섬의 연결여부를 나타내는 간선 m개, 이미 감염된 섬의 번호를 나타내는 k개 입력, 격리된 섬 이외의 그룹 내 감염된 섬이 t개 이상이면 전체가 감염되는 것으로 간주할 때 1번부터 n번까지의 섬을 하나씩 격리할 시 감염되지 않는 섬의 개수 출력하기
//BFS 탐색 적용
public class Q98 {

	static int n;
	static int m;
	static int k;
	static int t;
	//섬 간 연결 여부
	static boolean [][] line;
	//방문 여부
	static boolean [] visited;
	//감염 여부
	static boolean [] infected;
	//감염된 섬의 개수
	static int cnt = 0;
	//정답 담을 배열
	static int [] answer;
	
	//1번부터 탐색
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		//그룹별 감염된 섬의 개수
		int cnt_group = 0;
		if(infected[node]) {
			cnt_group = 1;
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1;i<=n;i++) {
				//연결되어 있고 방문하지 않은 섬이면
				if(line[now][i]&&!visited[i]) {
					visited[i]=true;
					q.add(i);
					if(infected[now]) {
						cnt_group++;
						infected[i]=true;
					}
				}
			}
		}
		//더 이상 탐색할 노드가 없을 때(=하나의 그룹이 형성되면) 그룹 전체 감염 여부 판별
		if(cnt_group>=t) {
			cnt+=(cnt_group-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		t = sc.nextInt();
		
		line = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		infected = new boolean[n+1];
		answer = new int[n+1];
		
		//연결 여부 입력
		for(int i=0;i<m;i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			if(1<=tmp1&&tmp1<=n&&1<=tmp2&&tmp2<=n) {
				//연결되어 있다면 어느 쪽 노드에서든 서로 이동 가능
				line[tmp1][tmp2]=line[tmp2][tmp1]=true;
			}
		}
		
		int [] infected_idx = new int[k];
		
		//이미 감염된 섬의 번호 입력
		for(int i=0;i<k;i++) {
			infected_idx[i] = sc.nextInt();
			infected[infected_idx[i]]=true;
		}
		
		//탐색 실행(1~n번까지의 섬을 하나씩 격리 시킬 때 = n번과 연결된 간선 모두 폐지)
		int i = 1;
		while(i<=n) {
			//간선 폐지(격리)
			for(int j=1;j<=n;j++) {
				line[i][j]=line[j][i]=false;
			}
			//i번째 섬이 격리된 상황에서 각 그룹별 방문
			for(int j=1;j<=n;j++) {
				if(!visited[j]) {
					visited[j]=true;
					if(infected[j]) {
						cnt++;
					}
					bfs(j);
				}
			}
			answer[i]=cnt;
			//변수 초기화
			cnt=0;
			infected = new boolean[n+1];
			for(int j=0;j<infected_idx.length;j++) {
				infected[infected_idx[j]]=true;
			}
			visited = new boolean[n+1];
			//간선 부활(백트래킹)
			for(int j=1;j<=n;j++) {
				line[i][j]=line[j][i]=true;
			}
			i++;
		}
		
		//전체 감염되지 않은 섬의 개수(전체 섬 - 감염된 섬의 개수)
		for(int j=1;j<answer.length;j++) {
			System.out.println(n-answer[j]);
		}
	}
}
