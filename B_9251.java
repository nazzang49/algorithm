package test_190131;

import java.util.Scanner;

//�� ������ �־��� ��, �� ���� �� �ִ� ���� ���� �κм���(LCS)�� ���� ����ϱ�
public class B_9251 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		//�Էµ� �� ������ ���̴� �ִ� 1000
		if(A.length()<=1000&&B.length()<=1000) {
			int [][] dp = new int[A.length()+1][B.length()+1];
			//DP ����(�� ������ �� ���� �����Ͽ� ���� ��)
			for(int i=1;i<=A.length();i++) {
				char a = A.charAt(i-1);
				for(int j=1;j<=B.length();j++) {
					char b = B.charAt(j-1);
					//Ư�� ������ �ε������� ���� ���� ��, �� ���������� ���� ���� ������ ������ ������ ������ ������ �˻�
					if(a==b) dp[i][j]=dp[i-1][j-1]+1;
					else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			System.out.println(dp[A.length()][B.length()]);
		}
	}
}
