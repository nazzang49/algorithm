package test_181121;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	
	int x,y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//�ٴٿ� �ѷ� �׿��ִ� ���� ���ǿ� ���� ���� ���� ���ϱ�(BFS Ž��)
public class B_4963 {

	static int n;
	static int m;
	static int [][] map;
	static boolean [][] visited;
	//�� �׽�Ʈ ���̽��� ���� ����(���̽����� �ʱ�ȭ �ʼ�)
	static int cnt;
	//����, ����, �밢�� �̵�
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1},
			{1,1},{1,-1},{-1,1},{-1,-1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		//Ž�� ������ ������ ������ Ž�� �ݺ�
		while(!q.isEmpty()) {
			Pos p = q.poll();
			//���� ������ ��� �ٴٰ� �Ǵ� ������ �Ǹ��� �÷��� ����(cnt++)
			boolean flag = false;
			
			//�ش� ������ ���ΰ� �ִ� ���� ���� 8���� Ž��
			for(int i=0;i<8;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				
				//���� ���� ������ Ž�� �Ұ�
				if(nextx<0||nexty<0||nextx>=m||nexty>=n) {
					continue;
				}
				//���� ������ 0(�ٴ�)�� ���
				if(map[nextx][nexty]==0) {
					continue;
				}
				//���� �� ���� ���� ������ 1(��)�̰� �湮���� ���� ������ ���
				if(map[nextx][nexty]==1&&!visited[nextx][nexty]&&i<4) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
					flag = true;
				}
				//�밢�� ���� ������ 1(��)�̰� �湮���� ���� ������ ���
				if(map[nextx][nexty]==1&&!visited[nextx][nexty]&&!flag&&i>=4) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
					flag = true;
				}
			}
			if(!flag&&q.isEmpty()) {
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			//�� ���� ��� 0�̸� �Է� ����
			if(n==0&&m==0) {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i));
				}
				break;
			}
			if(1<=n&&n<=50&&1<=m&&m<=50) {
				map = new int [m][n];
				visited = new boolean [m][n];
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//1�� ��, 0�� �ٴ�
						map[i][j]=sc.nextInt();
					}
				}
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//�湮�� ���� �ƴϰ� ���� ��� Ž�� ����
						if(!visited[i][j]&&map[i][j]==1) {
							visited[i][j]=true;
							bfs(i,j);
						}
					}
				}
				answer.add(cnt);
				cnt=0;
			}
		}
	}
}
