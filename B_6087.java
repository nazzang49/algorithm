package test_181204;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x, y, w;
	
	//��ǥ�� �̵� ���� ��Ÿ�� ���� ����
	public Pos(int x, int y, int w) {
		this.x=x;
		this.y=y;
		this.w=w;
	}
}

public class B_6087 {

	static char [][] map;
	static boolean [][] visited;
	//�ּҷ� �ʿ��� �ſ� ���� ����
	static int [][] dp;
	//���� ���� Ž��
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int r;
	static int c;
	static int x_des;
	static int y_des;
	
	//��=0, ��=1, ��=2, ��=3
	public static void bfs(int x, int y, int w) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y, w));
		
		while(!q.isEmpty()) {
			Pos p =  q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x+move[i][0];
				int ny = p.y+move[i][1];
				//���� ������ ���� ���̸�
				if(nx<0||ny<0||nx>=c||ny>=r) continue;
				
				//���� ���� = ���� ����(�̹� �湮�� ���¸� dp�� ��)
				if(map[nx][ny]=='C'&&visited[nx][ny]) {
					//���� ������(180��), �Ʒ� ���밪�� 0�Ǵ� 2
					if(Math.abs(move[p.w][0]-move[i][0])!=1) {
						dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]);	
					}
					//���� �ٸ���(90��), ���밪�� 1
					else {
						dp[nx][ny]=Math.min(dp[nx][ny], dp[p.x][p.y]+1);
					}
					x_des=nx;
					y_des=ny;
				}
				//���� ������ �湮���� ���� ���̸�(���� �׽�Ʈ)
				if(!visited[nx][ny]) {
					//���� ���� �ٷ� �����̸�
					if(p.w==4) {
						visited[nx][ny]=true;
						dp[nx][ny]=dp[p.x][p.y];
						q.add(new Pos(nx, ny, i));
						continue;
					}
					//�� ��ġ�� ����� ���� ���������� �̵� ������ ������(�ſ� ��ġ X)
					if(p.w==i) {
						dp[nx][ny]=dp[p.x][p.y];
						visited[nx][ny]=true;
						q.add(new Pos(nx, ny, i));
					}
					//���� �ٸ���(�ſ� ��ġ O)
					else {
						dp[nx][ny]=dp[p.x][p.y]+1;
						visited[nx][ny]=true;
						q.add(new Pos(nx, ny, i));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100) {
			map = new char[c][r];
			visited = new boolean[c][r];
			dp = new int[c][r];
			//�Է�
			for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=str.charAt(j);
					//���� �̸� �湮�� ������ ����
					if(map[i][j]=='*') {
						visited[i][j]=true;
					}
				}
			}
			//Ž��
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j]=='C') {
						visited[i][j]=true;
						bfs(i,j,4);
					}
				}
			}
			//���� ���� dp ���
			System.out.println(dp[x_des][y_des]);
		}
	}
}
