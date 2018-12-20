package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
	int x, y;
	
	public Location(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//�� 1���� �� 1���� ��ǥ�� �־��� ��, ���� ��� �Ǵ� ���� �ּ� �̵� Ƚ�� ���ϱ� 
public class Q68 {

	static int n;
	static int m;
	static boolean [][] visited;
	static int [][] dp;
	//�� 8�� �������� �̵� ����
	static int [][] move = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
	static int x_des;
	static int y_des;
	
	public static void bfs(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(x, y));
		
		while(!q.isEmpty()) {
			Location l = q.poll();
			
			//���� ���� �����̸�
			if(l.x==x_des-1&&l.y==y_des-1) {
				System.out.println(dp[x_des][y_des]);
				System.exit(0);
			}
			
			for(int i=0;i<8;i++) {
				int nx = l.x+move[i][0];
				int ny = l.y+move[i][1];
				//���� ������ ���� �����
				if(nx<0||ny<0||nx>=n||ny>=m) {
					continue;
				}
				//���� ������ �湮���� ���� ���̸�
				if(!visited[nx][ny]) {
					visited[nx][ny]=true;
					dp[nx][ny]=dp[l.x][l.y]+1;
					q.add(new Location(nx, ny));	
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(1<=n&&n<=100&&1<=m&&m<=100) {
			visited = new boolean[n][m];
			dp = new int[n][m];
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			x_des = sc.nextInt();
			y_des = sc.nextInt();
			
			bfs(start_x,start_y);
		}
	}
}
