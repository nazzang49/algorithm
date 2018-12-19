package solution;

import java.util.Scanner;

//9x9 ũ���� ������ �ǿ��� ��� ĭ�� ���ڰ� �ԷµǾ� ���� ��, ��Ģ�� ���� ������ ���� �ϼ��ϰ� ����ϱ�
public class Q65 {

	static int [][] map = new int[10][10];
	//���� ��� �ִ� ��ġ ���� ����
	static int cRow = 0;
	static int cCol = 0;
	
	//���� �� �ߺ� üũ
	public static boolean chkRow(int n, int r) {
		for(int i=1;i<=9;i++) {
			if(map[r][i]==n) {
				return false;
			}
		}
		return true;
	}

	//���� �� �ߺ� üũ
	public static boolean chkCol(int n, int c) {
		for(int i=1;i<=9;i++) {
			if(map[i][c]==n) {
				return false;
			}
		}
		return true;
	}
	
	//�ڽ� �ߺ� üũ
	//Math.ceil(x) -> x�� ���� �����鼭 ū ��
	public static boolean chkBox(int n, int r, int c) {
		//�ڽ��� ���۵Ǵ� 1, 4, 7��° ��� �� �ǹ�
		int row = ((int) Math.ceil(r / 3.0) - 1) * 3 + 1;
	    int col = ((int) Math.ceil(c / 3.0) - 1) * 3 + 1;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	        	//�ߺ��� ������ false ��ȯ
	            if (map[row + i][col + j] == n) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	//���� ��, ���� ��, ���� ��ġ�� ���� �ڽ� �� �˻縦 ���� ��� �ִ� ���� �Է� �������� üũ
	public static boolean chkAll(int n, int r, int c) {
		if(chkRow(n, r)&&chkCol(n, c)&&chkBox(n, r, c)) {
			return true;
		}
		return false;
	}
	
	//������ ��� �ִ� ĭ�� �ִ��� Ȯ��
	public static boolean findEmpty() {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;i++) {
				if(map[i][j]==0) {
					//����ִ� ���� �ִٸ� �ش� ��ġ ����
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
		
		//�� �̻� �� ���� ���ٸ�
		if(findEmpty()) {
			return true;
		}
		
		r=cRow;
		c=cCol;
		
		for(int i=1;i<=9;i++) {
			//���� ��, ���� ��, �ڽ� üũ�� ��� ����ϸ�
			if(chkAll(i,r,c)) {
				map[r][c]=i;
				//����Լ� ȣ��
				if(fill()) {
					return true;
				}
			}
			//������ ��� �״�� ��ĭ(0)
			map[r][c]=0;
		}
		//��Ʈ��ŷ
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//�Է�
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				int tmp = sc.nextInt();
				//1���� 9������ ���ڸ� �Է� ����
				if(1<=tmp&&tmp<=9) {
					map[i][j]=tmp;
				}
			}
		}
		//Ž�� ����
		fill();
		//���
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
