package test;

import java.util.LinkedList;
import java.util.Queue;
//BFS 탐색 적용
import java.util.Scanner;

//숨바꼭질 문제(BFS 탐색)
public class B_1697 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n,k=0;
		
		boolean [] visited = new boolean[1000001];
		int [] dist = new int[100001];
		
		n=Integer.parseInt(sc.next());
		k=Integer.parseInt(sc.next());

		//시작값부터 탐색
		if((0<=n&&n<=100000)&&(0<=k&&k<=100000)) {
			Queue<Integer> q = new LinkedList<>();
			q.add(n);
			
			//비어있지 않으면(즉, 탐색할 숫자가 있으면)
			while(!q.isEmpty()) {
				//현재 탐색값
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
