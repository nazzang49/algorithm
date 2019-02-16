package test_190216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Des {
	int next;
	int nextCost;
	
	public Des(int next, int nextCost) {
		this.next=next;
		this.nextCost=nextCost;
	}
}

//시작점 - 도착점까지의 최단 경로를 제외한 차순위 최단 경로 구하기
//1차 탐색에서 최단 경로를 확보하고, 해당 최단 경로를 삭제한 다음, 2차 탐색 실행
public class B_5719 {

	//정점 갯수
	static int n;
	//간선 갯수
	static int m;
	//간선 정보
	static ArrayList<HashMap<Integer, Integer>> A = new ArrayList<>();
	//최단 경로
	static int [] d;
	//간선 사용 여부(삭제 작업 시 사용)
	static boolean [][] line;
	static ArrayList<Integer> [] trace;
	
	//도착 -> 출발 이동하며, 최단 경로인지 확인(맞으면 간선 삭제)
	public static void traceback(int e) {
		Queue<Integer> q = new LinkedList<>();
		q.add(e);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0;i<trace[x].size();i++) {
				int pre = trace[x].get(i);
				//연결되어 있고, 최단경로이면
				if(d[pre]+A.get(pre).get(x)==d[x]) {
					line[pre][x]=false;
					q.add(pre);
				}
			}
		}
	}
	
	public static void dijkstra(int s, int e) {
		d = new int[n+1];
		Arrays.fill(d, 100001);
		
		d[s]=0;
		PriorityQueue<Des> pq = new PriorityQueue<>(new Comparator<Des>() {
			@Override
			public int compare(Des o1, Des o2) {
				if(o1.nextCost>o2.nextCost) return 1;
				else if(o1.nextCost>o2.nextCost) return -1;
				else return 0;
			}
		});
		pq.add(new Des(s, d[s]));
		
		while(!pq.isEmpty()) {
			int cur = pq.peek().next;
			int curCost = pq.peek().nextCost;
			pq.poll();
			
			if(d[cur]<curCost) continue;
			
			for(Map.Entry<Integer, Integer> entry : A.get(cur).entrySet()) {
				int next = entry.getKey();
				int nextCost = curCost+entry.getValue();
				
				//다음 정점으로 이동 시, 해당 간선을 통해 이동할 수 있는 경우만 탐색
				if(d[next]>=nextCost&&line[cur][next]) {
					d[next]=nextCost;
					pq.add(new Des(next, nextCost));
					//간선 삭제 작업을 위한 처리(다음 지점 -> 현재 지점 연결)
					trace[next].add(cur);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> ans = new ArrayList<>();
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			if(n==0&&m==0) break;
			
			if(n<=500&&m<=Math.pow(10, 4)) {
				line = new boolean[n][n];
				trace = new ArrayList[n];
				
				for(int i=0;i<n;i++) {
					trace[i]=new ArrayList<>();
				}
				
				A.clear();
				for(int i=0;i<=n;i++) {
					A.add(new HashMap<>());
				}
				
				//출발 및 도착 정점
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				//간선 정보 입력
				for(int i=1;i<=m;i++) {
					int s = sc.nextInt();
					int e = sc.nextInt();
					int c = sc.nextInt();
					A.get(s).put(e, c);
					//s->e로 이동 가능
					line[s][e]=true;
				}
				
				//최단 경로 탐색
				dijkstra(start, end);
				//최단 경로 삭제
				traceback(end);
				//거의 최단 경로 탐색
				dijkstra(start, end);
						
				if(d[end]==100001) ans.add(-1);
				else ans.add(d[end]);
			}
		}
		//정답 출력
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
