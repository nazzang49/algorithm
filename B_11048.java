package test_190116;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x, y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//�ر԰� nxm �̷ο� �����ְ�, �� �濡�� ������ ������ ���� �� 1�� 1������ n�� m���� �̵��ϴ� �������� ��ԵǴ� ���� ������ �ִ밪 ���ϱ�
public class B_11048 {

	static int n;
	static int m;
	static int [][] dp;
	static int [][] map;
	//������ ������� ���� ���� �̵� ����
	static int [][] move= {{1,0},{0,1},{1,1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<3;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				
				//Ž�� ���� ������ ����� ���
				if(nx<0||ny<0||nx>=n||ny>=m) {
					continue;
				}
				//���� ����� �� vs ���� ��ġ������ ������ + ���� ��ġ���� ���� �� �ִ� ���� ����
				dp[nx][ny]=Math.max(dp[nx][ny], dp[p.x][p.y]+map[nx][ny]);
				q.add(new Pos(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=m&&m<=1000) {
			map = new int[n][m];
			//���� �� �ִ� ������ �ִ� ���� ���ؼ� ������ �迭
			dp = new int[n][m];
			//�� �濡 �����ִ� ���� ���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//BFS Ž�� �ǽ�
			dp[0][0]=map[0][0];
			bfs(0,0);
			System.out.println(dp[n-1][m-1]);
		}
	}
}
