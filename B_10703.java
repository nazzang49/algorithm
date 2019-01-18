package test_190118;

import java.util.Scanner;

//2���� �迭�� ������ x ����, �ϴ��� . ����, ���� # �������� �־��� �� ������ ���� �������� �� �� ��� ����ϱ�
public class B_10703 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		if(3<=r&&r<=3000&&3<=c&&c<=3000) {
			char [][] map = new char[r][c];
			//���� ������ ���� ���ڿ��� �Է�
			for(int i=0;i<r;i++) {
				String str = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			//�� �������� �̵��� �� �ִ� �ִ� ĭ�� ���ϱ�(���� ����)
			int maxMove = Integer.MAX_VALUE;
			for(int i=0;i<c;i++) {
				int cnt = 0;
				//������ ���� Ž�� ����
				for(int j=r-1;j>=0;j--) {
					//������ �������� �ϴ��̸�
					if(map[j][i]=='.') {
						cnt++;
					}
					//X�� ������ ���� �ִ� �̵� ������ ĭ�� ��
					else if(map[j][i]=='X') {
						if(maxMove>cnt) {
							maxMove=cnt;
						}
						break;
					}
				}
			}
			System.out.println(maxMove);
			//������ �̵� �ݿ�
			for(int i=0;i<c;i++) {
				for(int j=r-1;j>=0;j--) {
					if(map[j][i]=='X') {
						map[j+maxMove][i]='X';
						map[j][i]='.';
					}
				}
			}
			//���� ���
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
