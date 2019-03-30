package test_190330;

import java.util.Arrays;
import java.util.Scanner;

//������ ���� n�� ���� ���� ���� ���� �� ��� m���� �־��� ��, Ư�� ���ǰ� ���� �� ���� ������ ���� ����ϱ�
public class B_10159 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=100&&m<=2000) {
			int [][] connected = new int[n+1][n+1];
			//�迭 �ʱ�ȭ
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i!=j) connected[i][j]=10001;
				}
			}
			//���� ���� �Է�
			for(int i=0;i<m;i++) {
				connected[sc.nextInt()][sc.nextInt()]=1;
			}
			//�÷��̵� �ͼ� �˰���
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						connected[i][j]=Math.min(connected[i][j], connected[i][k]+connected[k][j]);
					}
				}
			}
			//���� ���
			for(int i=1;i<=n;i++) {
				int cnt = 0;
				for(int j=1;j<=n;j++) {
					if(connected[i][j]==10001&&connected[j][i]==10001) cnt++;
				}
				System.out.println(cnt);
			}
		}
	}
}
