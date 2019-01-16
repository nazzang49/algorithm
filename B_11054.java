package test_190116;

import java.util.Scanner;

//어떠한 수의 집합이 주어질 때 뒤로 갈수록 커지거나, 작아지거나, 커지다가 작아지는 세가지 경향을 가지는 바이토닉 수열의 최대 길이 구하기 
public class B_11054 {
	
	static int [] A;
	
	//순방향
	public static int [] lis() {
		
		int dp[] = new int[A.length];
		
		for(int i = 0; i<dp.length; i++){
			dp[i] = 1;
			for(int j = 0; j<i; j++){
				if(A[i] > A[j] && dp[j]+1 > dp[i]){
					dp[i]++;
				}
			}
		}
		return dp;
	}
	
	//역방향(A행렬의 끝에서 부터 조사)
	public static int [] rev() {
		
		int dp[] = new int[A.length];
		
		for(int i = A.length-1; i>=0; i--){
			dp[i] = 1;
			for(int j = A.length-1; j>=i; j--){
				if(A[i] > A[j] && dp[j]+1 > dp[i]){
					dp[i]++;
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			A = new int[n];
			//수의 집합 입력
			for(int i=0;i<n;i++) {
				A[i]=sc.nextInt();
			}
			//정방향과 역방향으로 나누어 생각
			int [] lis = lis();
			int [] rev = rev();
			
			int max = 0;
			for(int i=0;i<n;i++) {
				if(max<lis[i]+rev[i]) {
					max=lis[i]+rev[i];
				}
			}
			System.out.println(max-1);
		}
	}
}
