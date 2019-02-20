package test_190220;

import java.util.Scanner;

//���ĺ����� �̷���� �������� �־��� ��, ���� ���ĺ��� �ѹ� �̻� ���� �� ���ٸ� ���� �ǳ� �� �ִ� �ִ� ĭ�� ���ϱ�
public class B_1987 {

	static int r;
	static int c;
	static char [][] map;
	//�����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [] alpha = new int[26];
	static int max = 0;
	
	public static void dfs(int x, int y, int cnt) {
		for(int i=0;i<4;i++) {
			int nx = x+move[i][0];
			int ny = y+move[i][1];
			
			//���� ���� = ���� ��
			if(nx<=0||ny<=0||nx>r||ny>c) continue;
			
			//���� ���� = ���� ��(�湮 ó�� + ���ĺ� ���� ó��)
			if(alpha[map[nx][ny]-'A']==0) {
				//���� ��ο����� �湮�� ������ ó��
				alpha[map[nx][ny]-'A']=1;
				dfs(nx,ny,cnt+1);
				//��Ʈ��ŷ(���� ��ο��� ���� ���� �ʵ���)
				alpha[map[nx][ny]-'A']=0;
			}else {
				max=Math.max(max, cnt);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		if(r<=20&&c<=20) {
			map = new char[r+1][c+1];
			//���ĺ� �Է�
			for(int i=1;i<=r;i++) {
				String str = sc.next();
				for(int j=1;j<=c;j++) {
					map[i][j]=str.charAt(j-1);
				}
			}
			alpha[map[1][1]-'A']=1;
			//DFS Ž��
			dfs(1,1,1);
			System.out.println(max);
		}	
	}
}
