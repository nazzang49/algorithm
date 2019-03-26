package test_190325;

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

//���̷����� ��ĭ, ���� ��ġ�� �־��� ��, �� 3���� ���� ���� �� �ִ� ���� ������ �ִ� ĭ �� ���ϱ�(��Ʈ��ŷ + BFS)
public class B_14502 {

	static int n;
	static int m;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int [][] map;
	static int [][] copy;
	static int finalCnt = 0;
	
	public static void cloneMap() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j]=map[i][j];
			}
		}
	}
	
	//������ ���� ������ ���� Ž�� ����
	public static void bfs(int num) {
		if(num==3) {
			int cnt = 0;
			cloneMap();
			Queue<Loc> q = new LinkedList<>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					//���̷�����
					if(copy[i][j]==2) {
						q.add(new Loc(i, j));
					}
				}
			}
			while(!q.isEmpty()) {
				Loc l = q.poll();
				
				for(int i=0;i<4;i++) {
					int nx = l.x+dx[i];
					int ny = l.y+dy[i];
					
					//���� ���� = ���� ��
					if(nx<0||ny<0||nx>=n||ny>=m) continue;
					
					//���� ���� = ��ĭ and �̹湮
					if(copy[nx][ny]==0) {
						//���̷��� ����
						copy[nx][ny]=2;
						q.add(new Loc(nx, ny));
					}
				}
			}
			//���� ���� ����
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(copy[i][j]==0) cnt++;
				}
			}
			finalCnt = Math.max(finalCnt, cnt);
			return;
		}
		//Ž��
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//���̸�
				if(map[i][j]==0) {
					map[i][j]=1;
					bfs(num+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=8&&m<=8) {
			map = new int[n][m];
			copy = new int[n][m];
			//���� ��Ȳ ���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=copy[i][j]=sc.nextInt();
				}
			}
			//Ž��
			bfs(0);
			System.out.println(finalCnt);
		}	
	}
}
