package test_181128;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x,y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//�� ������ ����, �ٴٿ� ������ ���� ������ �־��� �� ������ ��� ���� 2�� �̻� �������� �и��Ǵ� �ּ� �ð�(��) ���ϱ�
public class B_2573 {

	static int r;
	static int c;
	static int [][] map;
	static boolean [][] visited;
	//���� ���� ����
	static int area = 0;
	//�ּ� �ð� ����
	static int cnt = 0;
	//�����¿� ���� ������ ������ ������ ����� ��
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			//�� ��ġ ���� ���� �ٴ��� ����
			int sea = 0;
			
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				//���� ������ ���� ���̸�
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//���� ������ �湮���� ���� �����̸�(��ǥ ����)
				if(!visited[nextx][nexty]&&map[nextx][nexty]>0) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
				}
				//���� ������ �ٴ��̸�(���� �ٴ��� ������ŭ ���� ���� ����)
				if(map[nextx][nexty]==0) {
					sea++;
				}
			}
			map[p.x][p.y]-=sea;
			sea=0;
			//�̹� �� ������� 0(�ٴ�)�� ����
			if(map[p.x][p.y]<0) {
				map[p.x][p.y]=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(3<=r&&r<=300&&3<=c&&c<=300) {
			map = new int[r][c];
			visited = new boolean[r][c];
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					int tmp = sc.nextInt();
					if(0<=tmp&&tmp<=10) {
						map[i][j]=tmp;
					}
				}
			}
			//�迭�� ù�� ù��, �������� ���������� �׻� 0(�ٴ�)
			map[0][0]=0;
			map[r-1][c-1]=0;
			while(true) {
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//Ž������ �ʾҰ� �����̸�
						if(!visited[i][j]&&map[i][j]>0) {
							area++;
							System.out.println("cnt : "+cnt);
							System.out.println("area : "+area);
							visited[i][j]=true;
							bfs(i,j);
						}
					}
				}
				//������ 1���� �ٽ� Ž�� ����
				if(area==1) {
					cnt++;
					//��Ž�� �� �� �湮 �迭 �� ���� ���� ���� �ʱ�ȭ
					visited = new boolean[r][c];
					area=0;
				}
				//������ 1�� �̻��̸� �ݺ� �ߴ�
				else {
					System.out.println(cnt);
					System.exit(0);
				}
			}
		}
	}
}
