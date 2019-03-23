package test_190323;

import java.util.Arrays;
import java.util.Scanner;

public class B_2188 {

	static int [] A;
	static int [] B;
	//이미 매칭된 소인지 판별할 배열
	static boolean [] v;
	//각 소가 들어가길 원하는 축사(연결)
	static boolean [][] connect;
	//소 마릿수
	static int n;
	//축사 갯수
	static int m;
	
	public static boolean dfs(int cur) {
		if(v[cur]) return false;
		v[cur]=true;
		for(int i=1;i<=m;i++) {
			//현재 소가 들어가길 희망하는 축사이면
			if(connect[cur][i]) {
				//최초 배정 or 배정되었지만 재배정 가능하면
				if(B[i]==0||dfs(B[i])) {
					//현재 소 - i번째 축사 매칭
					A[cur]=i;
					//i번째 축사 - 현재 소 매칭
					B[i]=cur;
					//매칭이 되었으니 true 반환
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=200&&m<=200) {
			A = new int[n+1];
			B = new int[m+1];
			v = new boolean[n+1];
			connect = new boolean[n+1][m+1];
			
			//각 소가 들어가길 희망하는 축사 번호 입력
			for(int i=1;i<=n;i++) {
				int tmp = sc.nextInt();
				for(int j=0;j<tmp;j++) {
					connect[i][sc.nextInt()]=true;
				}
			}
			
			int cnt = 0;
			//매칭 시작
			for(int i=1;i<=n;i++) {
				//매 탐색마다 소의 위치 다시 탐색하므로 초기화
				Arrays.fill(v, false);
				if(dfs(i)) cnt++;
			}
			System.out.println(cnt);
		}
	}
}
