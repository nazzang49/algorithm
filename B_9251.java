package test_190131;

import java.util.Scanner;

//두 수열이 주어질 때, 두 수열 내 있는 최장 공통 부분수열(LCS)의 길이 출력하기
public class B_9251 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		//입력된 두 수열의 길이는 최대 1000
		if(A.length()<=1000&&B.length()<=1000) {
			int [][] dp = new int[A.length()+1][B.length()+1];
			//DP 실행(두 수열의 각 문자 추출하여 서로 비교)
			for(int i=1;i<=A.length();i++) {
				char a = A.charAt(i-1);
				for(int j=1;j<=B.length();j++) {
					char b = B.charAt(j-1);
					//특정 지점의 인덱스끼리 서로 비교할 때, 그 이전까지의 최장 길이 정보를 유지할 것인지 갱신할 것인지 검사
					if(a==b) dp[i][j]=dp[i-1][j-1]+1;
					else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			System.out.println(dp[A.length()][B.length()]);
		}
	}
}
