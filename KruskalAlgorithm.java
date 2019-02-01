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

//연결된 그래프 내에서 최소 신장 비용 트리를 찾아내는 크루스칼 알고리즘 작성하기
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
		//노드의 갯수
		int n = 7;
		//간선의 갯수
		int k = 11;
		
		//연결 정보 11개 입력
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
		
		//리스트 오름차순 정렬
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				//비용(혹은 거리)이 앞쪽 > 뒷쪽 = 스왑
				if(list.get(i).dis>list.get(j).dis) {
					Pos p = list.get(i);
					list.set(i, list.get(j));
					list.set(j, p);
				}
			}
		}
		
		//리스트 출력
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).dis);
		}
		
		//자기 자신을 부모 노드로 가지도록 초기화
		parent = new int[n+1];
		for(int i=1;i<=n;i++) {
			parent[i]=i;
		}
		
		int sum = 0;
		
		//사이클 발생 여부 확인하면서 최소 비용부터 순서대로 비용 합산(합집합 찾기 알고리즘 활용)
		for(int i=0;i<list.size();i++) {
			//두 개의 노드가 같은 부모를 가지는 경우가 아닐 때만(=사이클이 발생하지 않는 경우)
			if(findParent(list.get(i).begin,list.get(i).end)) {
				sum+=list.get(i).dis;
				//합치기
				unionParent(list.get(i).begin,list.get(i).end);
			}
		}
		System.out.println(sum);
	}
}
