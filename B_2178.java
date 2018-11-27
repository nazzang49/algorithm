package test_181127;

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

//�̷ΰ� �־��� ��, ��������� ���������� �̵��ϴ� �ּ� ĭ�� ���ϱ�
public class B_2178 {

	static int r;
	static int c;
	static char [][] map;
	//�� ��ġ���� �ּ�ĭ�� ������ �迭
	static int [][] dp;
	static boolean [][] visited;
	//�����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				
				//���� ������ ���� ���̸�
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//���� ������ �湮���� ���� 1�̸�
				if(map[nextx][nexty]=='1'&&!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
					//���� ��ġ + 1ĭ
					dp[nextx][nexty]=dp[p.x][p.y]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(2<=r&&r<=100&&2<=c&&c<=100) {
			map = new char [r][c];
			visited = new boolean [r][c];
			dp = new int [r][c];
			
			for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<str.length();j++) {
					map[i][j]=str.charAt(j);
				}
			}
			//Ž�� ����(���� ���� �ʱ�ȭ)
			visited[0][0]=true;
			dp[0][0]=1;
			bfs(0,0);
			//���� ���� + 1ĭ
			System.out.println(dp[r-1][c-1]);
		}
	}
}
