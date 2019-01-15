package test_190115;

import java.util.Scanner;

//변을 공유하는 스티커는 뗄 수 없고, 두 행에 걸쳐 각 열마다 스티커의 점수가 주어질 때 얻을 수 있는 점수의 최대값 구하기
public class B_9465 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			int [][] map = new int[2][n];
			//점수 입력
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//DP 계산
			map[0][1]=map[1][0]+map[0][1];
			map[1][1]=map[0][0]+map[1][1];
			//열(2열부터 탐색)
			for(int j=2;j<n;j++) {
				//행
				for(int i=0;i<map.length;i++) {
					map[i][j]=Math.max(map[1-i][j-1],map[1-i][j-2])+map[i][j];
				}
			}
			System.out.println(Math.max(map[0][n-1], map[1][n-1]));
		}
	}
}
