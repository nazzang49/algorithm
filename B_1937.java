package test_190207;

import java.util.Scanner;

//�Ǵٰ� NxN ������ �볪�� ���� �̵��� ��, ��Ģ�� ���� ������ �� �ִ� �ִ��ϼ� ���ϱ�(DFS+DP)
public class B_1937 {

	static int n;
	//�����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	//���� ������ ������ �迭
	static int [][] dp;
	//�볪�� �� ����
	static int [][] map;
	
	public static int dfs(int x, int y) {
		//�̹� �湮�� ���̸�
		if(dp[x][y]>0) return dp[x][y];
		
		dp[x][y]=1;
		for(int i=0;i<4;i++) {
			int nx = x+move[i][0];
			int ny = y+move[i][1];
			
			//���� ���� = ���� ��
			if(nx<0||ny<0||nx>=n||ny>=n) {
				continue;
			}
			//���� ���� = �볪�� ���� Ŀ�� ��(�̵�)
			if(map[x][y]<map[nx][ny]) {
				//���� ���� = ����� ������ �������� ����(max ����� 1�̶��, ���� ������ ���ο� �������� �ȴٴ� �ǹ�)
				dp[x][y]=Math.max(dp[x][y], dfs(nx,ny)+1);
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=500) {
			map = new int[n][n];
			dp = new int[n][n];

			//�볪�� �� ���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			//Ž�� ����
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//��� �������� ���� ������ ����
					max=Math.max(max, dfs(i,j));
				}
			}
			System.out.println(max);
		}else {
			System.out.println("�Է� ������ Ȯ�����ּ���.");
			System.exit(0);
		}
	}
}
