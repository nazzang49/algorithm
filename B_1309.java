package test_190201;

import java.util.Scanner;

//가로로 두칸, 세로로 n칸인 동물원 우리가 있을 때 규칙에 맞게(가로 혹은 세로로 붙어있게 할 수 없음) 사자를 배치하는 모든 경우의 수 출력하기
public class B_1309 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100000) {
			//최대 n마리 배치 가능(격자 무늬 형태로 배치 가능)
			int [][] dp = new int[n+1][3];
			
			//오른쪽 왼쪽 모두 빈 경우(0)
			dp[1][0]=1;
			//왼쪽만 찬 경우(1)
			dp[1][1]=1;
			//오른쪽만 찬 경우(2)
			dp[1][2]=1;
			
			for(int i=2;i<=n;i++) {
				dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
				dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
				dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
			}
			System.out.println(dp[n][0]+dp[n][1]+dp[n][2]);
		}
	}
}
