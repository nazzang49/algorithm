package test_190329;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int now, cnt;
	public Pos(int now, int cnt) {
		this.now=now;
		this.cnt=cnt;
	}
}

//친척관계가 정수 쌍으로 주어질 때, 특정 인물들 간 촌수 계산하기
public class B_2644 {

	static int n;
	static int m;
	static boolean [] v;
	static boolean [][] connected;
	static int cnt = 0;
	
	public static void bfs(int s, int e) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(s, 0));
		while(!q.isEmpty()) {
			Pos p = q.poll();
			//찾고자 하는 친척과 촌수관계가 형성되어 있으면
			if(p.now==e) {
				System.out.println(p.cnt);
				System.exit(0);
			}
			for(int i=1;i<=n;i++) {
				//친척 관계 + 미방문
				if(!v[i]&&connected[p.now][i]) {
					v[i]=true;
					q.add(new Pos(i, p.cnt+1));
				}
			}
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100) {
			v = new boolean[n+1];
			connected = new boolean[n+1][n+1];
			//친척 관계 입력
			for(int i=0;i<m;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				connected[s][e]=connected[e][s]=true;
			}
			//BFS 탐색
			bfs(a,b);
		}
	}
}
