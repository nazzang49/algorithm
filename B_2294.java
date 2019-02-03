package test_190203;

import java.util.Arrays;
import java.util.Scanner;

//서로 같거나 다른 동전의 가치가 n개 주어질 때, 적절한 조합으로 그 합이 k원이 되도록 하는 동전 사용 갯수 최소값 구하기
public class B_2294 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=100&&k<=1000) {
			//동전의 가치 입력
			int [] coin = new int[n];
			for(int i=0;i<n;i++) {
				coin[i]=sc.nextInt();
			}
			//DP 실행
			int [] dp = new int[k+1];
			Arrays.fill(dp, 1000001);
			dp[0]=0;
			//각 동전마다 조합 가능한 가치에 해당하면 사용 갯수 갱신
			for(int i=0;i<n;i++) {
				for(int j=coin[i];j<=k;j++) {
					dp[j]=Math.min(dp[j], dp[j-coin[i]]+1);
				}
			}
			if(dp[k]==1000001) System.out.println(-1);
			else System.out.println(dp[k]);
			sc.close();
		}
	}
}
