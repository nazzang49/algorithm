package test_190326;

import java.util.Scanner;

//n+1일째에 퇴사하는 직원이 퇴사 전까지 최대한 많은 상담 매출을 올리기 위한 경우의 수 구하기(오늘 or 내일 중 선택)
public class B_14501 {

	//상담 가능한 총 일수
	static int n;
	//상담하는데 걸리는 일수
	static int [] T;
	//상담 선택 시 얻는 매출
	static int [] P;
	static int [] dp;
	
	public static int profit(int day) {
		//기간 초과
		if(day==n-1) return 0;
		//마지막 날
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
			//상담 일수 및 상담 금액 입력
			for(int i=0;i<n;i++) {
				T[i]=sc.nextInt();
				P[i]=sc.nextInt();
			}
			//DP
			System.out.println(profit(0));
		}
	}
}
