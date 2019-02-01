package test_190201;

import java.util.ArrayList;
import java.util.Scanner;

class Pos {
	int begin, end, dis;
	
	public Pos(int begin, int end, int dis) {
		this.begin=begin;
		this.end=end;
		this.dis=dis;
	}
}

//����� �׷��� ������ �ּ� ���� ��� Ʈ���� ã�Ƴ��� ũ�罺Į �˰��� �ۼ��ϱ�
public class KruskalAlgorithm {

	static int [] parent;
	
	public static int getParent(int x) {
		if(parent[x]==x) return x;
		else return getParent(parent[x]);
	}
	
	public static boolean findParent(int A, int B) {
		if(getParent(A)==getParent(B)) return false;
		else return true;
	}
	
	public static void unionParent(int A, int B) {
		A = getParent(A);
		B = getParent(B);
		if(A<B) parent[B]=A;
		else parent[A]=B;
	}
	
	public static void main(String[] args) {

		ArrayList<Pos> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		//����� ����
		int n = 7;
		//������ ����
		int k = 11;
		
		//���� ���� 11�� �Է�
		list.add(new Pos(1, 2, 67));
		list.add(new Pos(1, 4, 28));
		list.add(new Pos(1, 5, 17));
		list.add(new Pos(1, 7, 12));
		list.add(new Pos(2, 4, 24));
		list.add(new Pos(2, 5, 62));
		list.add(new Pos(3, 5, 20));
		list.add(new Pos(3, 6, 37));
		list.add(new Pos(4, 7, 13));
		list.add(new Pos(5, 6, 45));
		list.add(new Pos(5, 7, 73));
		
		//����Ʈ �������� ����
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				//���(Ȥ�� �Ÿ�)�� ���� > ���� = ����
				if(list.get(i).dis>list.get(j).dis) {
					Pos p = list.get(i);
					list.set(i, list.get(j));
					list.set(j, p);
				}
			}
		}
		
		//����Ʈ ���
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).dis);
		}
		
		//�ڱ� �ڽ��� �θ� ���� �������� �ʱ�ȭ
		parent = new int[n+1];
		for(int i=1;i<=n;i++) {
			parent[i]=i;
		}
		
		int sum = 0;
		
		//����Ŭ �߻� ���� Ȯ���ϸ鼭 �ּ� ������ ������� ��� �ջ�(������ ã�� �˰��� Ȱ��)
		for(int i=0;i<list.size();i++) {
			//�� ���� ��尡 ���� �θ� ������ ��찡 �ƴ� ����(=����Ŭ�� �߻����� �ʴ� ���)
			if(findParent(list.get(i).begin,list.get(i).end)) {
				sum+=list.get(i).dis;
				//��ġ��
				unionParent(list.get(i).begin,list.get(i).end);
			}
		}
		System.out.println(sum);
	}
}
