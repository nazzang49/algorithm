package test_181130;

import java.util.HashMap;
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

//���� ���� ������ ���� �������� �������� ���� ������ �� ��ü ���� ����, ���� ū ���� ũ��, �ϳ��� ���� ������ �� ������ �� �ִ� ���� ���� ���� ũ�� ���ϱ�
public class B_2234 {

	static int r;
	static int c;
	//������ ���� �迭(�̵� ������ ����)
	static String [][] map;
	//�渶�� ��ȣ ������ �迭
	static int [][] room;
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	//���� ����
	static int cnt;
	//���� ����
	static int area;
	//�ִ� ���� ũ�⸦ ���� ���� �迭
	static HashMap<Integer,Integer> answer = new HashMap<>();
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0;i<4;i++) {
				//�̵� ������ ��츸 ����(���� ���� ���� �ʰ� ���� �湮���� ����)
				if(map[p.x][p.y].charAt(i)=='0') {
					//�����̵�
					if(i==0&&!visited[p.x+1][p.y]) {
						visited[p.x+1][p.y]=true;
						q.add(new Pos(p.x+1, p.y));
						room[p.x+1][p.y]=cnt;
						area++;
					}
					//�����̵�
					if(i==1&&!visited[p.x][p.y+1]) {
						visited[p.x][p.y+1]=true;
						q.add(new Pos(p.x, p.y+1));
						room[p.x][p.y+1]=cnt;
						area++;
					}
					//�����̵�
					if(i==2&&!visited[p.x-1][p.y]) {
						visited[p.x-1][p.y]=true;
						q.add(new Pos(p.x-1, p.y));
						room[p.x-1][p.y]=cnt;
						area++;
					}
					//�����̵�
					if(i==3&&!visited[p.x][p.y-1]) {
						visited[p.x][p.y-1]=true;
						q.add(new Pos(p.x, p.y-1));
						room[p.x][p.y-1]=cnt;
						area++;
					}
				}
			}
			//�ϳ��� ���� �����Ǹ�
			if(q.isEmpty()) {
				//�� ��ȣ �� ũ�� ����
				answer.put(cnt, area);
				//�� ��ȣ ����
				cnt++;
				//�� ũ�� �ʱ�ȭ
				area=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		if(1<=r&&r<=50&&1<=r&&r<=50) {
			map = new String[c][r];
			visited = new boolean[c][r];
			room = new int[c][r];
			
			for(int i=0;i<c;i++) {
				for(int j=0;j<r;j++) {
					int tmp = sc.nextInt();
					//2������ �����Ͽ� ����
					//4�ڸ� ���°� �ƴϸ�
					String str=Integer.toBinaryString(tmp);
					if(4-str.length()==1) {
						str="0"+str;
					}else if(4-str.length()==2) {
						str="00"+str;
					}else if(4-str.length()==3) {
						str="000"+str;
					}
					map[i][j]=str;
				}
			}
			for(int i=0;i<c;i++) {
				for(int j=0;j<r;j++) {
					//�湮���� ���� ���̸�
					if(!visited[i][j]) {
						room[i][j]=cnt;
						bfs(i,j);
					}
				}
			}
			//���� ����
			System.out.println(cnt);
			//�ִ� ���� ũ�� (�������� ����)
			int max = 0;
			for(int i=0;i<answer.size();i++) {
				if(max<answer.get(i)) {
					max=answer.get(i);
				}
			}
			System.out.println(max);
			max=0;
			//���� �ϳ� ���� �� ���� ������ �ִ� ���� ũ��
			for(int i=0;i<c;i++) {
				for(int j=0;j<r;j++) {
					for(int m=0;m<4;m++) {
						int nextx = i+move[m][1];
						int nexty = j+move[m][0];
						
						if(nextx<0||nexty<0||nextx>=c||nexty>=r) {
							continue;
						}
						//�� ��ȣ�� �ٸ� ������ �����ϸ�(�� ������ �� ���ϱ�)
						if(room[i][j]!=room[nextx][nexty]) {
							if(max<answer.get(room[i][j])+answer.get(room[nextx][nexty])) {
								max=answer.get(room[i][j])+answer.get(room[nextx][nexty]);
							}
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
