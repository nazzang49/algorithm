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

//����׷����� �־�����, ���������� �ٸ� ��� �������� �̵��ϴ� �ִ� �Ÿ� ����ϱ�
public class B_1753 {

	//������ ����
	static int v;
	//������ ����
	static int e;
	//Ư�� ��� �� ���� ���� ������ �迭
	static ArrayList<HashMap<Integer, Integer>> A;
	//���������� ��� ���������� �ִ� �Ÿ� ������ �迭
	static int [] dis;
	
	public static void dijkstra(int s) {
		//dis �迭 �ʱ�ȭ(���Ѱ�)
		Arrays.fill(dis, 100001);
		//�� ���� ��뿡 �ش��ϴ� ��ΰ� �켱 ���ĵǵ��� pq ����
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
			//���� ���
			int cur = pq.peek().next;
			//���� ���� �̵��ϴµ� ��� ���
			int curCost = pq.peek().nextCost;
			pq.poll();
			
			//�̹� �� ���� ����� ����Ǿ� ������ ���� X
			if(curCost>dis[cur]) {
				continue;
			}
			
			//���� ���� �̾��� ��� ��� Ž��
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
		//���� ���
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
			//���� ����
			int start = sc.nextInt();
			
			//���� ���� �Է�
			for(int i=0;i<=v;i++) A.add(new HashMap<Integer, Integer>());
			for(int i=1;i<=e;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int cost = sc.nextInt();
				A.get(s).put(e, cost);
			}
			//Ž�� ����
			dijkstra(start);
		}	
	}
}
