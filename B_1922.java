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

//모든 컴퓨터를 연결하는데 드는 최소비용 구하기
public class B_1922 {

	//컴퓨터 대수
	static int n;
	//연결 갯수
	static int m;
	//부모 노드 정보 배열
	static int [] parent;
	//간선 정보
	static ArrayList<Pos> A = new ArrayList<>();
	
	public static boolean findParent(int s, int e) {
		s = getParent(s);
		e = getParent(e);
		//부모가 같지 않은 경우
		if(s!=e) return false;
		//부모가 같은 경우
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
			//부모 노드 배열 초기화(부모 = 자기 자신)
			for(int i=1;i<=n;i++) {
				parent[i]=i;
			}
			//간선 정보 입력
			for(int i=1;i<=m;i++) {
				A.add(new Pos(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			//비용 기준 오름차순 정렬
			Collections.sort(A,new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					return o1.cost-o2.cost;
				}
			});
			int sum = 0;
			//크루스칼 알고리즘 실행(부모가 같으면 = 사이클 발생 = 이미 방문한 것으로 간주)
			for(int i=0;i<A.size();i++) {
				int s = A.get(i).start;
				int e = A.get(i).end;
				int c = A.get(i).cost;
				//부모가 같지 않은 경우만 비용 추가
				if(!findParent(s,e)) {
					sum+=c;
					unionParent(s,e);
				}
			}
			//정답 출력
			System.out.println(sum);
		}	
	}
}
