package solution;

import java.util.Scanner;

//한길이의 앞에 서 있는 사람의 수가 주어지고 최소 a 혹은 b명 남았을 때 새치기가 가능하다면 줄의 맨 앞에 서는데까지 걸리는 최소시간 구하기 
public class Q82 {

	//걸리는 최소 시간
	static int cnt = Integer.MAX_VALUE;
	static int m;
	static int k;
	
	public static void dfs(int n, int time) {
		//줄의 맨 앞에 서게 되면
		if(n==0) {
			if(time<=cnt) {
				cnt=time;
			}
		}else if(n>0) {
			time++;
			n--;
			for(int i=0;i<2;i++) {
				if(i==0) {
					n-=m;
					dfs(n,time);
					n+=m;
				}else {
					n-=k;
					dfs(n,time);
					n+=k;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		if(0<=n&&n<=1000000&&0<=m&&m<=n&&0<=k&&k<=n) {
			dfs(n,0);
			System.out.println(cnt);
		}
	}
}
