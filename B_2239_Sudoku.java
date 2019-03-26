package test_190326;

import java.util.Scanner;

//입력으로 주어진 풀다 만 스도쿠 완성하기(9x9)
public class B_2239_Sudoku {

	static int [][] sudoku = new int[9][9];
	//비어있는 칸의 x,y좌표 담을 변수
	static int r;
	static int c;
	
	//비어 있는 곳 탐색
	public static boolean findEmpty() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(sudoku[i][j]==0) {
					r = i;
					c = j;
					return false;
				}
			}
		}
		return true;
	}
	
	//채워넣기(DFS + 백트래킹)
	public static boolean fill() {
		//모두 채웠으면 종료
		if(findEmpty()) return true;
		int row = r;
		int col = c;
		//1~9까지의 숫자 대입하며 가능한지 확인
		for(int i=1;i<=9;i++) {
			if(allClear(row, col, i)) {
				sudoku[row][col]=i;
				if(fill()) {
					return true;
				}
				//백트래킹
				sudoku[row][col]=0;
			}
		}
		return false;
	}
	
	//가로 줄 규칙 판별
	public static boolean garo(int r, int num) {
		for(int i=0;i<9;i++) {
			if(sudoku[r][i]==num) {
				return false;
			}
		}
		return true;
	}
	
	//세로 줄 규칙 판별
	public static boolean sero(int c, int num) {
		for(int i=0;i<9;i++) {
			if(sudoku[i][c]==num) {
				return false;
			}
		}
		return true;
	}

	//3x3 부분집합 규칙 판별
	public static boolean rectangle(int r, int c, int num) {
		int rowStart = 3*(r/3);
		int colStart = 3*(c/3);
		for(int i=rowStart;i<rowStart+3;i++) {
			for(int j=colStart;j<colStart+3;j++) {
				if(sudoku[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean allClear(int r, int c, int num) {
		if(garo(r,num)&&sero(c,num)&&rectangle(r,c,num)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//현재 상황 입력
		for(int i=0;i<9;i++) {
			String str = sc.next();
			for(int j=0;j<9;j++) {
				sudoku[i][j]=str.charAt(j)-'0';
			}
		}
		//채우기 시작
		fill();
		//출력
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println("");
		}
	}
}
