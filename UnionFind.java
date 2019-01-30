package test_190130;

import java.util.Scanner;

//합집합 찾기
public class UnionFind {

	static int [] A;
	
	//부모 노드 찾기
	public static int getParent(int x) {
		if(A[x]==x) return x;
		return getParent(A[x]);
	}
	
	//부모 노드 합치기
	public static void unionParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if(x<y) A[y]=x;
		else A[x]=y;
	}
	
	//변경된 부모 노드 찾기
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
		//자기 자신을 부모로 가지는 그래프로 초기화
		for(int i=1;i<A.length;i++) {
			A[i]=i;
		}
		//부모 노드 합치기(두 개의 그래프로 양분)
		unionParent(1,2);
		unionParent(2,3);
		unionParent(3,4);
		unionParent(5,6);
		unionParent(6,7);
		unionParent(7,8);
		System.out.println("현재 입력한 두 개의 노드는 서로 연결되어 있습니까? "+findParent(x,y));
	}	
}