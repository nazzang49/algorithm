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

//n�� ���� �� �� ������ �ٸ� ������ �̵� �ϴ� ������ ����� m�� �־��� ��, ��������� ���������� �̵��� �� �ִ� �ּ� ��� ���ϱ� 
public class B_1916 {

	static int n;
	static int m;
	static ArrayList<HashMap<Integer, Integer>> A = new ArrayList<>();
	static int [] dis;
	static final int INF = 100001;
	
	public static void dijkstra(int s, int e) {
		//�ʱⰪ�� ���Ѵ�� ����
		Arrays.fill(dis, INF);
		//�ּ� ����� ���� ��θ� �������� �켱���� ť ����
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
					//���� ���������� �ּ� �̵� ��� = ��������� �ּ� ��� + ���� - ���� ���� �� �̵� ���
					int nextCost = curCost+entry.getValue();
					
					//�ּҰ� ����
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
			//��庰 �ν��Ͻ� ����
			for(int i=0;i<=n;i++) {
				A.add(new HashMap<>());
			}
			//���� ���� �Է�
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
