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

//n�� ������ n���� �л��� �Ѹ� ��� ���� ��, x�� ������ ��Ƽ�� �Ϸ� ���ٰ� �ٽ� ������ ���ƿ��� ��� �� �ҿ� �ð��� ���� ���� �ɸ��� �л� ���ϱ�
public class B_1238 {

	//���� ����(1��~)
	static int n;
	//���� ����
	static int m;
	//��Ƽ ���
	static int x;
	//���� ����
	static ArrayList<Pos> [] A;
	static int [] d;
	
	public static int dijkstra(int s, int e) {
		//�ִܰŸ� �迭 �ʱ�ȭ
		d = new int[n+1];
		Arrays.fill(d, 10001);
		//�������� 0
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
			
			//���� ������ �̹� �ִܰ���̸�
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
			//���� ���� �Է�
			for(int i=0;i<m;i++) {
				A[sc.nextInt()].add(new Pos(sc.nextInt(), sc.nextInt()));
			}
			int max = Integer.MIN_VALUE;
			//���ͽ�Ʈ�� �˰��� ����
			for(int i=1;i<=n;i++) {
				if(max<dijkstra(i, x)+dijkstra(x, i)) {
					max = dijkstra(i, x)+dijkstra(x, i);
				}
			}
			System.out.println(max);
		}	
	}
}
