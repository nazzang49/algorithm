package solution;

import java.util.Scanner;

//NxM ����� �� �� �־��� �� �� ����� �� ����ϱ�
public class Q128 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=100&&1<=m&&m<=100) {
			int [][] A = new int[n][m];
			int [][] B = new int[n][m];
			int [][] answer = new int[n][m];
					
			//�� ��� ���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					int tmp = sc.nextInt();
					if(Math.abs(tmp)<=100) {
						A[i][j]=tmp;
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					int tmp = sc.nextInt();
					if(Math.abs(tmp)<=100) {
						B[i][j]=tmp;
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					answer[i][j]=A[i][j]+B[i][j];
					System.out.print(answer[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
