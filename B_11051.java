package test_190219;

import java.util.Scanner;

//���װ�� nCk�� 10007�� ���� ������ ����ϱ�(k==0�̸�, nCk�� ������ 1)
public class B_11051 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=1000&&k<=n) {
			int [][] d = new int[1001][1001];
			for(int i=1;i<=n;i++) {
				for(int j=0;j<=i;j++) {
					if(j==0||i==j) {
						d[i][j]=1;
					}else {
						d[i][j]=d[i-1][j-1]+d[i-1][j];
					}
				}
			}
			System.out.println(d[n][k]);
		}	
	}
}
