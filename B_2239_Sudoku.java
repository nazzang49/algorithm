package test_190326;

import java.util.Scanner;

//�Է����� �־��� Ǯ�� �� ������ �ϼ��ϱ�(9x9)
public class B_2239_Sudoku {

	static int [][] sudoku = new int[9][9];
	//����ִ� ĭ�� x,y��ǥ ���� ����
	static int r;
	static int c;
	
	//��� �ִ� �� Ž��
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
	
	//ä���ֱ�(DFS + ��Ʈ��ŷ)
	public static boolean fill() {
		//��� ä������ ����
		if(findEmpty()) return true;
		int row = r;
		int col = c;
		//1~9������ ���� �����ϸ� �������� Ȯ��
		for(int i=1;i<=9;i++) {
			if(allClear(row, col, i)) {
				sudoku[row][col]=i;
				if(fill()) {
					return true;
				}
				//��Ʈ��ŷ
				sudoku[row][col]=0;
			}
		}
		return false;
	}
	
	//���� �� ��Ģ �Ǻ�
	public static boolean garo(int r, int num) {
		for(int i=0;i<9;i++) {
			if(sudoku[r][i]==num) {
				return false;
			}
		}
		return true;
	}
	
	//���� �� ��Ģ �Ǻ�
	public static boolean sero(int c, int num) {
		for(int i=0;i<9;i++) {
			if(sudoku[i][c]==num) {
				return false;
			}
		}
		return true;
	}

	//3x3 �κ����� ��Ģ �Ǻ�
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
		//���� ��Ȳ �Է�
		for(int i=0;i<9;i++) {
			String str = sc.next();
			for(int j=0;j<9;j++) {
				sudoku[i][j]=str.charAt(j)-'0';
			}
		}
		//ä��� ����
		fill();
		//���
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println("");
		}
	}
}
