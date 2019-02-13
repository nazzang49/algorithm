package test_190213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Des{
	int next;
	int cost;
	
	public Des(int next, int cost) {
		this.next=next;
		this.cost=cost;
	}
}

//n개 도시 내 한 곳에서 다른 곳으로 이동 하는 버스의 비용이 m개 주어질 때, 출발점에서 도착점까지 이동할 수 있는 최소 비용 구하기 
public class B_1916 {

	static int n;
	static int m;
	static ArrayList<HashMap<Integer, Integer>> A = new ArrayList<>();
	static int [] dis;
	static final int INF = 100001;
	
	public static void dijkstra(int s, int e) {
		//초기값을 무한대로 설정
		Arrays.fill(dis, INF);
		//최소 비용이 적은 경로를 기준으로 우선순위 큐 정렬
		PriorityQueue<Des> pq = new PriorityQueue<>(new Comparator<Des>() {
			@Override
			public int compare(Des o1, Des o2) {
				if(o1.cost>o2.cost) return 1;
				else if(o1.cost==o2.cost) return 0;
				else return -1;
			}
		});
		dis[s]=0;
		pq.add(new Des(s, dis[s]));
		
		while(!pq.isEmpty()) {
			int cur = pq.peek().next;
			int curCost = pq.peek().cost;
			pq.poll();
			
			for(int i=0;i<A.get(cur).size();i++) {
				for(Map.Entry<Integer, Integer> entry : A.get(cur).entrySet()) {
					int next = entry.getKey();
					//다음 지점으로의 최소 이동 비용 = 현재까지의 최소 비용 + 현재 - 다음 지점 간 이동 비용
					int nextCost = curCost+entry.getValue();
					
					//최소값 갱신
					if(dis[next]>nextCost) {
						dis[next]=nextCost;
						pq.add(new Des(next, nextCost));
					}
				}
			}
		}
		System.out.println(dis[e]);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000&&m<=100000) {
			dis = new int[n+1];
			//노드별 인스턴스 생성
			for(int i=0;i<=n;i++) {
				A.add(new HashMap<>());
			}
			//버스 정보 입력
			for(int i=1;i<=m;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int cost = sc.nextInt();
				A.get(s).put(e, cost);
			}
			dijkstra(sc.nextInt(), sc.nextInt());
		}	
	}
}
