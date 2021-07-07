package test_190216;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int x,y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//���ٰ� (0,0)���� (n-1, n-1)�� �̵��ϴµ� ȹ���ϰ� �Ǵ� ���������� ���� �ּҷ� �ϱ� ���� ���α׷� �ۼ��ϱ�
public class B_4485_BFS {

	static int n;
	static int [][] map;
	static int [][] dp;
	static int [][] move = {{1,0},{0,1}};
	
	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			for(int i=0;i<2;i++) {
				int nx = l.x+move[i][0];
				int ny = l.y+move[i][1];
				
				//���� ���� = ���� ��
				if(nx>=n||ny>=n) continue;
				
				//���� ���� = ���� ��(�ּҰ� ���� "���� �ּҰ��� ���� ��ǥ������ �ּҰ� + ���� ��ǥ ���Ϸ��� �� ��")
				dp[nx][ny]=Math.min(dp[nx][ny], dp[l.x][l.y]+map[nx][ny]);
				q.add(new Loc(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=125) {
			dp = new int[n][n];
			map = new int[n][n];
			
			//�� ��ǥ�� ���Ϸ��� ũ�� �Է�
			for(int i=0;i<n;i++) {
				Arrays.fill(dp[i], 100001);
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//BFS + DP Ž�� ����
			dp[0][0]=map[0][0];
			bfs(0,0);
			System.out.println(dp[n-1][n-1]);
		}
	}
}
