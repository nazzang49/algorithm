package test_190228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Pos {
	int start;
	int end;
	int cost;
	
	public Pos(int start, int end, int cost) {
		this.start=start;
		this.end=end;
		this.cost=cost;
	}
}

//��� ��ǻ�͸� �����ϴµ� ��� �ּҺ�� ���ϱ�
public class B_1922 {

	//��ǻ�� ���
	static int n;
	//���� ����
	static int m;
	//�θ� ��� ���� �迭
	static int [] parent;
	//���� ����
	static ArrayList<Pos> A = new ArrayList<>();
	
	public static boolean findParent(int s, int e) {
		s = getParent(s);
		e = getParent(e);
		//�θ� ���� ���� ���
		if(s!=e) return false;
		//�θ� ���� ���
		else return true;
	}
	
	public static int getParent(int x) {
		if(parent[x]==x) return x;
		else return getParent(parent[x]);
	}
	
	public static void unionParent(int s, int e) {
		s = getParent(s);
		e = getParent(e);
		if(s<e) parent[e]=s;
		else parent[s]=e;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000&&m<=100000) {
			parent = new int[n+1];
			//�θ� ��� �迭 �ʱ�ȭ(�θ� = �ڱ� �ڽ�)
			for(int i=1;i<=n;i++) {
				parent[i]=i;
			}
			//���� ���� �Է�
			for(int i=1;i<=m;i++) {
				A.add(new Pos(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			//��� ���� �������� ����
			Collections.sort(A,new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					return o1.cost-o2.cost;
				}
			});
			int sum = 0;
			//ũ�罺Į �˰��� ����(�θ� ������ = ����Ŭ �߻� = �̹� �湮�� ������ ����)
			for(int i=0;i<A.size();i++) {
				int s = A.get(i).start;
				int e = A.get(i).end;
				int c = A.get(i).cost;
				//�θ� ���� ���� ��츸 ��� �߰�
				if(!findParent(s,e)) {
					sum+=c;
					unionParent(s,e);
				}
			}
			//���� ���
			System.out.println(sum);
		}	
	}
}
