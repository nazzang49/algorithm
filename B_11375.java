package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//직원의 수 n, 일의 수 m, 각 직원이 맡고 싶어하는 일의 번호가 주어질 때, 최종 완료할 수 있는 일의 최대 갯수 출력하기
public class B_11375 {

	static int n;
	static int m;
	static ArrayList<Integer> [] A;
	static boolean [] visit;
	static int [] d;
	static int result = 0;
	
	//모든 경우에 대해 만족하는 경우
	public static boolean dfs(int cur) {
		for(int i=0;i<A[cur].size();i++) {
			//맡고자 하는 일의 번호
			int x = A[cur].get(i);
			
			//최초 방문인지 확인(현재 인원의 dfs에서)
			//최초 방문이 아님 = 현재 인원이 해당 일을 맡은 것으로 간주(cur는 해당 일읆 맡을 수 없음)
			if(visit[x]) continue;
			else visit[x]=true;
			
			//아직 배정되지 않은 일이거나, 배정됐지만 해당 인원이 다른 일을 할 수 있다면
			if(d[x]==0||dfs(d[x])) {
				//현재 일 맡는 사람 변경
				d[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000&&m<=1000) {
			d = new int[m+1];
			A = new ArrayList[n+1];
			visit = new boolean[m+1];
			//맡고자 하는 일 입력
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
				int tmp = sc.nextInt();
				for(int j=1;j<=tmp;j++) {
					A[i].add(sc.nextInt());
				}
			}
			//DFS 탐색 실행
			for(int i=1;i<=n;i++) {
				Arrays.fill(visit, false);
				//각 직원이 원하는 일을 맡을 수 있는지
				if(dfs(i)) result++;
			}
			System.out.println(result);
		}	
	}
}
