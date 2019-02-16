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

//������ - ������������ �ִ� ��θ� ������ ������ �ִ� ��� ���ϱ�
//1�� Ž������ �ִ� ��θ� Ȯ���ϰ�, �ش� �ִ� ��θ� ������ ����, 2�� Ž�� ����
public class B_5719 {

	//���� ����
	static int n;
	//���� ����
	static int m;
	//���� ����
	static ArrayList<HashMap<Integer, Integer>> A = new ArrayList<>();
	//�ִ� ���
	static int [] d;
	//���� ��� ����(���� �۾� �� ���)
	static boolean [][] line;
	static ArrayList<Integer> [] trace;
	
	//���� -> ��� �̵��ϸ�, �ִ� ������� Ȯ��(������ ���� ����)
	public static void traceback(int e) {
		Queue<Integer> q = new LinkedList<>();
		q.add(e);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0;i<trace[x].size();i++) {
				int pre = trace[x].get(i);
				//����Ǿ� �ְ�, �ִܰ���̸�
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
				
				//���� �������� �̵� ��, �ش� ������ ���� �̵��� �� �ִ� ��츸 Ž��
				if(d[next]>=nextCost&&line[cur][next]) {
					d[next]=nextCost;
					pq.add(new Des(next, nextCost));
					//���� ���� �۾��� ���� ó��(���� ���� -> ���� ���� ����)
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
				
				//��� �� ���� ����
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				//���� ���� �Է�
				for(int i=1;i<=m;i++) {
					int s = sc.nextInt();
					int e = sc.nextInt();
					int c = sc.nextInt();
					A.get(s).put(e, c);
					//s->e�� �̵� ����
					line[s][e]=true;
				}
				
				//�ִ� ��� Ž��
				dijkstra(start, end);
				//�ִ� ��� ����
				traceback(end);
				//���� �ִ� ��� Ž��
				dijkstra(start, end);
						
				if(d[end]==100001) ans.add(-1);
				else ans.add(d[end]);
			}
		}
		//���� ���
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
