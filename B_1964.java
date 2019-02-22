package test_190131;

import java.util.Scanner;

//오각형의 한변에 점진적으로 점을 찍어 나갈 때, n단계에서 찍힌 모든 점의 갯수 출력하기
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
