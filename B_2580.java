package test_190221;

import java.util.Scanner;

//�� ���� ���ڸ��� �����ϴ� 9x9 ������ ���� �־��� ��, �ش� ��ĭ�� �˸��� ���ڸ� ����ִ� ���α׷� �ۼ��ϱ�

//(������ ���� ��Ģ)
//1) ���� �࿡ ������ ���� ���� X
//2) ���� ���� ������ ���� ���� X
//3) ���� �κ����տ� ������ ���� ���� X
public class B_2580 {

	static int [][]  map = new int[9][9];
	static int row = 0;
	static int col = 0;
	
	//���� ó������ ���� �� ����
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
	
	//���� ��Ģ
	public static boolean garo(int r, int value) {
		for(int i=0;i<9;i++) {
			if(map[r][i]==value) {
				return false;
			}
		}
		return true;
	}
	
	//���� ��Ģ
	public static boolean sero(int c, int value) {
		for(int i=0;i<9;i++) {
			if(map[i][c]==value) {
				return false;
			}
		}
		return true;
	}

	//�κ����� ��Ģ
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
	
	//������ ��Ģ
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
		
		//���� �� ������ ���Ҵٸ�
		int r = row;
		int c = col;
		
		//1~9���� ���� �־�鼭 ��Ģ �����ϴ��� Ȯ��
		for(int i=1;i<=9;i++) {
			//��Ģ �����ϸ� �� ���� �� ���� Ž��
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
		//���� ������ �� �Է�
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//DFS Ž�� ����
		fill();
		//���� ���
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
