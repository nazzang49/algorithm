package test_190207;

import java.util.Scanner;

//�� ���� ���ڿ��� �־��� ��, ���� ���� �κ� ������ ���̿� �ش� ���ڿ� ����ϱ�
public class B_9252 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		if(str1.length()<=1000&&str2.length()<=1000) {
			int [][] dp = new int[str1.length()+1][str2.length()+1];
			for(int i=1;i<=str1.length();i++) {
				for(int j=1;j<=str2.length();j++) {
					if(str1.charAt(i-1)==str2.charAt(j-1)) {
						dp[i][j]=dp[i-1][j-1]+1;
					}else {
						dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			System.out.println(dp[str1.length()][str2.length()]);
		}
	}
}
