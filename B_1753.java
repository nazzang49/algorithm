package test_190213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Destination {
	int next;
	int nextCost;
	
	public Destination(int next, int nextCost) {
		this.next=next;
		this.nextCost=nextCost;
	}
}

//방향그래프가 주어지면, 시작점에서 다른 모든 정점으로 이동하는 최단 거리 출력하기
public class B_1753 {

	//정점의 갯수
	static int v;
	//간선의 갯수
	static int e;
	//특정 노드 간 연결 여부 저장할 배열
	static ArrayList<HashMap<Integer, Integer>> A;
	//시작점에서 모든 정점까지의 최단 거리 저장할 배열
	static int [] dis;
	
	public static void dijkstra(int s) {
		//dis 배열 초기화(무한값)
		Arrays.fill(dis, 100001);
		//더 작은 비용에 해당하는 경로가 우선 정렬되도록 pq 선언
		PriorityQueue<Destination> pq = new PriorityQueue<>(new Comparator<Destination>() {
			@Override
			public int compare(Destination o1, Destination o2) {
				if(o1.nextCost>o2.nextCost) return 1;
				else if(o1.nextCost<o2.nextCost) return -1;
				else return 0;
			}
		});
		dis[s]=0;
		pq.add(new Destination(s, dis[s]));
		
		while(!pq.isEmpty()) {
			//현재 노드
			int cur = pq.peek().next;
			//현재 노드로 이동하는데 드는 비용
			int curCost = pq.peek().nextCost;
			pq.poll();
			
			//이미 더 작은 비용이 저장되어 있으면 실행 X
			if(curCost>dis[cur]) {
				continue;
			}
			
			//현재 노드와 이어진 모든 노드 탐색
			for(int i=0;i<A.get(cur).size();i++) {
				for(Map.Entry<Integer, Integer> entry : A.get(cur).entrySet()) {
					int next = entry.getKey();
					int nextCost = curCost+entry.getValue();
					
					if(nextCost<dis[next]) {
						dis[next]=nextCost;
						pq.add(new Destination(next, dis[next]));
					}
				}
			}
		}
		//정답 출력
		for(int i=1;i<=v;i++) {
			if(dis[i]==100001) System.out.println("INF");
			else System.out.println(dis[i]);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		if(v<=20000&&e<=300000) {
			dis = new int[v+1];
			A = new ArrayList<>();
			//시작 정점
			int start = sc.nextInt();
			
			//간선 정보 입력
			for(int i=0;i<=v;i++) A.add(new HashMap<Integer, Integer>());
			for(int i=1;i<=e;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int cost = sc.nextInt();
				A.get(s).put(e, cost);
			}
			//탐색 시작
			dijkstra(start);
		}	
	}
}
