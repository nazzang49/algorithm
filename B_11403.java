package test_190213;

import java.util.Scanner;

//NxN 행렬이 주어질 때, 모든 정점 (i,j)에 대해 i에서 j로 가는 경로가 있는지 구하는 프로그램 작성하기
public class B_11403 {

	static int n;
	static int [][] map;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=100) {
			map = new int[n][n];
			
			//연결 여부 입력(1은 연결 O, 0은 연결 X)
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//플로이드 와샬 탐색
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map[i][k]==1&&map[k][j]==1) {
							map[i][j]=1;
						}
					}
				}
			}
			
			//정답 출력
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
