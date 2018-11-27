package test_181127;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//�丶�並 ��� ���� ������ ���ڰ� ���� ��, ��� �丶�䰡 �� �ʹµ� �ɸ��� �ּ� �ϼ� ���ϱ�
//�ּ� �ϼ� or -1(�� ���� �� ���� ���) or 0(�̹� �� �;� �ִ� ���)
import java.util.Scanner;

class Loc {
	int x, y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class B_7576 {

	static int r;
	static int c;
	static int answer;
	static int [][] map;
	static boolean [][] visited;
	//�����¿� ���� ���� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [][] dp;
	static ArrayList<Loc> list = new ArrayList<>();
	
	//�� �̻� Ž���� ������ ����, ���� ������ ��� ���� ���(1)�� ����
	public static void bfs(ArrayList list) {
		Queue<Loc> q = new LinkedList<>();
		
		for(int i=0;i<list.size();i++) {
			q.add((Loc)list.get(i));
		}
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				//���� ������ ���� ���̶��
				if(nextx<0||nexty<0||nextx>=c||nexty>=r) {
					continue;
				}
				//���� ������ ���� ���� ���� �丶����
				if(map[nextx][nexty]==0&&!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Loc(nextx, nexty));
					//�� ��ġ + 1��
					dp[nextx][nexty]=dp[l.x][l.y]+1;
					map[nextx][nexty]=1;
				}
			}
			if(q.isEmpty()) {
				answer=dp[l.x][l.y];
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		if(2<=r&&r<=1000&&2<=c&&c<=1000) {
			map = new int[c][r];
			visited = new boolean[c][r];
			dp = new int[c][r];
			//�̹� ���� �丶��, �� ���� �丶��, ��� �ִ� ĭ�� ����
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
					//�̹� ���� �丶���̸�
					if(map[i][j]==1) {
						visited[i][j]=true;
						list.add(new Loc(i, j));
					}
				}
			}
			//�̹� ���� �丶���� �������� ���� Ž�� ����
			bfs(list);
			
			//Ž�� ���� �� ���� ���� ���� �丶�䰡 ���� ��� �Ǻ�
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j]==0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
