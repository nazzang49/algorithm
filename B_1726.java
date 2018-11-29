package test_181129;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.print.attribute.standard.PDLOverrideSupported;

class Pos {
	int x, y, w;
	//w�� �����̸� ������ �ν�(��1��2��3��4)
	public Pos(int x, int y, int w) {
		this.x=x;
		this.y=y;
		this.w=w;
	}
}

//�κ��� �̵��� ���� ����� ���� �̵�, ���� ��ȯ �ΰ����� �� �־��� �������� ���������� �̵��ϴ� �ּ� ��� Ƚ�� ���ϱ�
public class B_1726 {

	static int r;
	static int c;
	static int x_des;
	static int y_des;
	static int w_des;
	//���� �������� ��ĭ° �̵� ������ Ȯ���� ����(ù ���� �̵� ���� dp +1)
	static int cnt;
	static boolean [][] visited;
	//�̵� + ȸ�� ��� Ƚ�� ������ �迭
	static int [][] dp;
	//��������
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	//�ٸ� �������� �˵� ���� or ���� �̵� ���� �������� dp ����
	public static void bfs(int x, int y, int w) {
		Queue<Pos> q = new LinkedList<>();
		//���� ������ �ٶ� ���� ���� ����
		q.add(new Pos(x, y, w));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			//���� ��ġ�� ���� ���� and �ٶ󺸴� ���� ��ġ ��
			if(p.x==x_des-1&&p.y==y_des-1) {
				if(p.w==w_des) {
					System.out.println(dp[p.x][p.y]);
				}else if(Math.abs(move[p.w][0]-move[w_des][0])==1){
					System.out.println(dp[p.x][p.y]+1);
				}else if(Math.abs(move[p.w][0]-move[w_des][0])==2){
					System.out.println(dp[p.x][p.y]+2);
				}
				System.exit(0);
			}
			
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][1];
				int nexty = p.y+move[i][0];
				int dir = p.w;
				//���� ������ ���� ���̸�
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//ȸ�� Ƚ��
				int tmp = 0;
				if(dir!=i) {
					//90�� ȸ��
					if(Math.abs(move[dir][0]-move[i][0])==1) {
						tmp=1;
					}
					//180�� ȸ��
					else {
						tmp=2;
					}
				}
				//���� ������ �湮���� ���� �����̸�
				if(!visited[nextx][nexty]) {
					dp[p.x][p.y]+=tmp;
					if(tmp==0) {
						dp[nextx][nexty]=dp[p.x][p.y];
					}else {
						dp[nextx][nexty]=dp[p.x][p.y]+1;
					}
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty, i));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100) {
			dp = new int[r][c];
			visited = new boolean[r][c];
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					int tmp = sc.nextInt();
					//1�̸� �̸� �湮�� ������ ����(�̵��� �� ���� ����)
					if(tmp==1) {
						visited[i][j]=true;
					}
				}
			}
			//���� ���� ������ �ٶ󺸴� ����
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			x_des = sc.nextInt();
			y_des = sc.nextInt();
			w_des = sc.nextInt();
			visited[x-1][y-1]=true;
			bfs(x-1,y-1,w-1);
		}	
	}
}
