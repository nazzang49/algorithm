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

//그래프의 최소 스패닝 트리(모든 정점을 연결하는 트리 중 가중치의 합이 최소가 되는)의 가중치 구하기
public class B_1197 {

	//정점 갯수
	static int v;
	//간선 갯수
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
			//부모 배열 초기화
			d = new int[v+1];
			for(int i=1;i<=v;i++) {
				d[i]=i;
			}
			
			//간선 정보 입력
			for(int i=0;i<e;i++) {
				//특정 정점과 연결된 정점, 비용 입력
				tree.add(new Pos(sc.nextInt(),sc.nextInt(),sc.nextInt()));
			}
			//최소 비용을 기준으로 정렬
			Collections.sort(tree,new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					return o1.cost-o2.cost;
				}
			});
			
			//트리 출력(확인용)
			for(int i=0;i<tree.size();i++) {
				System.out.println(tree.get(i).cost);
			}
			
			int sum = 0;
			//크루스칼 알고리즘 실행(합집합 찾기를 통해 부모가 같은지 확인)
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
