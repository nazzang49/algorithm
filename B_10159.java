package test_190330;

import java.util.Arrays;
import java.util.Scanner;

//물건의 갯수 n과 임의 물건 간의 무게 비교 결과 m개가 주어질 때, 특정 물건과 비교할 수 없는 물건의 갯수 출력하기
public class B_10159 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=100&&m<=2000) {
			int [][] connected = new int[n+1][n+1];
			//배열 초기화
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i!=j) connected[i][j]=10001;
				}
			}
			//연결 여부 입력
			for(int i=0;i<m;i++) {
				connected[sc.nextInt()][sc.nextInt()]=1;
			}
			//플로이드 와샬 알고리즘
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						connected[i][j]=Math.min(connected[i][j], connected[i][k]+connected[k][j]);
					}
				}
			}
			//정답 출력
			for(int i=1;i<=n;i++) {
				int cnt = 0;
				for(int j=1;j<=n;j++) {
					if(connected[i][j]==10001&&connected[j][i]==10001) cnt++;
				}
				System.out.println(cnt);
			}
		}
	}
}
