package test_190221;

import java.util.Scanner;

public class B_6603 {

	static int [] arr;
	
	public static void dfs(int now, int cnt, int [] g) {
		if(cnt==5) {
			for(int i=0;i<g.length;i++) {
				System.out.print(g[i]+" ");
			}
			System.out.println();
			return;
		}
		cnt++;
		for(int i=now+1;i<arr.length;i++) {
			g[cnt]=arr[i];
			dfs(i,cnt,g);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int k = sc.nextInt();
			if(k==0) {
				break;
			}
			System.out.println();
			arr = new int[k];
			int [] g = new int[6];
			//자연수 입력
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//탐색 실행
			for(int i=0;i<=arr.length-6;i++) {
				g[0]=arr[i];
				dfs(i,0,g);
			}
		}
	}
}
