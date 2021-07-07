package test_181124;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//����� ��, ��Ÿ���� �־��� �� ���翡�� Ż���� �� �ִ� ���� ���� �����ִ� ������ �� ���ϱ�
//���� �������� ���� �� > ������ ���� ��, ���� ��� ����

class Location {
	int x,y;
	
	public Location(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class B_3184 {

	static int r;
	static int c;
	//������ ������ ���� ��
	static int cnt1;
	//������ ������ ���� ��
	static int cnt2;
	static char [][] map;
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	static int answer1 = 0;
	static int answer2 = 0;
	
	public static void bfs(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(x, y));
		
		while(!q.isEmpty()) {
			Location l = q.poll();
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				
				//���� ���̸� Ž�� �Ұ�
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//���� ������ ���̸�
				if(!visited[nextx][nexty]&&map[nextx][nexty]=='o') {
					cnt1++;
				}
				//���� ������ �����
				if(!visited[nextx][nexty]&&map[nextx][nexty]=='v') {
					cnt2++;
				}
				//���� ������ �湮 ���� ���̸�
				if(!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Location(nextx, nexty));	
				}
			}
			//�� �̻� Ž���� ������ ������ = �ϳ��� ������ �����Ǹ�
			if(q.isEmpty()) {
				//�ش� �������� ���� ���� ������ ������ ������(�� ����)
				if(cnt1>cnt2) {
					cnt2=0;
					answer1+=cnt1;
					cnt1=0;
				}
				//�ش� �������� ������ ���� ���� ���� ���ų� ������(���� ����)
				else {
					cnt1=0;
					answer2+=cnt2;
					cnt2=0;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(3<=r&&r<=250&&3<=c&&c<=250) {
			map = new char [r][c];
			visited = new boolean [r][c];
			for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=str.charAt(j);
					//��Ÿ���δ� �̵��� �� ������ ���� ��ġ
					if(str.charAt(j)=='#') {
						visited[i][j]=true;
					}
				}
			}
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					//���̸�
					if(!visited[i][j]&&map[i][j]=='o') {
						visited[i][j]=true;
						cnt1++;
						bfs(i,j);
					}
					//�����
					else if(!visited[i][j]&&map[i][j]=='v') {
						visited[i][j]=true;
						cnt2++;
						bfs(i,j);
					} 
				}
			}
			//��� ������ ���� �ִ� ���� ��
			System.out.println(answer1);
			System.out.println(answer2);
		}
	}
}
