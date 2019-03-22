package test_190322;

import java.util.Arrays;
import java.util.Scanner;

//모든 도시에 대해 A에서 B로 이동하는 최소 비용 구하기
public class B_11404 {

	//도시 갯수
	static int n;
	//간선 갯수
	static int m;
	//간선 비용
	static int [][] dis;
	//정답 배열
	static int [][] ans;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100000) {
			ans = new int[n+1][n+1];
			dis = new int[n+1][n+1];
			
			//비용 초기화
			for(int i=1;i<=n;i++) {
				Arrays.fill(dis[i], 10001);
			}
			
			//비용 입력
			for(int i=0;i<m;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int cost = sc.nextInt();
				//더 적은 비용 입력 = 갱신
				dis[s][e]=Math.min(dis[s][e], cost);
			}
			
			//플로이드 와샬 실행
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//i에서 j로 다이렉트 이동할 때의 비용 < k 정점을 거쳐 이동하는 경우의 비용
						if(dis[i][j]>dis[i][k]+dis[k][j]) {
							dis[i][j]=dis[i][k]+dis[k][j];
						}
					}
				}
			}
			
			//정답 출력
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j) System.out.print(0+" ");
					else System.out.print(dis[i][j]+" ");
				}
				System.out.println();
			}
		}	
	}
}
