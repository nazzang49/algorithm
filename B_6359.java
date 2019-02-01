package test_190201;

import java.util.Scanner;

//일렬로 늘어선 n개의 감옥엥서 규칙에 따라 최종 몇명이 탈출할 수 있는지 출력하기
public class B_6359 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			int k = 0;
			int [] ans = new int[t];
			while(k<t) {
				//총 감옥의 갯수
				int n = sc.nextInt();
				boolean [] visited = new boolean[n+1];
				//열려있음 = false, 닫혀있음 = true
				for(int i=2;i<=n;i++) {
					for(int j=1;j*i<=n;j++) {
						if(!visited[i*j]) visited[i*j]=true;
						else visited[i*j]=false;
					}
				}
				//1번방은 무조건 열려 있으므로
				int cnt = 1;
				for(int i=2;i<=n;i++) {
					if(!visited[i]) {
						cnt++;
					}
				}
				ans[k]=cnt;
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
