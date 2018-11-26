package test_181126;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int x,y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//���簢�� ������ �����̿� 1X1 ũ���� ���� ���Ƿ� ĥ�� ��, ��ĥ�� ���� �� �����Ǵ� ���� ���� ���ϱ�
public class B_2583 {

	static int r;
	static int c;
	//��ĥ�� ���� ǥ���� ��ǥ
	static int k;
	static boolean [][] visited;
	//�����¿� �̵� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	//��ĥ ���� ���� ���� ����
	static int cnt;
	//��ĥ ���� ���� ������ ����
	static int area;
	static ArrayList<Integer> answer = new ArrayList<>();

	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				
				//���� ������ ���� ���� ���
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//���� ������ �湮���� ���� ����, �� ��ĥ ���� ���� �����̸�
				if(!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Loc(nextx, nexty));
					//���� 1�߰�
					area++;
				}
			}
			if(q.isEmpty()) {
				cnt++;
				answer.add(area);
				area=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100&&1<=k&&k<=100) {
			visited = new boolean[r][c];
			
			for(int i=0;i<k;i++) {
				//���� ĥ������ ���� ����
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				//��ĥ�� �κ��� true�� ����
				for(int j=y1;j<=y2-1;j++) {
					for(int m=x1;m<=x2-1;m++) {
						visited[j][m]=true;
					}
				}
			}
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(!visited[i][j]) {
						visited[i][j]=true;
						area++;
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
			//�������� ����
			for(int i=0;i<answer.size()-1;i++) {
				for(int j=i+1;j<answer.size();j++) {
					if(answer.get(i)>answer.get(j)) {
						int tmp = answer.get(j);
						answer.set(j, answer.get(i));
						answer.set(i, tmp);
					}	
				}
			}
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
		}
	}
}
