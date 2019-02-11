package test_190211;

import java.util.Scanner;

//플로이드 와샬 알고리즘 = 모든 정점에서 모든 정점으로 이동할 때, 특정 노드를 거쳐간다고 설정하고 최소 비용을 구하는 알고리즘
//ex) 2->3 vs 2->1 and 1->3 중 더 작은 값으로 갱신
public class FloydWarshall {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			//초기값 담을 배열 생성 및 비용 입력
			int [][] A = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					A[i][j]=sc.nextInt();
				}
			}
			//결과 출력 배열 생성 및 초기값 입력
			int [][] d = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					d[i][j]=A[i][j];
				}
			}
			//플로이드 와샬 실행(삼중 반복문)
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						//k노드를 거쳐 가는 경로가 더 적은 비용일 때(갱신)
						if(d[i][j]>d[i][k]+d[k][j]) {
							d[i][j]=d[i][k]+d[k][j];
						}
					}
				}
			}
			//정답 출력
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(d[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
