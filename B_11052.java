package test_190116;

import java.util.Scanner;

//카드팩 Pn(n개가 들어있는 카드팩)의 비용이 주어질 때 가장 높은 확률로 카드를 뽑을 시 지불해야 하는 비용의 최댓값 구하기
public class B_11052 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//구매하고자 하는 카드의 갯수
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			int [] p = new int[n+1];
			int [] dp = new int[n+1];
			//카드팩별 비용 입력
			for(int i=1;i<=n;i++) {
				p[i]=sc.nextInt();
			}
			//DP 실행
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=i;j++) {
					dp[i]=Math.max(dp[i], dp[i-j]+p[j]);
				}
			}
			System.out.println(dp[n]);
		}
	}
}
