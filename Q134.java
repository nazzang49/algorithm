package solution;

import java.util.Scanner;

//n��° �Ǻ���ġ ���� ���ϴ� ���α׷� �ۼ��ϱ�
public class Q134 {

	//(��� 1 - ����Լ�)
	public static int fibo(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return fibo(n-2)+fibo(n-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//20���� ����
		if(1<=n&&n<=20) {
			System.out.println(fibo(n));
			//(��� 2 - ���� ���α׷���)
			int [] dp = new int[n+1];
			dp[0]=0;
			dp[1]=1;
			
			for(int i=2;i<=n;i++) {
				dp[i]=dp[i-2]+dp[i-1];
			}
			System.out.println(dp[n]);
		}
	}
}
