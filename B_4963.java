package test_190208;

import java.util.ArrayList;
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

//���簢������ �̷���� ���� �ٴ� ������ �־��� ��, ���� ���� ���ϱ�
public class B_4963 {

	static int n;
	static int m;
	//��, ��, �밢�� �� 8�� ���� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	static int [][] map;
	static boolean [][] visited;
	static int cnt = 0;
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0;i<8;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				
				//���� ���� = ���� ��
				if(nx<0||ny<0||nx>=m||ny>=n) continue;
				
				//���� ���� = �湮���� ���� ����
				if(!visited[nx][ny]&&map[nx][ny]==1) {
					visited[nx][ny]=true;
					q.add(new Pos(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			if(n==0&&m==0) {
				break;
			}
			
			if(n<=50&&m<=50) {
				map = new int[m][n];
				visited = new boolean[m][n];
				
				//����(1) �ٴ�(0) �Է�
				for(int i=0;i<m;i++) {
					for(int j=0;j<n;j++) {
						map[i][j]=sc.nextInt();
					}
				}
				
				//BFS Ž��
				for(int i=0;i<m;i++) {
					for(int j=0;j<n;j++) {
						//���� ���� ��
						if(!visited[i][j]&&map[i][j]==1) {
							bfs(i,j);
							cnt++;
						}
					}
				}
				
			}
			ans.add(cnt);
			cnt=0;
		}
		//���� ���
		for(int i=0;i<ans.size();i++) System.out.println(ans.get(i));
	}
}
