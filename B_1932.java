package test_181204;

import java.util.Scanner;

//이진트리 형태로 주어진 입력값에 대해 깊이 형태로 노드를 탐색하며 누적한 값 중 최대값 구하기
public class B_1932 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] dp = new int[n][n];
		dp[0][0]=sc.nextInt();
		
		if(1<=n&&n<=500) {
			for(int i=1;i<n;i++) {
				for(int j=0;j<i+1;j++) {
					int tmp = sc.nextInt();
					//가장 왼쪽(idx=0)
					if(j==0) {
						dp[i][j]=dp[i-1][j]+tmp;
					}
					//가장 오른쪽(idx=i)
					else if(i==j) {
						dp[i][j]=dp[i-1][j-1]+tmp;
					}
					//그 외 내부(그 전 노드 두군데서 접근 가능하므로 최대값 고려)
					else {
						dp[i][j]=Math.max(dp[i-1][j-1]+tmp, dp[i-1][j]+tmp);
					}
				}
			}
			int max=0;
			//마지막 줄만 검사
			for(int i=0;i<dp[n-1].length;i++) {
				if(max<dp[n-1][i]) {
					max=dp[n-1][i];
				}
			}
			System.out.println(max);
		}
	}
}
