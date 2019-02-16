package test_190216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

///NxN 행렬에 돌멩이의 위치가 입력될 때, 직선 방향으로 이동하며 제거하는 것을 1회라고 볼 시 최소 횟수로 모든 돌멩이를 제거하는 프로그램 작성하기(이분매칭)
public class B_1867 {

	//행렬 크기
	static int n;
	//돌멩이 갯수(1번~n번)
	static int m;
	static ArrayList<Integer> [] A;
	static boolean [] v;
	static int [] aMatch;
	static int [] bMatch;
	static int result = 0;
	
	public static boolean dfs(int cur) {
		for(int i=0;i<A[cur].size();i++) {
			int x = A[cur].get(i);
			
			if(v[x]) continue;
			else v[x]=true;
			
			if(bMatch[x]==0||dfs(bMatch[x])) {
				aMatch[cur]=x;
				bMatch[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=500&&m<=10000) {
			aMatch = new int[n+1];
			bMatch = new int[n+1];
			A = new ArrayList[n+1];
			v = new boolean[m+1];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//돌멩이 위치 입력
			for(int i=1;i<=m;i++) {
				A[sc.nextInt()].add(sc.nextInt());
			}
			
			//탐색 실행
			for(int i=1;i<=n;i++) {
				if(aMatch[i]==0) {
					Arrays.fill(v, false);
					if(dfs(i)) result++;
				}
			}
			System.out.println(result);
		}
	}
}
