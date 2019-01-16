package test_190116;

import java.util.Scanner;

//��� ���� ������ �־��� �� �ڷ� ������ Ŀ���ų�, �۾����ų�, Ŀ���ٰ� �۾����� ������ ������ ������ ������� ������ �ִ� ���� ���ϱ� 
public class B_11054 {
	
	static int [] A;
	
	//������
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
	
	//������(A����� ������ ���� ����)
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
			//���� ���� �Է�
			for(int i=0;i<n;i++) {
				A[i]=sc.nextInt();
			}
			//������� ���������� ������ ����
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
