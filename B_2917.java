package test_190125;

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

//���� ��ġ, ���θ� ��ġ, ���ݼ��� ���� �ִ� ���� ��ġ, �̵� ������ �� ������ �־��� ��, ���θ����� �̵��ϴ� ��� �� �������� �ּҰŸ��� ���� ū ��� ���ϱ�
public class B_2917 {

	static int oduX;
	static int oduY;
	static int treeX;
	static int treeY;
	static int n;
	static int m;
	static char [][] map;
	static boolean [][] visited;
	static int [][] dp;
	//�����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		dp[x][y]=Math.abs(x-treeX)+Math.abs(y-treeY);
		
		//Ž���� ������ ������ ����ؼ� ����
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				//Ž�� ���� = ���� ��
				if(nx<0||ny<0||nx>=n||ny>=m) {
					continue;
				}
				//Ž�� ���� = �̵����� ���� �� ����
				if(!visited[nx][ny]&&map[nx][ny]=='.') {
					visited[nx][ny]=true;
					q.add(new Pos(nx, ny));
					//�� ��ο��� �������� �ּҰ� ����ؼ� ����
					dp[nx][ny]=Math.min(dp[p.x][p.y], Math.abs(nx-treeX)+Math.abs(ny-treeY));
				}
				//Ž�� ���� = ���θ�
				if(map[nx][ny]=='J') {
					dp[nx][ny]=Math.max(Math.min(dp[p.x][p.y], Math.abs(nx-treeX)+Math.abs(ny-treeY)), dp[nx][ny]);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		//��� ���� ũ�� ����
		if(1<=n&&n<=500&&1<=m&&m<=500) {
			map = new char[n][m];
			visited = new boolean[n][m];
			dp = new int[n][m];
			
			int x = 0;
			int y = 0;
			//���� ���� �Է�
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<m;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='V') {
						x=i;
						y=j;
					}else if(map[i][j]=='+') {
						treeX=i;
						treeY=j;
					}else if(map[i][j]=='J') {
						oduX=i;
						oduY=j;
					}
				}
			}
			//BFS Ž�� ����
			bfs(x,y);
			System.out.println(dp[oduX][oduY]);
		}
	}
}
