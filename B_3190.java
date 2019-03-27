package test_190327;

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

//NxN ũ���� ���� ������ ������ ��Ģ�� ���� ���� ���̰� ����� ��, ������ ����Ǵ� �ð� ����ϱ�
public class B_3190 {

	static int [][] map;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int n;
	static char [] chDir;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		chDir = new char[101];
		int k = sc.nextInt();
		//��� ��ġ �Է�
		for(int i=0;i<k;i++) {
			map[sc.nextInt()][sc.nextInt()]=2;
		}
		int l = sc.nextInt();
		//���� ��ȯ �Է�
		for(int i=0;i<l;i++) {
			chDir[sc.nextInt()]=sc.next().charAt(0);
		}
		//���� ��ġ
		int x = 1;int y = 1;
		//���� ����(0��, 1��, 2��, 3��)
		int dir = 0;
		//��� �ð�
		int time = 0;
		Queue<Pos> q = new LinkedList<>();
		while(true) {
			//1) ���� ���� Ž��(�� or �ڱ� �ڽ����� Ȯ�� + ��� or ��ĭ���� Ȯ��)
			if(x<=0||y<=0||x>n||y>n||map[x][y]==1) {
				System.out.println(time);
				break;
			}
			if(map[x][y]!=2&&!q.isEmpty()) {
				Pos p = q.poll();
				map[p.x][p.y]=0;
			}
			map[x][y]=1;
			q.add(new Pos(x, y));
			//2) ��ǥ �̵�
			x+=dx[dir];
			y+=dy[dir];
			time++;
			//3) ���� ��ȯ
			if(chDir[time]=='D') dir++;
			if(chDir[time]=='L') dir--;
			if(dir<0) dir=3;
			if(dir>3) dir=0;
		}
	}
}
