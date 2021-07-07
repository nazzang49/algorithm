package test_181122;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//��ǥ�� Ȱ���� Ŭ����
class Pos {
	
	int x,y;
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//ü������ ����Ʈ�� �̵��� �� �ִ� ��ΰ� �־��� �� ���� ��ġ���� ���������� �̵��ϴ� ��ü ĭ�� ���ϱ�(BFS Ž��)
public class B_7562 {

	static int n;
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean [][] visited;
	static int [][] dp;
	//�̵��� �� �ִ� ������ 8ĭ
	static int [][] move = 
		{{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	static int x_des;
	static int y_des;
	
	//���� ���� Ž�� FROM ���� ��ġ
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.x==x_des&&p.y==y_des) {
				answer.add(dp[p.x][p.y]);
				break;
			}
			
			for(int i=0;i<8;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				
				//���� ������ ü������ ����� ������ ���
				if(nextx<0||nexty<0||nextx>=n||nexty>=n) {
					continue;
				}
				//���� ������ �湮���� ���� ������ ���
				if(!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					dp[nextx][nexty]=dp[p.x][p.y]+1;
					q.add(new Pos(nextx, nexty));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�׽�Ʈ ���̽� Ƚ��
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			n = sc.nextInt();
			if(4<=n&&n<=300) {
				visited = new boolean [n][n];
				dp = new int [n][n];
				//���� ��ġ
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				//������
				x_des = sc.nextInt();
				y_des = sc.nextInt();
				bfs(x1,y1);
			}
		}
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
}
