package test_181125;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//노드와 간선 정보가 주어질 때, 트리의 최대 지름 값 구하기
public class B_12761 {

	static boolean [] visited = new boolean [100001];
	//이동 횟수 저장할 배열
	static int [] dp = new int [100001];
	static int a;
	static int b;
	static int n;
	static int m;
	
	public static void bfs(int x, int [] move) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int d = q.poll();
			//도착 지점이면
			if(d==m) {
				System.out.println(dp[m]);
				System.exit(0);
			}
			for(int i=0;i<8;i++) {
				//다음 지점
				int s = 0;
				
				if(i>=6) {
					s=d*move[i];
				}else {
					s=d+move[i];
				}
				
				//범위 벗어나는 지점이면
				if(s<0||s>100000) {
					continue;
				}
				
				if(!visited[s]) {
					dp[s]=dp[d]+1;
					visited[s]=true;
					q.add(s);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//한번에 가능한 이동 거리 a,b
		a = sc.nextInt();
		b = sc.nextInt();
		//출발 지점
		n = sc.nextInt();
		//도착 지점
		m = sc.nextInt();
		
		int [] move = {1,-1,a,b,-a,-b,a,b};
		
		if(2<=a&&a<=30&&2<=b&&b<=30&&0<=n&&n<=100000&&0<=m&&m<=100000) {
			bfs(n,move);
		}else {
			System.out.println("입력값의 범위를 확인하세요.");
			System.exit(0);
		}
	}
}
