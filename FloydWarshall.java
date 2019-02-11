package test_190211;

import java.util.Scanner;

//�÷��̵� �ͼ� �˰��� = ��� �������� ��� �������� �̵��� ��, Ư�� ��带 ���İ��ٰ� �����ϰ� �ּ� ����� ���ϴ� �˰���
//ex) 2->3 vs 2->1 and 1->3 �� �� ���� ������ ����
public class FloydWarshall {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=1000) {
			//�ʱⰪ ���� �迭 ���� �� ��� �Է�
			int [][] A = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					A[i][j]=sc.nextInt();
				}
			}
			//��� ��� �迭 ���� �� �ʱⰪ �Է�
			int [][] d = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					d[i][j]=A[i][j];
				}
			}
			//�÷��̵� �ͼ� ����(���� �ݺ���)
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						//k��带 ���� ���� ��ΰ� �� ���� ����� ��(����)
						if(d[i][j]>d[i][k]+d[k][j]) {
							d[i][j]=d[i][k]+d[k][j];
						}
					}
				}
			}
			//���� ���
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(d[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
