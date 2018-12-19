package solution;

import java.util.Scanner;

//nxn 정사각형 모양의 체스판 위에서 퀸이 움직일 수 있는 경로가 상하좌우, 대각선일 때 서로 겹치지 않는 경로 내 n개의 퀸을 놓는 경우의 수 구하기
public class Q63 {

	//1~n까지 퀸이 위치하고 있는지 여부 확인할 배열
	static boolean [] visited;
	static int cnt = 0;
	static int n;
	
	public static void dfs(int start, int count) {
		//모든 퀸을 놓을 수 있는 경우(정답+1)
		if(count==n) {
			cnt++;
		}else {
			for(int i=0;i<visited.length;i++) {
				//방문하지 않은 경우
				if(!visited[i]) {
					visited[i]=true;
					//직전에 저장된 위치에서 뻗어나오는 대각선 경로에 겹치지 않는 idx인 경우
					if(!(i==start-1||i==start+1)) {
						count++;
						dfs(i,count);
						count--;
					}
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=13) {
			visited = new boolean[n];
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					dfs(i,1);
					visited[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
