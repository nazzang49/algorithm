package test_190130;

import java.util.Scanner;

//������ ã��
public class UnionFind {

	static int [] A;
	
	//�θ� ��� ã��
	public static int getParent(int x) {
		if(A[x]==x) return x;
		return getParent(A[x]);
	}
	
	//�θ� ��� ��ġ��
	public static void unionParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x<y) A[y]=x;
		else A[x]=y;
	}
	
	//����� �θ� ��� ã��
	public static boolean findParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x==y) return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		A = new int[9];
		//�ڱ� �ڽ��� �θ�� ������ �׷����� �ʱ�ȭ
		for(int i=1;i<A.length;i++) {
			A[i]=i;
		}
		//�θ� ��� ��ġ��(�� ���� �׷����� ���)
		unionParent(1,2);
		unionParent(2,3);
		unionParent(3,4);
		unionParent(5,6);
		unionParent(6,7);
		unionParent(7,8);
		System.out.println("���� �Է��� �� ���� ���� ���� ����Ǿ� �ֽ��ϱ�? "+findParent(x,y));
	}	
}