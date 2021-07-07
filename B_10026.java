package test_181122;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	
	int x, y;
	
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//���ϻ����� ����� �׷��� ���� ����� ���� RGB ������ �������� �̷���� ���� �к��ϱ�
public class B_10026 {

	static int n;
	static char [][] map;
	//�湮 ���� �迭�� �ΰ� �غ�
	static boolean [][] visited;
	//���� ����(���ϻ��� O / R�� G���� ����)
	static int cnt1;
	//���� ����(���ϻ��� X)
	static int cnt2;
	//���� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void bfs(int x, int y, int k) {
		
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x, y));
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			//�����¿� Ž��
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				
				//���� ������ ���� ���� ���
				if(nextx<0||nexty<0||nextx>=n||nexty>=n) {
					continue;
				}
				//���ϻ����� ���
				if(k==0) {
					if(!visited[nextx][nexty]
							&&(((map[p.x][p.y]=='R'||map[p.x][p.y]=='G')
							&&(map[nextx][nexty]=='R'||map[nextx][nexty]=='G'))
							||(map[p.x][p.y]=='B'&&map[nextx][nexty]=='B'))) {
						visited[nextx][nexty]=true;
						q.add(new Position(nextx, nexty));
					}
				}
				//���ϻ����� �ƴ� ���
				else {
					if(!visited[nextx][nexty]
							&&((map[p.x][p.y]=='R'&&map[nextx][nexty]=='R')
							||(map[p.x][p.y]=='G'&&map[nextx][nexty]=='G')
							||(map[p.x][p.y]=='B'&&map[nextx][nexty]=='B'))) {
						visited[nextx][nexty]=true;
						q.add(new Position(nextx, nexty));
					}
				}
			}
			//�� �̻� Ž���� ������ ������(=���� ����)
			if(q.isEmpty()) {
				if(k==0) {
					cnt1++;	
				}else {
					cnt2++;
				}	
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			map = new char[n][n];
			visited = new boolean[n][n];
			for(int i=0;i<n;i++) {
				String str = sc.next();
				if(str.length()==n) {
					for(int j=0;j<n;j++) {
						map[i][j]=str.charAt(j);
					}	
				}else {
					System.out.println("���ڿ��� ���̸� Ȯ�����ּ���.");
					System.exit(0);
				}
			}
			int k = 0;
			while(k<2) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(!visited[i][j]) {
							bfs(i,j,k);
						}
					}
				}
				//�ʱ�ȭ
				visited = new boolean[n][n];
				k++;
			}
			
			//���ϻ���X
			System.out.print(cnt2+" ");
			//���ϻ���O
			System.out.print(cnt1);
		}
	}
}
