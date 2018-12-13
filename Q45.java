package solution;

import java.util.Scanner;

//정사각형 형태의 체스판, 퀸의 개수(상하좌우, 대각선 이동 가능)가 주어질 때 한 번에 서로를 공격할 수 없도록 배치하는 경우의 수 구하기
public class Q45 {

	//1-n까지 모두 방문했는지 체크할 배열
	static boolean [] chk;
	static int n;
	//모든 경우의 수
	static int cnt;
	
	public static void dfs(int start, int ok) {
		//조건을 충족하며 다 방문했을 경우
		if(ok==n) {
			cnt++;
		}else {
			for(int i=0;i<n;i++) {
				if(i!=start+1&&i!=start-1) {
					if(!chk[i]) {
						chk[i]=true;
						ok++;
						dfs(i,ok);
						ok--;
						chk[i]=false;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=12) {
			chk = new boolean[n];
			for(int i=0;i<chk.length;i++) {
				if(!chk[i]) {
					chk[i]=true;
					dfs(i,1);
					chk[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
