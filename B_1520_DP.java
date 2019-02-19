package test_190219;

import java.util.Scanner;

//1520�� ���� by DP+DFS
public class B_1520_DP {
	
	static int n;
	static int m;
	static int [][] map;
	static int [][] dp;
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};

	public static int dfs(int x, int y) {
		//���� �����̸�
		if(x==n-1&&y==m-1) {
			return 1;
		}
		//�ι� �̻� ������ �����̸�
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int nx = x+move[i][0];
			int ny = y+move[i][1];
			
			//���� ���� = ���� ��
			if(nx<0||ny<0||nx>=n||ny>=m) continue;
			
			//���� ���� = ���� ��, ��������
			if(map[x][y]>map[nx][ny]) {
				cnt+=dfs(nx,ny);
			}
		}
		return dp[x][y]=cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=500&&m<=500) {
			map = new int[n][m];
			dp = new int[n][m];
			
			//���� ���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
					//�ʱ�ȭ
					dp[i][j]=-1;
				}
			}
			//DFS ����
			System.out.println(dfs(0,0));
		}	
	}
}
