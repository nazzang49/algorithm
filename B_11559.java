package test_181129;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int x, y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//��Ʈ���� ����(���� ������ ���� ��� ��ġ�� �־��� �� ���� ȹ�� Ƚ�� ���ϱ�)
public class B_11559 {

	//Ƚ�� ����
	static int cnt;
	static char [][] map;
	//�����¿� Ž�� ����
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	//�μ��� �ѿ� ��ǥ ������ �����迭(4�� �̻��̸� �ѹ��̶� �μ����� ��)
	static ArrayList<Loc> point = new ArrayList<>();
	//�ʱⰪ ����
	static boolean chk = false;

	//�� ���� �� �� ���� �� �ش� �� -> �� �������� ��ƴ��� �޼ҵ�(�� ������ Ž��)
	public static void gravity() {
		int t=11;
		Queue<Character> q = new LinkedList<>();
		for(int j=0;j<6;j++) {
			for(int i=11;i>=0;i--) {
				if(map[i][j]!='.') {
					q.add(map[i][j]);
					//��ƴ���� �κ��� �� �������� ����
					map[i][j]='.';
				}
			}
			t=11;
			while(!q.isEmpty()) {
				char a = q.poll();
				map[t--][j]=a;
			}
		}
	}
	
	//�μ����� ���� -> �� �������� �ٲٴ� �޼ҵ�
	public static boolean flag(ArrayList<Loc> list) {
		if(list.size()>=4) {
			for(int i=0;i<list.size();i++) {
				Loc l = list.get(i);
				map[l.x][l.y]='.';
			}
			point.clear();
			return true;
		}else {
			//�μ����� ������ ������ false ��ȯ
			point.clear();
			return false;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			//x�� ��, y�� ��
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				//���� ������ ���� ���̸�
				if(nextx<0||nexty<0||nextx>=12||nexty>=6) {
					continue;
				}
				if(!visited[nextx][nexty]) {
					//���� ������ ���� ����� ���ٸ�(�� 5���� ����)
					if(map[nextx][nexty]==map[l.x][l.y]) {
						point.add(new Loc(nextx, nexty));
						visited[nextx][nexty]=true;
						q.add(new Loc(nextx, nexty));
					}
				}
			}
			//�ϳ��� ������ �����Ǹ�
			if(q.isEmpty()) {
				if(!chk) {
					chk=flag(point);
				}else {
					flag(point);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		visited = new boolean[12][6];
		
		for(int i=0;i<12;i++) {
			String str = sc.next();
			for(int j=0;j<6;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		while(true) {
			//���� �Ʒ������� Ž��(�Ʒ��� ��ƴ�ܾ� �ϹǷ�
			for(int i=11;i>=0;i--) {
				for(int j=0;j<6;j++) {
					//���� �湮���� �ʾҰ� �� ������ �ƴ� ���
					if(!visited[i][j]&&map[i][j]!='.') {
						visited[i][j]=true;
						point.add(new Loc(i, j));
						bfs(i,j);
					}
				}
			}
			//�ѿ� ������ �ѹ��̶� �μ�����
			if(chk) {
				//Ƚ�� ����
				cnt++;
				//�μ��� ������ ���� ���� ��ƴ��� ����
				gravity();
			}else {
				System.out.println(cnt);
				System.exit(0);
			}
			//Ž�� ���� �迭 �� �μ��� �ѿ� ��ǥ �迭 �ʱ�ȭ
			visited = new boolean[12][6];
			point = new ArrayList<>();
			chk = false;
		}
	}
}
