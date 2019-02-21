package test_190221;

import java.util.Scanner;

//몇 개의 빈자리가 존재하는 9x9 스도쿠 판이 주어질 때, 해당 빈칸에 알맞은 숫자를 집어넣는 프로그램 작성하기

//(스도쿠 게임 규칙)
//1) 동일 행에 동일한 숫자 존재 X
//2) 동일 열에 동일한 숫자 존재 X
//3) 동일 부분집합에 동일한 숫자 존재 X
public class B_2580 {

	static int [][]  map = new int[9][9];
	static int row = 0;
	static int col = 0;
	
	//아직 처리되지 않은 빈 공간
	public static boolean find() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j]==0) {
					row=i;
					col=j;
					return false;
				}
			}
		}
		return true;
	}
	
	//가로 규칙
	public static boolean garo(int r, int value) {
		for(int i=0;i<9;i++) {
			if(map[r][i]==value) {
				return false;
			}
		}
		return true;
	}
	
	//세로 규칙
	public static boolean sero(int c, int value) {
		for(int i=0;i<9;i++) {
			if(map[i][c]==value) {
				return false;
			}
		}
		return true;
	}

	//부분집합 규칙
	public static boolean group(int r, int c, int value) {
		if(r/3==0) r=0;
		else if(r/3==1) r=3;
		else r=6;
		
		if(c/3==0) c=0;
		else if(c/3==1) c=3;
		else c=6;
		
		for(int i=r;i<=r+2;i++) {
			for(int j=c;j<=c+2;j++) {
				if(map[i][j]==value) {
					return false;
				}
			}
		}
		return true;
	}
	
	//세가지 규칙
	public static boolean all(int r, int c, int value) {
		if(garo(r, value)&&sero(c, value)&&group(r, c, value)) {
			return true;
		}
		return false;
	}
	
	public static boolean fill() {
		if(find()) {
			return true;
		}
		
		//아직 빈 공간이 남았다면
		int r = row;
		int c = col;
		
		//1~9까지 숫자 넣어보면서 규칙 만족하는지 확인
		for(int i=1;i<=9;i++) {
			//규칙 만족하면 그 다음 빈 공간 탐색
			if(all(r,c,i)) {
				map[r][c]=i;
				if(fill()) {
					return true;
				}
			}
			map[r][c]=0;
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//현재 스도쿠 판 입력
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//DFS 탐색 실행
		fill();
		//정답 출력
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
