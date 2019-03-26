package test_190326;

import java.util.Scanner;

//n+1��°�� ����ϴ� ������ ��� ������ �ִ��� ���� ��� ������ �ø��� ���� ����� �� ���ϱ�(���� or ���� �� ����)
public class B_14501 {

	//��� ������ �� �ϼ�
	static int n;
	//����ϴµ� �ɸ��� �ϼ�
	static int [] T;
	//��� ���� �� ��� ����
	static int [] P;
	static int [] dp;
	
	public static int profit(int day) {
		//�Ⱓ �ʰ�
		if(day==n-1) return 0;
		//������ ��
		if(day>=n) return -111111;
		if(dp[day]!=0) return dp[day];
		else return dp[day]=Math.max(profit(day+1), P[day]+profit(day+T[day]));
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=15) {
			T = new int[n];
			P = new int[n];
			dp = new int[n];
			//��� �ϼ� �� ��� �ݾ� �Է�
			for(int i=0;i<n;i++) {
				T[i]=sc.nextInt();
				P[i]=sc.nextInt();
			}
			//DP
			System.out.println(profit(0));
		}
	}
}
