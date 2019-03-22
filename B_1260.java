package test_190322;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS, BFS�� ������ ��� ����ϱ�
public class B_1260 {

	static int n;
	static int m;
	static boolean [][] line;
	static boolean [] v;
	
	//���� �켱 Ž��
	public static void dfs(int now) {
		System.out.print(now+" ");
		for(int i=1;i<=n;i++) {
			//���� �湮���� �ʾҰ�, ���� ������ ����� �����̸�
			if(!v[i]&&line[now][i]) {
				v[i]=true;
				dfs(i);
			}
		}
	}
	
	//���� �켱 Ž��
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		v[now]=true;
		q.add(now);
	
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur+" ");
			for(int i=1;i<=n;i++) {
				//���� �湮���� �ʾҰ�, ���� ������ ����� �����̸�
				if(!v[i]&&line[cur][i]) {
					v[i]=true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int start = sc.nextInt();
		
		if(n<=1000&&m<=10000) {
			v = new boolean[n+1];
			line = new boolean[n+1][n+1];
			
			//���� ���� �Է�(����� ����)
			for(int i=0;i<m;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				line[s][e]=line[e][s]=true;
			}
			
			//Ž�� �� ���
			v[start]=true;
			dfs(start);
			Arrays.fill(v, false);
			System.out.println();
			bfs(start);
		}	
	}
}
