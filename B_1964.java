package test_190131;

import java.util.Scanner;

//�������� �Ѻ��� ���������� ���� ��� ���� ��, n�ܰ迡�� ���� ��� ���� ���� ����ϱ�
public class B_1964 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=10000000) {
			int [] dp = new int[n+1];
			dp[1]=5;
			for(int i=2;i<=n;i++) {
				dp[i]=(dp[i-1]+(i+1)*3-2)%45678;
			}
			System.out.println(dp[n]);
		}
	}
}
