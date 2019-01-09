package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//����ġ ���� ���� �׷��� nxn ����� �־��� ��, ���� ������ �ľ��Ͽ� ���� �� ���� ���θ� ��ķ� ����ϱ�
public class Q146 {

	static int [][] answer;
	static int [][] line;
	static boolean [] visited;
	
	//now���� des���� �̵� ��ΰ� �ִ��� üũ
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=0;i<answer.length;i++) {
				//�ڱ� �ڽſ��� ���� ���� ����
				if(tmp==i) {
					continue;
				}
				//���� �湮���� �ʾҰ�, ���� ������ ����� �����̶��
				if(line[tmp][i]==1&&!visited[i]) {
					visited[i]=true;
					answer[now][i]=1;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			line = new int[n][n];
			answer = new int[n][n];
			visited = new boolean[n];
			
			//���� ���� ���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//1(���� O) 0(���� X)
					line[i][j]=sc.nextInt();
				}
			}
			//Ž�� ����(i���� j�� ���� ��ΰ� �ִ���)
			for(int i=0;i<n;i++) {
				bfs(i);
				visited = new boolean[n];
			}
			//���� ���
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(answer[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
