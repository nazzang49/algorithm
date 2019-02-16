package test_190216;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x,y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//(1,1)���� (n,m) ��ġ�� �̵��ϱ���� �μ���� �ϴ� ���� �ּ� ���� ���ϱ�
public class B_1261 {

	static int n;
	static int m;
	static int [][] map;
	static int [][] dp;
	//�����¿� �̵� ����������, �����ʰ� �Ʒ��θ� �̵��Ѵٰ� ����
	static int [][] move = {{1,0},{0,1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<2;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				
				//���� ������ ���� ���̸�
				if(nx<0||ny<0||nx>=m||ny>=n) continue;
				
				//���� ���� = 1(��)
				if(map[nx][ny]==1) {
					dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]+1);
					q.add(new Pos(nx, ny));
				}
				
				//���� ���� = 0(���)
				if(map[nx][ny]==0) {
					dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]);
					q.add(new Pos(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100) {
			map = new int[m][n];
			dp = new int[m][n];
			
			//���(0), ��(1) ���� �Է�
			for(int i=0;i<m;i++) {
				String str = sc.next();
				Arrays.fill(dp[i], 10001);
				for(int j=0;j<n;j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			
			dp[0][0]=0;
			//BFS + DP Ž�� ����
			bfs(0,0);
			System.out.println(dp[m-1][n-1]);
		}	
	}
}
