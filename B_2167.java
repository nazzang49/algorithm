package test_190129;

import java.util.Scanner;

//2차원 배열이 주어질 때, i행j열부터 x행y열까지 배열에 저장되어 있는 수들의 합을 구하는 프로그램 작성하기
public class B_2167 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=300&&m<=300) {
			int [][] map = new int[n+1][m+1];
			//자연수 입력
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int k = sc.nextInt();
			int [] ans = new int[k];
			while(k>0) {
				//두개의 포인트 입력
				int a = sc.nextInt();
				int b = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int i=a;i<=x;i++) {
					for(int j=b;j<=y;j++) {
						ans[3-k]+=map[i][j];
					}
				}
				k--;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
