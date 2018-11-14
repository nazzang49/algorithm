package test;

import java.util.LinkedList;
import java.util.Queue;
//BFS Ž�� ����
import java.util.Scanner;

//���ٲ��� ����(BFS Ž��)
public class B_1697 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n,k=0;
		
		boolean [] visited = new boolean[1000001];
		int [] dist = new int[100001];
		
		n=Integer.parseInt(sc.next());
		k=Integer.parseInt(sc.next());

		//���۰����� Ž��
		if((0<=n&&n<=100000)&&(0<=k&&k<=100000)) {
			Queue<Integer> q = new LinkedList<>();
			q.add(n);
			
			//������� ������(��, Ž���� ���ڰ� ������)
			while(!q.isEmpty()) {
				//���� Ž����
				n = q.poll();

				if(n==k) {
					System.out.println(dist[n]);
					break;
				}else {
					if(n-1>=0&&!visited[n-1]) {
						q.add(n-1);
						visited[n-1]=true;
						dist[n-1]=dist[n]+1;
					}
					if(n+1<=100000&&!visited[n+1]) {
						q.add(n+1);
						visited[n+1]=true;
						dist[n+1]=dist[n]+1;
					}
					if(n*2<=100000&&!visited[n*2]) {
						q.add(n*2);
						visited[n*2]=true;
						dist[n*2]=dist[n]+1;
					}
				}
			}
		}else{
			System.out.println("Try it again");
			System.exit(0);
		}
	}
}
