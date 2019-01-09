package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//���� ���� �׷����� �־����� ��, ���� ����� ������ ���ϴ� ���α׷� �ۼ��ϱ�
public class Q148 {

	//���� ���� ����
	static boolean [][] line;
	//���� �湮 ����
	static boolean [] visited;
	//���� ��� ����
	static int cnt = 0;
	
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=1;i<visited.length;i++) {
				if(!visited[i]&&line[tmp][i]) {
					visited[i]=true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=1000&&0<=m&&m<=n*(n-1)/2) {
			line = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			
			//���� ���� �Է�
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				line[tmp1][tmp2]=line[tmp2][tmp1]=true;
			}
			//Ž�� ����
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					cnt++;
					visited[i]=true;
					bfs(i);
				}
			}
			System.out.println(cnt);
		}
	}
}
