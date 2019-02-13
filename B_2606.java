package test_190213;

import java.util.Scanner;

//1번 컴퓨터가 바이러스에 걸렸을 때, 컴퓨터 간 연결 정보가 주어질 시 바이러스에 최종 걸리게 되는 컴퓨터 대수 출력하기
public class B_2606 {

	//전체 대수
	static int n;
	//직접 연결되어 있는 간선의 수
	static int m;
	//직접 연결된 컴퓨터 번호 저장 배열
	static boolean [][] A;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100) {
			A = new boolean[n+1][n+1];
			//컴퓨터 정보 입력(연결 여부)
			for(int i=1;i<=m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				A[tmp1][tmp2]=A[tmp1][tmp2]=true;
			}
			//플로이드 와샬 탐색
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//특정 노드를 거쳐 다른 노드로 접근할 수 있는 경우면(그 두가지 노드 역시 연결되어 있는 것으로 간주)
						if(A[i][k]&&A[k][j]) {
							A[i][j]=true;
						}
					}
				}
			}
			int cnt = 0;
			for(int i=2;i<=n;i++) {
				if(A[1][i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
