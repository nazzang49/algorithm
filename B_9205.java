package test_190122;

import java.util.ArrayList;
import java.util.Scanner;

//상근이 집, 맥주 리필이 가능한 편의점, 락 페스티벌 장소 좌표 저장할 클래스 선언
class Node {
	int x, y;
	
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//최초 맥주 20개를 가지고 최종 도착 장소인 락 페스티벌로 이동할 때, 50m마다 맥주 한병을 마신다면 소진되지 않고 도착 가능한지 판별하는 프로그램 작성하기
public class B_9205 {

	static int n;
	static ArrayList<Node> node;
	static boolean flag;
	
	public static void dfs(int start, int beer) {
		if(beer>=0) {
			//락 페스티벌 장소에 무사히 도착하는 경우가 하나라도 있다면
			if(start==node.size()-1) {
				flag=true;
				return;
			}
			for(int i=start+1;i<node.size();i++) {
				//편의점 들리면 다시 맥주 20개 채우고 출발
				beer=20;
				Node A = node.get(start);
				Node B = node.get(i);
				//두 장소 간 거리 = 맨해튼 거리
				int dis = Math.abs(A.x-B.x)+Math.abs(A.y-B.y);
				beer-=(dis/50);
				dfs(i,beer);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String [] ans = new String[t];
		
		if(t<=50) {
			int k = 0;
			while(k<t) {
				n = sc.nextInt();
				node = new ArrayList<>();
				flag = false;
				//각 장소 좌표 입력
				for(int i=0;i<n+2;i++) {
					node.add(new Node(sc.nextInt(), sc.nextInt()));
				}
				//탐색 실행
				dfs(0,20);
				if(flag) {
					ans[k]="happy";
				}else {
					ans[k]="sad";
				}
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
