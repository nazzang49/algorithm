package test_181123;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	
	int x, y, w;
	
	public Loc(int x, int y, int w) {
		this.x=x;
		this.y=y;
		this.w=w;
	}
}

//�źи��� �������� ���� �������� ������ ������ �� ����ġ�� ģ���� ����� �ұ���  Ż���ϴµ� �ɸ��� �ð� ���ϱ�(BFS Ž��)
public class B_3055 {

	static char [][] map;
	//�����¿� �̵� ����(����ġ �� ��)
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1},
			{1,-1},{1,1},{-1,-1},{-1,1}};
	static boolean [][] visited;
	static int [][] dp;
	//����� �ұ��� �̵��ϴµ� �ɸ��� �ð�(��ĭ �̵��� +1)
	static int cnt;
	//���� ����
	static int x_des;
	static int y_des;
	//����ġ�� ���� ���� ������ ��� �ִ� �迭
	static ArrayList<Loc> pos = new ArrayList<>();
	static int r;
	static int c;
	
	public static void bfs(ArrayList pos) {
		Queue<Loc> q = new LinkedList<>();
		for(int i=0;i<pos.size();i++) {
			q.add((Loc)pos.get(i));
		}
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			//����ġ�� �̵��̸�
			boolean flag = false;
			if(l.w==0) {
				flag = true;
			}
			
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				int w = l.w;
				
				//���� ������ ���� ���� ���
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//����ġ�� �̵������ ���
				if(w==0) {
					//���� ���� �ʾҰ�, ������ �ƴϰ�, �湮�� ������ �ƴ� ���
					//�̵� ĭ�� ����+1
					if(!visited[nextx][nexty]) {
						System.out.println(nextx+","+nexty);
						q.add(new Loc(nextx, nexty, w));
						visited[nextx][nexty]=true;
						dp[nextx][nexty]=dp[l.x][l.y]+1;
						flag = false;
						if(nextx==x_des&&nexty==y_des) {
							System.out.println(dp[nextx][nexty]);
							System.exit(0);
						}
					}
				}
				//���� �̵������ ���
				else {
					if(!visited[nextx][nexty]&&map[nextx][nexty]!='D') {
						q.add(new Loc(nextx, nexty, w));
						visited[nextx][nexty]=true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();

		if(1<=r&&r<=50&&1<=c&&c<=50) {
			map = new char[r][c];
			visited = new boolean [r][c];
			dp = new int [r][c];
			int tmp1 = 0;
			int tmp2 = 0;
			//���� �� ����, ���� �ִ� ����, �����, ������ �Է�
			for(int i=0;i<r;i++) {
				String str = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j);
					if(str.charAt(j)=='S') {
						//����ġ�� ���� ����
						tmp1 = i;
						tmp2 = j;
						visited[i][j]=true;
					}
					if(str.charAt(j)=='*') {
						//���� ���� ����
						visited[i][j]=true;
						pos.add(new Loc(i, j, 1));
					}
					if(str.charAt(j)=='X') {
						//�����̸� Ž�� �Ұ�
						visited[i][j]=true;
					}
					if(str.charAt(j)=='D') {
						//���� ���� ����
						x_des = i;
						y_des = j;
					}
				}
			}
			//���� ������ ���� ������ Ž�� �������� ����
			pos.add(new Loc(tmp1, tmp2, 0));
			//Ž�� ����
			bfs(pos);
			System.out.println("KAKTUS");
		}
	}
}
