package test_190218;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//수빈이가 동생과 숨바꼭질을 하는데 두 명의 현재 좌표가 주어질 때, 규칙에 의해 이동하며 동생을 찾을 시 최단시간 구하기
public class B_1697 {

	static int n;
	static int k;
	//경과되는 시간 저장할 배열
	static int [] dp;
	static boolean [] v;
	
	//BFS + DP 탐색
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			//구하고자 하는 지점에 도착했으면
			if(now==k) break;
			for(int i=0;i<3;i++) {
				int nx = now;
				if(i==0) nx++;
				else if(i==1) nx--;
				else nx*=2;
				
				//다음 지점 = 영역 밖
				if(nx>100000||nx<0) continue;
				
				//다음 지점 = 영역 내
				if(!v[nx]) {
					v[nx]=true;
					dp[nx]=dp[now]+1;
					q.add(nx);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(n<=100000&&k<=100000) {
			dp = new int[100001];
			v = new boolean[100001];
			
			//탐색 실행
			bfs(n);
			System.out.println(dp[k]);
		}	
	}
}
