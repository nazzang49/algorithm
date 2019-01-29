package test_190129;

import java.util.Scanner;

//�����̰� n�� ���� ������ ����� �Ϸ����� ��, ���� �� �ִ� �ִ� ���� ���ϱ�
public class B_14501 {

	static int n;
	static int [] T;
	static int [] P;
	static int [] dp;
	
	public static int retire(int day) {
		if(day==n+1) return 0;
		//���� �����
		if(day>n+1) return -1111111;
		if(dp[day]!=0) return dp[day];
		//�������� ������ ����� ���� �� �������� ���� �� �ִ� ���� ���� ����� ���� �� ū �� ��ȯ
		else return Math.max(retire(day+1), retire(day+T[day])+P[day]);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=15) {
			T = new int[n+1];
			P = new int[n+1];
			dp = new int[n+1];
			//��� �Ϸ���� �ɸ��� �Ⱓ �� ���� �� �ִ� ���� �Է�
			for(int i=1;i<=n;i++) {
				T[i]=sc.nextInt();
				P[i]=sc.nextInt();
			}
			sc.close();
			//1�Ϻ��� Ž�� ����
			System.out.println(retire(1));
		}
	}
}
