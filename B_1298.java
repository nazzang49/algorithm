package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//노트북 구입 인원 n, 노트북 예상 갯수 m, 각 인원마다 자신의 것이라 생각하는 노트북 번호가 주어질 때, 노트북이 주인에게 돌아가는 경우의 최대값 구하기
public class B_1298 {

	static int n;
	static int m;
	static ArrayList<Integer> [] A;
	//현재 노트북 주인
	static int [] d;
	//주인이 생긴 노트북인지 판별
	static boolean [] v;
	static int result = 0;
	
	public static boolean dfs(int cur) {
		for(int i=0;i<A[cur].size();i++) {
			//cur 사람이 자신의 것이라 착각하는 노트북 x
			int x = A[cur].get(i);
			
			//cur가 x의 주인으로 설정된 경우(현재 탐색)
			if(v[x]) continue;
			//cur가 첫 주인인 경우
			else v[x]=true;
			
			//아직 주인이 없거나, 현재 주인이 다른 노트북을 가질 수 있다면(갱신)
			if(d[x]==0||dfs(d[x])) {
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
		
		if(n<=100&&m<=5000) {
			v = new boolean[m+1];
			d = new int[m+1];
			A = new ArrayList[n+1];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//자신의 것이라 생각하는 노트북과 간선 생성
			for(int i=1;i<=m;i++) {
				A[sc.nextInt()].add(sc.nextInt());
			}
			
			//탐색 실행
			for(int i=1;i<=n;i++) {
				Arrays.fill(v, false);
				if(dfs(i)) result++;
			}
			System.out.println(result);
		}
	}
}
