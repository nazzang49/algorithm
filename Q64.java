package solution;

import java.util.Scanner;

//n장소를 모두 배달하고 돌아오는 알바의 경로 중, 이동 비용을 최소화하여 움직이는 경우의 경비 구하기
public class Q64 {

	//지점의 개수
	static int n;
	//모든 지점 방문 여부 저장할 배열
	static boolean [] visited;
	static int [][] cost;
	//최대값으로 초기화
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int start, int sum, int count) {
		if(count==n-1) {
			//마지막은 출발지로 이동
			sum+=cost[start][0];
			if(min>=sum) {
				min=sum;
			}
		}else {
			count++;
			for(int i=1;i<cost[start].length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=cost[start][i];
					dfs(i,sum, count);
					sum-=cost[start][i];
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		//최대 열두 곳 방문 가능(1번에서 시작 및 도착)
		if(1<=n&&n<=12) {
			visited = new boolean[n];
			cost = new int[n][n];
			//비용 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int tmp = sc.nextInt();
					if(0<=tmp&&tmp<=100) {
						cost[i][j]=tmp;
					}
				}
			}
			//탐색(0에서 1로 가는 것부터 시작)
			for(int i=1;i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					dfs(i,cost[0][i],1);
					visited[i]=false;
				}
			}
			System.out.println(min);
		}
	}
}
