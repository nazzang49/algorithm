package test_190213;

import java.util.Scanner;

//1�� ��ǻ�Ͱ� ���̷����� �ɷ��� ��, ��ǻ�� �� ���� ������ �־��� �� ���̷����� ���� �ɸ��� �Ǵ� ��ǻ�� ��� ����ϱ�
public class B_2606 {

	//��ü ���
	static int n;
	//���� ����Ǿ� �ִ� ������ ��
	static int m;
	//���� ����� ��ǻ�� ��ȣ ���� �迭
	static boolean [][] A;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100) {
			A = new boolean[n+1][n+1];
			//��ǻ�� ���� �Է�(���� ����)
			for(int i=1;i<=m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				A[tmp1][tmp2]=A[tmp1][tmp2]=true;
			}
			//�÷��̵� �ͼ� Ž��
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//Ư�� ��带 ���� �ٸ� ���� ������ �� �ִ� ����(�� �ΰ��� ��� ���� ����Ǿ� �ִ� ������ ����)
						if(A[i][k]&&A[k][j]) {
							A[i][j]=true;
						}
					}
				}
			}
			int cnt = 0;
			for(int i=2;i<=n;i++) {
				if(A[1][i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
