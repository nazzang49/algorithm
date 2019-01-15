package test_190115;

import java.util.Scanner;

//서쪽과 동쪽을 가르는 강물이 흐르는 곳에, n개의 포인트와 m개의 포인트를 잇는 n개의 다리를 건설할 때 이을 수 있는 경우의 수 구하기(다리끼리는 겹칠 수 없음)
//n과 m을 각각 남아 있는 서쪽과 동쪽의 포인트로 생각하는 것이 주요
public class B_1010 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] ans = new int[t];
		
		int k = 0;
		while(k<t) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int DP[][] = new int[n+1][m+1];
		    
			//n=m일 때, 1개의 다리 놓을 수 있음
			//놓아야하는 다리의 개수가 n, 남아있는 포인트 개수가 m이라면 n=m과 같을 시 경우의 수는 반드시 1
			for(int i=1; i<=n; i++)
		    	DP[i][i] = 1;
		    for(int i=1; i<=m; i++)
		    	DP[1][i] = i;
		    	  
		    for(int i=2; i<=n; i++)
		    	for(int j=3; j<=m; j++)
		    		DP[i][j] = DP[i][j-1] + DP[i-1][j-1];
		    
			ans[k]=DP[n][m];
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
