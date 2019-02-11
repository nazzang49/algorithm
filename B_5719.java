package test_190211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Destination {
	int next;
	int nextCost;
	
	public Destination(int next, int nextCost) {
		this.next=next;
		this.nextCost=nextCost;
	}
}

//출발 - 도착 노드가 입력될 때, 최소 비용 혹은 최단 거리로 이동하는 경로 외 그 다음 최소값을 가지는 거의 최단 경로 구하기(모든 경로 = 유일 경로)
public class B_5719 {

	//from 출발 to 모든 노드(최대값으로 초기화)
	static int [] dis;
	//이미 사용한 간선인지 저장할 배열
	static boolean [][] useLine;
	static int start;
	static int end;
	static ArrayList<HashMap<Integer, Integer>> connect = new ArrayList<>();
	//최초 최단 경로(1개 이상)를 삭제시키기 위한 경로 정보 저장 배열
	static ArrayList<Integer> [] trace;
	
	//최초 최단 경로를 삭제할 메소드(도착 -> 출발로 돌아가며 최단 경로 삭제)
	public static void traceback() {
		Queue<Integer> q = new LinkedList<>();
		q.add(end);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			//도착점부터 시작해서 연결된 노드들이 최단경로인지 확인
			for(int i=0;i<trace[cur].size();i++) {
				int pre = trace[cur].get(i);
				//최단 경로이면
				if(dis[cur]==dis[pre]+connect.get(pre).get(cur)) {
					q.add(pre);
					//pre -> cur로 가는 경로 삭제
					useLine[pre][cur]=true;
				}
			}
		}
	}
	
	//다익스트라 알고리즘 활용
	public static int dijkstra(int s) {
		//다음 이동할 지점 저장할 우선순위 큐 선언 및 정렬 방식 설정
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
			int curCost = pq.peek().nextCost;
			pq.poll();
			
			//지금 꺼낸 비용보다 더 작은 비용이면 건너 뜀
			if(curCost>dis[cur]) {
				continue;
			}
			
			for(Map.Entry<Integer, Integer> entry : connect.get(cur).entrySet()) {
				int next = entry.getKey();
				int nextCost = curCost+entry.getValue();
				
				//최소 비용이 갱신되는 경우 새롭게 해당 데이터 저장
				//<= 부등호 사용 이유 = 최단 경로가 1개 이상일 수 있기 때문
				if(nextCost<=dis[next]&&!useLine[cur][next]) {
					dis[next]=nextCost;
					pq.add(new Destination(next, nextCost));
					//다음 노드 - 현재 노드의 경로 연결 여부 저장
					trace[next].add(cur);
				}
			}
		}
		return dis[end]==Integer.MAX_VALUE ? -1:dis[end];
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> ans = new ArrayList<>();
		while(true) {
			//노드의 수
			int n = sc.nextInt();
			//간선의 수
			int m = sc.nextInt();
			
			if(n==0&&m==0) {
				break;
			}
			
			//출발 - 도착 노드 입력
			start = sc.nextInt();
			end = sc.nextInt();
			
			useLine = new boolean[n][n];
			trace = new ArrayList[n];
			dis = new int[n];
			for(int i=0;i<n;i++) {
				dis[i]=Integer.MAX_VALUE;
				trace[i]=new ArrayList<>();
			}
			
			connect.clear();
			for(int i=0;i<n;i++) {
				connect.add(new HashMap<>());
			}
			
			//간선 정보 입력
			for(int i=0;i<m;i++) {
				int cur = sc.nextInt();
				int next = sc.nextInt();
				int cost = sc.nextInt();
				
				connect.get(cur).put(next, cost);
			}
			
			dijkstra(start);
			traceback();
			//최단 거리 배열 초기화
			Arrays.fill(dis, Integer.MAX_VALUE);
			ans.add(dijkstra(start));
		}
		//각 테스트 케이스별 정답 출력
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
		sc.close();
	}
}
