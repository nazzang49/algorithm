package test_181113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//�帶ö ������ ����� �ʴ� ���������� ����(������ ������ ���� ���������� �ִ� ����) ���ϱ�(bfs Ž��)
public class B_2468 {

	static int n;
	static int [][] map;
	static ArrayList<Integer> list;
	static int [] movex = {1,-1,0,0};
	static int [] movey = {0,0,-1,1};;
	static int cnt = 0;
	static boolean [][] visited;
	
	public static void bfs(int low, int x, int y) {
		
		//Ž�� ���� ���� ����
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			//���� �������� ���� Ž���� ����(��,��,��,��)
			boolean flag = false;
			for(int i=0;i<4;i++) {
				int nextx = p.x+movex[i];
				int nexty = p.y+movey[i];
				
				//���� ����� ������ Ž���� �ʿ� ����
				if(nextx<0||nexty<0||nextx>=n||nexty>=n) {
					continue;
				}
				//���� ���� + ����
				if(!visited[nextx][nexty]&&map[nextx][nexty]<=low) {
					continue;
				}
				//���� ���� + ����� �ʴ�
				if(!visited[nextx][nexty]&&map[nextx][nexty]>low) {
					visited[nextx][nexty]=true;
					flag=true;
					q.add(new Point(nextx, nexty));
				}
			}
			//�ϳ��� ������ �����Ǿ��� ��
			if(!flag) {
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		//�������� ���� ���� ����(���������� 1, �ְ������ map�� �ִ밪)
		int low = 1;
		int high = 0;
		visited = new boolean[n][n];
		list = new ArrayList<>(); 
		//���� ������ �� ����
		
		if(2<=n&&n<=100) {
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map.length;j++) {
					int tmp = sc.nextInt();
					if(1<=tmp&&tmp<=100) {
						map[i][j]=tmp;
						if(tmp>high) {
							high=tmp;
						}
					}
				}
			}
			
			//������ ������ �ϳ��� ���̸鼭 Ž�� �ݺ�
			while(low<=high) {
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map.length;j++) {
						if(!visited[i][j]&&map[i][j]>low) {
							bfs(low, i, j);
						}
					}
				}
				list.add(cnt);
				cnt=0;
				low++;
			}
			
			int [] answer = new int[list.size()];
			for(int i=0;i<answer.length;i++) {
				answer[i]=list.get(i);
			}
			Arrays.sort(answer);
			System.out.println(answer[answer.length-1]);
		}
	}
}
