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

//��� - ���� ��尡 �Էµ� ��, �ּ� ��� Ȥ�� �ִ� �Ÿ��� �̵��ϴ� ��� �� �� ���� �ּҰ��� ������ ���� �ִ� ��� ���ϱ�(��� ��� = ���� ���)
public class B_5719 {

	//from ��� to ��� ���(�ִ밪���� �ʱ�ȭ)
	static int [] dis;
	//�̹� ����� �������� ������ �迭
	static boolean [][] useLine;
	static int start;
	static int end;
	static ArrayList<HashMap<Integer, Integer>> connect = new ArrayList<>();
	//���� �ִ� ���(1�� �̻�)�� ������Ű�� ���� ��� ���� ���� �迭
	static ArrayList<Integer> [] trace;
	
	//���� �ִ� ��θ� ������ �޼ҵ�(���� -> ��߷� ���ư��� �ִ� ��� ����)
	public static void traceback() {
		Queue<Integer> q = new LinkedList<>();
		q.add(end);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			//���������� �����ؼ� ����� ������ �ִܰ������ Ȯ��
			for(int i=0;i<trace[cur].size();i++) {
				int pre = trace[cur].get(i);
				//�ִ� ����̸�
				if(dis[cur]==dis[pre]+connect.get(pre).get(cur)) {
					q.add(pre);
					//pre -> cur�� ���� ��� ����
					useLine[pre][cur]=true;
				}
			}
		}
	}
	
	//���ͽ�Ʈ�� �˰��� Ȱ��
	public static int dijkstra(int s) {
		//���� �̵��� ���� ������ �켱���� ť ���� �� ���� ��� ����
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
			int curCost = pq.peek().nextCost;
			pq.poll();
			
			//���� ���� ��뺸�� �� ���� ����̸� �ǳ� ��
			if(curCost>dis[cur]) {
				continue;
			}
			
			for(Map.Entry<Integer, Integer> entry : connect.get(cur).entrySet()) {
				int next = entry.getKey();
				int nextCost = curCost+entry.getValue();
				
				//�ּ� ����� ���ŵǴ� ��� ���Ӱ� �ش� ������ ����
				//<= �ε�ȣ ��� ���� = �ִ� ��ΰ� 1�� �̻��� �� �ֱ� ����
				if(nextCost<=dis[next]&&!useLine[cur][next]) {
					dis[next]=nextCost;
					pq.add(new Destination(next, nextCost));
					//���� ��� - ���� ����� ��� ���� ���� ����
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
			//����� ��
			int n = sc.nextInt();
			//������ ��
			int m = sc.nextInt();
			
			if(n==0&&m==0) {
				break;
			}
			
			//��� - ���� ��� �Է�
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
			
			//���� ���� �Է�
			for(int i=0;i<m;i++) {
				int cur = sc.nextInt();
				int next = sc.nextInt();
				int cost = sc.nextInt();
				
				connect.get(cur).put(next, cost);
			}
			
			dijkstra(start);
			traceback();
			//�ִ� �Ÿ� �迭 �ʱ�ȭ
			Arrays.fill(dis, Integer.MAX_VALUE);
			ans.add(dijkstra(start));
		}
		//�� �׽�Ʈ ���̽��� ���� ���
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
		sc.close();
	}
}
