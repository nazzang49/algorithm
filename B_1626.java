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

//두 번째로 작은 스패닝 트리 구하기
public class B_1626 {

	static ArrayList<Loc> list = new ArrayList<>();
	static int [] parent;
	
	//부모 합치기
	public static void unionParent(int s, int e) {
		s = getParent(s);
		e = getParent(e);
		if(s<=e) parent[e]=s;
		else parent[s]=e;
	}
	
	//두 정점의 부모가 같은지 확인
	public static boolean findParent(int s, int e) {
		s = getParent(s);
		e = getParent(e);
		if(s==e) return true;
		else return false;
	}
	
	//현재 부모 반환
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
			//부모 초기화
			for(int i=1;i<parent.length;i++) {
				parent[i]=i;
			}
			//연결 정보 입력
			for(int i=0;i<e;i++) {
				list.add(new Loc(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			//오름차순 정렬
			Collections.sort(list, new Comparator<Loc>() {
				public int compare(Loc o1, Loc o2) {
					return o1.cost-o2.cost;
				}
			});
			int sum = 0;
			//크루스칼 알고리즘 실행
			for(int i=0;i<list.size();i++) {
				int start = list.get(i).s;
				int end = list.get(i).e;
				int cost = list.get(i).cost;
				//부모가 같지 않을 때(루프가 아닐 때) = 방문한 적 없는 정점일 때
				if(!findParent(start,end)) {
					sum+=cost;
					unionParent(start, end);
				}
			}
			System.out.println(sum);
		}	
	}
}
