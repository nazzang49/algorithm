package test_190325;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//���� ���� �׷����� �־����� ��, ���� ����� ���� ���ϱ�
public class B_11724 {

	//���� ����
	static int n;
	//���� ����
	static int m;
	//���� ����
	static boolean [][] line;
	//�湮 ����
	static boolean [] v;
	//���� ��� ����
	static int cnt = 0;
	
	public static  void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1;i<=n;i++) {
				if(!v[i]&&line[now][i]) {
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
		
		if(n<=1000&&m<=n*(n-1)/2) {
			line = new boolean[n+1][n+1];
			v = new boolean[n+1];
			
			//���� ���� �Է�
			for(int i=0;i<m;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				line[u][v]=line[v][u]=true;
			}
			
			//BFS Ž��
			for(int i=1;i<=n;i++) {
				if(!v[i]) {
					v[i]=true;
					cnt++;
					bfs(i);
				}
			}
			System.out.println(cnt);
		}	
	}
}
