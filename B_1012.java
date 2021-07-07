package test_181126;

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

//��� �翡 ���ߵ��� �ɾ��� ��ǥ�� �־��� ��, �������κ��� ��ȣ�ϱ� ���� �ʿ��� ������ ������ ���ϱ�
public class B_1012 {

	static int [][] map;
	static boolean [][] visited;
	//�ʿ��� ���� �������� ��
	static int cnt;
	//���� ���� ���� ����, ���� ����, ���߰� �ɾ��� ��ǥ ����
	static int r;
	static int c;
	static int n;
	//�����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [] answer;
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				//���� ���� = ���߹� ����� ����
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//���� ���� = �湮���� ���� ���� ����
				if(!visited[nextx][nexty]&&map[nextx][nexty]==1) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		answer = new int[t];
		
		int k=0;
		while(k<t) {
			r = sc.nextInt();
			c = sc.nextInt();
			n = sc.nextInt();
			if(1<=r&&r<=50&&1<=c&&c<=50) {
				map = new int[r][c];
				visited = new boolean[r][c];
				for(int i=0;i<n;i++) {
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					if(0<=x1&&x1<=r-1&&0<=y1&&y1<=c-1) {
						map[x1][y1]=1;
					}else {
						System.out.println("���߹��� ����ϴ�.");
						System.exit(0);
					}
				}
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//�湮���� ���� ���ο� ���� �����̸� ������ ���� +1
						if(!visited[i][j]&&map[i][j]==1) {
							cnt++;
							visited[i][j]=true;
							bfs(i,j);
						}
					}
				}
			}else {
				System.out.println("�Է°��� ������ Ȯ���ϼ���.");
				System.exit(0);
			}
			answer[k]=cnt;
			cnt=0;
			k++;
		}
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}
