package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2���� �迭�� �� ��ġ�� ǥ���� Ŭ����
class Loc {
	int x, y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//���� ���� ������ Ư�� ������ ��Ʈ�� ��, ���۸����� �״� �ð��� ���� �ʰ� ���� �ִ� ���۸����� �� ���ϱ�
public class Q66 {

	static int r;
	static int c;
	static int [][] map;
	//���۸��� �����Ǵ� �ӵ�
	static int [][] dp;
	static int max = Integer.MIN_VALUE;
	static boolean [][] visited;
	//������ �����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}}; 
	
	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		//Ž���� ������ ���� ������
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = l.x+move[i][1];
				int ny = l.y+move[i][0];
				//���� Ž�� ������ ������ �����
				if(nx<0||ny<0||nx>=r||ny>=c) {
					continue;
				}
				//������ ������ ���۸��� ������
				if(!visited[nx][ny]&&map[nx][ny]==1) {
					visited[nx][ny]=true;
					map[nx][ny]=0;
					//�����Ǵ� �ӵ�
					dp[nx][ny]=dp[l.x][l.y]+1;
					//������ ���۸��� ������ ������ �ɸ��� �ð� ����
					if(dp[nx][ny]>=max) {
						max=dp[nx][ny];
					}
					q.add(new Loc(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		r = sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100) {
			map = new int[r][c];
			dp = new int[r][c];
			visited = new boolean[r][c];
			
			//0 Ȥ�� 1(���۸��� �ִ� ��ġ) �Է�
			for(int i=0;i<r;i++) {
				//�Է� �� �� ���ڸ� ���� �Է��ϴ� ���� �ƴ�, ������ ���ڿ��� �Է�
				String str = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			//������ ���ϵǴ� ����
			int x_des = sc.nextInt();
			int y_des = sc.nextInt();
			
			//BFS Ž�� ����
			bfs(y_des-1,x_des-1);
			//���� �ʰ� �����ִ� ���۸� ��
			int left = 0;
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(map[i][j]==1) {
						left++;
					}
				}
			}
			System.out.println(max+3);
			System.out.println(left);
		}
	}
}
