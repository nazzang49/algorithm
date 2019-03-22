package test_190322;

import java.util.Arrays;
import java.util.Scanner;

//��� ���ÿ� ���� A���� B�� �̵��ϴ� �ּ� ��� ���ϱ�
public class B_11404 {

	//���� ����
	static int n;
	//���� ����
	static int m;
	//���� ���
	static int [][] dis;
	//���� �迭
	static int [][] ans;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100000) {
			ans = new int[n+1][n+1];
			dis = new int[n+1][n+1];
			
			//��� �ʱ�ȭ
			for(int i=1;i<=n;i++) {
				Arrays.fill(dis[i], 10001);
			}
			
			//��� �Է�
			for(int i=0;i<m;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int cost = sc.nextInt();
				//�� ���� ��� �Է� = ����
				dis[s][e]=Math.min(dis[s][e], cost);
			}
			
			//�÷��̵� �ͼ� ����
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//i���� j�� ���̷�Ʈ �̵��� ���� ��� < k ������ ���� �̵��ϴ� ����� ���
						if(dis[i][j]>dis[i][k]+dis[k][j]) {
							dis[i][j]=dis[i][k]+dis[k][j];
						}
					}
				}
			}
			
			//���� ���
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j) System.out.print(0+" ");
					else System.out.print(dis[i][j]+" ");
				}
				System.out.println();
			}
		}	
	}
}
