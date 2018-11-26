package test_181126;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//����ġ ���� ���� �׷����� �־��� ��, ��� ���� i���� j�� ���� ����� ���� ���� ���ϱ�
public class B_11403 {

	//��� �� ���� ���� ����� ���� �迭
	static int [][] map;
	static int [][] answer;
	static boolean [] visited;
	static int n;
	//Ž�� ���� ������ ���� ��ġ ����
	static int k;
	
	//����ġ ��� ���� �������� Ž�� ����
	public static void bfs(int [][] map) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			q.add(i);
			Arrays.fill(visited, false);
			while(!q.isEmpty()) {
				int s = q.poll();
				for(int j=0;j<n;j++) {
					if(map[s][j]==1&&!visited[j]) {
						visited[j]=true;
						answer[i][j]=1;
						q.add(j);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			map = new int[n][n];
			answer = new int[n][n];
			visited = new boolean[n];
			
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//Ž�� ����
			bfs(map);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(answer[i][j]+" ");
				}
				System.out.println();
			}
		}	
	}
}
