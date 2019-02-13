package test_190213;

import java.util.Scanner;

//NxN ����� �־��� ��, ��� ���� (i,j)�� ���� i���� j�� ���� ��ΰ� �ִ��� ���ϴ� ���α׷� �ۼ��ϱ�
public class B_11403 {

	static int n;
	static int [][] map;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=100) {
			map = new int[n][n];
			
			//���� ���� �Է�(1�� ���� O, 0�� ���� X)
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//�÷��̵� �ͼ� Ž��
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map[i][k]==1&&map[k][j]==1) {
							map[i][j]=1;
						}
					}
				}
			}
			
			//���� ���
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
