package test_190220;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Pos {
	int cur;
	int next;
	int cost;
	
	public Pos(int cur, int next, int cost) {
		this.cur=cur;
		this.next=next;
		this.cost=cost;
	}
}

//�׷����� �ּ� ���д� Ʈ��(��� ������ �����ϴ� Ʈ�� �� ����ġ�� ���� �ּҰ� �Ǵ�)�� ����ġ ���ϱ�
public class B_1197 {

	//���� ����
	static int v;
	//���� ����
	static int e;
	static ArrayList<Pos> tree = new ArrayList<>();
	static int [] d;
	
	public static int getParent(int x) {
		if(d[x]==x) return x;
		else return getParent(d[x]);
	}
	
	public static boolean findParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x!=y) return false;
		else return true;
	}
	
	public static void unionParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x<y) d[y]=x;
		else d[x]=y;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		if(v<=10000&&e<=100000) {
			//�θ� �迭 �ʱ�ȭ
			d = new int[v+1];
			for(int i=1;i<=v;i++) {
				d[i]=i;
			}
			
			//���� ���� �Է�
			for(int i=0;i<e;i++) {
				//Ư�� ������ ����� ����, ��� �Է�
				tree.add(new Pos(sc.nextInt(),sc.nextInt(),sc.nextInt()));
			}
			//�ּ� ����� �������� ����
			Collections.sort(tree,new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					return o1.cost-o2.cost;
				}
			});
			
			//Ʈ�� ���(Ȯ�ο�)
			for(int i=0;i<tree.size();i++) {
				System.out.println(tree.get(i).cost);
			}
			
			int sum = 0;
			//ũ�罺Į �˰��� ����(������ ã�⸦ ���� �θ� ������ Ȯ��)
			for(int i=0;i<tree.size();i++) {
				int cur = tree.get(i).cur;
				int next = tree.get(i).next;
				int cost = tree.get(i).cost;
				if(!findParent(cur,next)) {
					sum+=cost;
					unionParent(cur,next);
				}
			}
			System.out.println(sum);
		}
	}
}
