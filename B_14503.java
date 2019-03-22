package test_190322;

import java.util.Scanner;

//�κ� û�ұ�� ��� ��ġ, ���� �ٶ󺸴� ������ �־��� ��, û�Ҹ� �ǽ��� �� �ִ� ��� ���� ���� ���ϱ�
public class B_14503 {

	static int n;
	static int m;
	static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	static int [][] map;
	static boolean [][] v;
	static int cnt = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=50&&m<=50) {
			map = new int[n][m];
			v = new boolean[n][m];
			
			//���� ��ġ �� ����
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dir = sc.nextInt();
			
			//��� �� ���� ��ġ �Է�
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			while(true) {
				//���� ��ġ = �湮���� ���� ���
				if(!v[x][y]) {
					cnt++;
					v[x][y]=true;
				}
				boolean flag = false;
				for(int i=1;i<=4;i++) {
					int nDir = (4+dir-i)%4;
					int nx = x+move[nDir][0];
					int ny = y+move[nDir][1];
					if(nx<0||ny<0||nx>=n||nx>=m||v[nx][ny]||map[nx][ny]==1) continue;
					flag = true;
					x = nx;
					y = ny;
					dir = nDir;
					break;
				}
				//����� �湮�� ���̰ų� ���̸�(���� ���� ���� �Ǻ�)
				if(!flag) {
					int nDir = (2+dir)%4;
					int nx = x+move[nDir][0];
					int ny = y+move[nDir][1];
					//���� ��ġ = �� (���α׷� ����)
					if(map[nx][ny]==1) break;
					x = nx;
					y = ny;
				}
			}
			System.out.println(cnt);
		}
	}
}
