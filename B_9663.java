package test_190221;

import java.util.Scanner;

//NxN 크기 체스판 위에 퀸 N개를 놓을 때, 서로 공격할 수 없는 포지션에 위치시키는 경우의 수 출력하기
public class B_9663 {

	static int n;
	//특정 행에서 사용한 열 인덱스 저장할 배열
	static int [] rowCol;
	//특정 열 사용 여부 저장할 배열
	static int [] col;
	static int cnt = 0;
	
	//행을 +1하며 탐색
	public static void dfs(int row) {
		//마지막 행까지 도달하면(경우의 수 +1)
		if(row==n) {
			cnt++;
			return;
		}
		//loop = 반복의 범위를 지정할 때 사용하는 명령어
		//1) 열 탐색
		loop : for(int i=0;i<n;i++) {
			if(col[i]==1) {
				//다시 loop의 처음부터 반복하겠다는 의미
				continue loop;
			}
			//2) 대각선 탐색(현재 행까지, 대각선 = 기울기)
			for(int j=0;j<row;j++) {
				if(Math.abs(row-j)==Math.abs(i-rowCol[j])) {
					//다시 loop의 처음부터 반복하겠다는 의미
					continue loop;
				}
			}
			//두가지 탐색 모두 가능한 경우만 해당 자리 사용한 것으로 처리
			rowCol[row]=i;
			col[i]=1;
			//다음 행 탐색
			dfs(row+1);
			col[i]=0;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=15) {
			col = new int[n+1];
			rowCol = new int[n+1];
			dfs(0);
			System.out.println(cnt);
		}else {
			System.out.println("입력 조건을 확인하세요.");
			System.exit(0);
		}
	}
}
