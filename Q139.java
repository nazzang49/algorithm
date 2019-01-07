package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�׷����� DFS �� BFS�� Ž���� ��� ����ϱ�
public class Q139 {

	static boolean [][] line;
	static boolean [] visited;
	static ArrayList<Integer> answer = new ArrayList<>();
	
	//���� �켱 Ž��(���)
	public static void dfs(int now) {
		for(int i=1;i<visited.length;i++) {
			//���� �湮���� �ʾҰ�, ����� �����̸�
			if(!visited[i]&&line[now][i]) {
				visited[i]=true;
				answer.add(i);
				dfs(i);
			}
		}
	}
	
	//�ʺ� �켱 Ž��(ť)
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=1;i<visited.length;i++) {
				//���� �湮���� �ʾҰ�, ����� �����̸�
				if(!visited[i]&&line[tmp][i]) {
					visited[i]=true;
					q.add(i);
					answer.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//����� ��(1������ n������ ����)
		int n = sc.nextInt();
		//�־����� ���� ������ ����
		int m = sc.nextInt();
		//Ž�� �����ϴ� ���
		int v = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=m&&m<=10000) {
			line = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			
			//���� ���� ����
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				//true(��� �� ����Ǿ� ����)
				line[tmp1][tmp2]=line[tmp2][tmp1]=true;
			}
			
			visited[v]=true;
			answer.add(v);
			//BFS Ž��
			bfs(v);
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
			
			System.out.println();
			
			answer.clear();
			visited = new boolean[n+1];
			visited[v]=true;
			answer.add(v);
			//BFS Ž��
			dfs(v);
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
		}
	}
}
