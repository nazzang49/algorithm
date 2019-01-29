package test_190129;

import java.util.Scanner;

//백준이가 n일 동안 적절히 상담을 완료했을 때, 얻을 수 있는 최대 수익 구하기
public class B_14501 {

	static int n;
	static int [] T;
	static int [] P;
	static int [] dp;
	
	public static int retire(int day) {
		if(day==n+1) return 0;
		//범위 벗어나면
		if(day>n+1) return -1111111;
		if(dp[day]!=0) return dp[day];
		//다음날과 오늘의 상담을 맡을 시 다음으로 맡을 수 있는 가장 빠른 상담의 수익 중 큰 값 반환
		else return Math.max(retire(day+1), retire(day+T[day])+P[day]);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=15) {
			T = new int[n+1];
			P = new int[n+1];
			dp = new int[n+1];
			//상담 완료까지 걸리는 기간 및 얻을 수 있는 수익 입력
			for(int i=1;i<=n;i++) {
				T[i]=sc.nextInt();
				P[i]=sc.nextInt();
			}
			sc.close();
			//1일부터 탐색 시작
			System.out.println(retire(1));
		}
	}
}
