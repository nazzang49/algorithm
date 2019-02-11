package test_190211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//역들을 잇는 하이퍼튜브에 대한 정보가 주어질 때, 1번부터 n번 역으로 이동할 시 거쳐야 하는 역들의 최소값 구하기
public class B_5214 {

	static int [] dis;
	static int n;
	//역 간 연결 여부
	static ArrayList<ArrayList<Integer>> connect = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=100000&&m<=1000&&k<=1000) {
			//1번부터 n번 역까지 존재(초기화), n번 이후부터 k번까지는 더미역(=하이퍼튜브)
			dis = new int[n+k+1];
			Arrays.fill(dis, 100000);
			
			//더미역까지 포함한 리스트 생성
			for(int i=0;i<=n+k;i++) {
				connect.add(new ArrayList<>());
			}
			
			//하이퍼튜브 정보 입력
			for(int i=1;i<=k;i++) {
				//더미 노드 생성(실제 존재하지 않지만, 연결 여부를 표현하기 위해 생성)
				int dummy = n+i;
				for(int j=0;j<m;j++) {
					int node = sc.nextInt();
					connect.get(dummy).add(node);
					connect.get(node).add(dummy);
				}
			}
			
			//이동 시 따로 최소 비용을 비교하지 않아도 되기 때문에 우선순위 큐 사용하지 않아도 됨
			Queue<Integer> q = new LinkedList<>();
			//1번역 = 1(출발 지점)
			dis[1]=1;
			q.add(1);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(Integer next : connect.get(cur)) {
					if(dis[next]>dis[cur]+1) {
						//현재 노드가 실제 역이면(최소값 갱신)
						if(cur<=n) dis[next]=dis[cur]+1;
						//현재 노드가 더미 역이면(그대로 이전값만 전달)
						else dis[next]=dis[cur];
						q.add(next);
					}
				}
			}
			System.out.println(dis[n]==100000? -1:dis[n]);
		}
	}
}
