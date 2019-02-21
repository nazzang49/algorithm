package test_190221;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pos {
	int next;
	int nextCost;
	
	public Pos(int next, int nextCost) {
		this.next=next;
		this.nextCost=nextCost;
	}
}

//n개 마을에 n명의 학생이 한명씩 살고 있을 때, x번 마을에 파티를 하러 갔다가 다시 마을로 돌아오는 경로 중 소요 시간이 가장 많이 걸리는 학생 구하기
public class B_1238 {

	//마을 갯수(1번~)
	static int n;
	//간선 갯수
	static int m;
	//파티 장소
	static int x;
	//간선 정보
	static ArrayList<Pos> [] A;
	static int [] d;
	
	public static int dijkstra(int s, int e) {
		//최단거리 배열 초기화
		d = new int[n+1];
		Arrays.fill(d, 10001);
		//시작점은 0
		d[s]=0;
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				return o1.nextCost-o2.nextCost;
			}
		});
		pq.add(new Pos(s, d[s]));
		while(!pq.isEmpty()) {
			int cur = pq.peek().next;
			int curCost = pq.peek().nextCost;
			pq.poll();
			
			//현재 지점이 이미 최단경로이면
			if(d[cur]<curCost) continue;
			
			for(int i=0;i<A[cur].size();i++) {
				int next = A[cur].get(i).next;
				int nextCost = curCost+A[cur].get(i).nextCost;
				
				if(d[next]>nextCost) {
					d[next]=nextCost;
					pq.add(new Pos(next, nextCost));
				}
			}
		}
		return d[e];
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		
		if(n<=1000&&m<=10000&&x<=n) {
			A = new ArrayList[n+1];
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			//간선 정보 입력
			for(int i=0;i<m;i++) {
				A[sc.nextInt()].add(new Pos(sc.nextInt(), sc.nextInt()));
			}
			int max = Integer.MIN_VALUE;
			//다익스트라 알고리즘 실행
			for(int i=1;i<=n;i++) {
				if(max<dijkstra(i, x)+dijkstra(x, i)) {
					max = dijkstra(i, x)+dijkstra(x, i);
				}
			}
			System.out.println(max);
		}	
	}
}
