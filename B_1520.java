package test_190219;

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

//�� ������ ���̰� ���� ������ �־��� ��, ��� -> �������� ���� ��� �� �������游 ��� ������ �� �ִ� ����� �� ���ϱ�
public class B_1520 {

	static int n;
	static int m;
	static int [][] map;
	//�����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int cnt = 0;
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.x==n-1&&p.y==m-1) {
				cnt++;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				
				//���� ���� = ���� ��
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				//���� ���� = ��������
				if(map[nx][ny]<map[p.x][p.y]) {
					q.add(new Pos(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=500&&m<=500) {
			map = new int[n][m];
			
			//���� ���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//BFS Ž�� ����
			bfs(0,0);
			System.out.println(cnt);
		}	
	}
}
