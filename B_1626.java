package test_190330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Loc {
	int s, e, cost;
	public Loc(int s, int e, int cost) {
		this.s=s;
		this.e=e;
		this.cost=cost;
	}
}

//�� ��°�� ���� ���д� Ʈ�� ���ϱ�
public class B_1626 {

	static ArrayList<Loc> list = new ArrayList<>();
	static int [] parent;
	
	//�θ� ��ġ��
	public static void unionParent(int s, int e) {
		s = getParent(s);
		e = getParent(e);
		if(s<=e) parent[e]=s;
		else parent[s]=e;
	}
	
	//�� ������ �θ� ������ Ȯ��
	public static boolean findParent(int s, int e) {
		s = getParent(s);
		e = getParent(e);
		if(s==e) return true;
		else return false;
	}
	
	//���� �θ� ��ȯ
	public static int getParent(int s) {
		if(s==parent[s]) return s;
		else return getParent(parent[s]);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		if(v<=50000&&e<=200000) {
			parent = new int[v+1];
			//�θ� �ʱ�ȭ
			for(int i=1;i<parent.length;i++) {
				parent[i]=i;
			}
			//���� ���� �Է�
			for(int i=0;i<e;i++) {
				list.add(new Loc(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			//�������� ����
			Collections.sort(list, new Comparator<Loc>() {
				public int compare(Loc o1, Loc o2) {
					return o1.cost-o2.cost;
				}
			});
			int sum = 0;
			//ũ�罺Į �˰��� ����
			for(int i=0;i<list.size();i++) {
				int start = list.get(i).s;
				int end = list.get(i).e;
				int cost = list.get(i).cost;
				//�θ� ���� ���� ��(������ �ƴ� ��) = �湮�� �� ���� ������ ��
				if(!findParent(start,end)) {
					sum+=cost;
					unionParent(start, end);
				}
			}
			System.out.println(sum);
		}	
	}
}
