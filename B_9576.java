package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//테스트 케이스별 전공 서적의 수 m, 학생 수 n, 학생별 입력된 a번, b번이 주어질 때, 규칙에 따라 책을 최대한 많이 나눠줄 수 있는 경우 구하기(이분매칭)
public class B_9576 {

	static int n;
	static int m;
	//책의 주인 배열
	static int [] d;
	//책 주인 존재 여부
	static boolean [] v;
	//학생별 원하는 책의 번호
	static ArrayList<Integer> [] A;
	//나눠줄 수 있는 최대 책의 권수
	static int result = 0;
	
	public static boolean dfs(int cur) {
		//cur 학생이 가지고 싶어하는 책의 번호 x
		for(int i=0;i<A[cur].size();i++) {
			int x = A[cur].get(i);
			
			if(v[x]) continue;
			else v[x]=true;
			
			//주인이 없거나, 주인 재정비 가능하면 = 갱신
			if(d[x]==0||dfs(d[x])) {
				d[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] ans = new int[t];
		
		int k = 0;
		while(k<t) {
			//책의 수
			n = sc.nextInt();
			//학생 수
			m = sc.nextInt();
			v = new boolean[n+1];
			d = new int[n+1];
			A = new ArrayList[m+1];
			result = 0;
			
			//학생별 원하는 책의 번호 입력
			for(int i=1;i<=m;i++) {
				A[i]=new ArrayList<>();
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j=a;j<=b;j++) {
					A[i].add(j);
				}
			}
			
			//DFS 탐색
			for(int i=1;i<=m;i++) {
				Arrays.fill(v, false);
				if(dfs(i)) result++;
			}
			ans[k]=result;
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
