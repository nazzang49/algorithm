package solution;

import java.util.Scanner;

//9x9 크기의 스도쿠 판에서 몇몇 칸에 숫자가 입력되어 있을 때, 규칙에 따라 스도쿠 판을 완성하고 출력하기
public class Q65 {

	static int [][] map = new int[10][10];
	//현재 비어 있는 위치 담을 변수
	static int cRow = 0;
	static int cCol = 0;
	
	//가로 줄 중복 체크
	public static boolean chkRow(int n, int r) {
		for(int i=1;i<=9;i++) {
			if(map[r][i]==n) {
				return false;
			}
		}
		return true;
	}

	//세로 줄 중복 체크
	public static boolean chkCol(int n, int c) {
		for(int i=1;i<=9;i++) {
			if(map[i][c]==n) {
				return false;
			}
		}
		return true;
	}
	
	//박스 중복 체크
	//Math.ceil(x) -> x와 가장 가까우면서 큰 수
	public static boolean chkBox(int n, int r, int c) {
		//박스가 시작되는 1, 4, 7번째 행과 열 의미
		int row = ((int) Math.ceil(r / 3.0) - 1) * 3 + 1;
	    int col = ((int) Math.ceil(c / 3.0) - 1) * 3 + 1;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	        	//중복이 있으면 false 반환
	            if (map[row + i][col + j] == n) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	//가로 줄, 세로 줄, 현재 위치가 속한 박스 내 검사를 통해 비어 있는 곳에 입력 가능한지 체크
	public static boolean chkAll(int n, int r, int c) {
		if(chkRow(n, r)&&chkCol(n, c)&&chkBox(n, r, c)) {
			return true;
		}
		return false;
	}
	
	//여전히 비어 있는 칸이 있는지 확인
	public static boolean findEmpty() {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;i++) {
				if(map[i][j]==0) {
					//비어있는 곳이 있다면 해당 위치 저장
					cRow = i;
					cCol = j;
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean fill() {
		int r = 0;
		int c = 0;
		
		//더 이상 빈 곳이 없다면
		if(findEmpty()) {
			return true;
		}
		
		r=cRow;
		c=cCol;
		
		for(int i=1;i<=9;i++) {
			//가로 줄, 세로 줄, 박스 체크를 모두 통과하면
			if(chkAll(i,r,c)) {
				map[r][c]=i;
				//재귀함수 호출
				if(fill()) {
					return true;
				}
			}
			//실패인 경우 그대로 빈칸(0)
			map[r][c]=0;
		}
		//백트래킹
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//입력
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				int tmp = sc.nextInt();
				//1부터 9까지의 숫자만 입력 가능
				if(1<=tmp&&tmp<=9) {
					map[i][j]=tmp;
				}
			}
		}
		//탐색 실행
		fill();
		//출력
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
