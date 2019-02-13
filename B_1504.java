package test_190213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pos {
	int next;
	int cost;
	
	public Pos(int next, int cost) {
		this.next=next;
		this.cost=cost;
	}
}

//n�� ���� �� �� ������ �ٸ� ������ �̵� �ϴ� ������ ����� m�� �־��� ��, ��������� ���������� �̵��� �� �ִ� �ּ� ��� ���ϱ� 
public class B_1504 {

	static int n;
	static int m;
	static ArrayList<HashMap<Integer, Integer>> A = new ArrayList<>();
	static int [] dis;
	static final int INF = 100001;
	static boolean [] v;
	
	public static int dijkstra(int s, int e) {
		dis = new int[n+1];
		//�ʱⰪ�� ���Ѵ�� ����
		Arrays.fill(dis, INF);
		//�ּ� ����� ���� ��θ� �������� �켱���� ť ����
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				if(o1.cost>o2.cost) return 1;
				else if(o1.cost==o2.cost) return 0;
				else return -1;
			}
		});
		dis[s]=0;
		pq.add(new Pos(s, dis[s]));
		
		while(!pq.isEmpty()) {
			int cur = pq.peek().next;
			int curCost = pq.peek().cost;
			pq.poll();
			
			for(Map.Entry<Integer, Integer> entry : A.get(cur).entrySet()) {
				int next = entry.getKey();
				//���� ���������� �ּ� �̵� ��� = ��������� �ּ� ��� + ���� - ���� ���� �� �̵� ���
				int nextCost = curCost+entry.getValue();
				
				//�ּҰ� ����
				if(dis[next]>nextCost) {
					dis[next]=nextCost;
					pq.add(new Pos(next, nextCost));
				}
			}
		}
		return dis[e];
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000&&m<=100000) {
			v = new boolean[n+1];
			//��庰 �ν��Ͻ� ����
			for(int i=0;i<=n;i++) {
				A.add(new HashMap<>());
			}
			//���� ���� �Է�
			for(int i=1;i<=m;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int cost = sc.nextInt();
				//����� ����
				A.get(s).put(e, cost);
				A.get(e).put(s, cost);
			}
			//�ݵ�� ���� �̵��ؾ� �ϴ� �� ���� �Է�
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			//�� ���� ��� ����(���ľ� �ϴ� �ΰ��� ���� �� ��� ���� ���� �湮�ϴ��Ŀ� ����)
			//1) 1 -> v1 -> v2 -> n
			//2) 1 -> v2 -> v1 -> n
			int method1 = dijkstra(1,v1)+dijkstra(v1,v2)+dijkstra(v2,n);
			int method2 = dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,n);
			System.out.println(Math.min(method1, method2));
		}	
	}
}