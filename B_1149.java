package test_181204;

import java.util.Scanner;

//������ �� ��� ������ ��ĥ�� �� �̿��� �������� ���� ���� ĥ�� �� ���ٴ� ������ �־����ٸ� �ּ� ��� ���ϱ�
public class B_1149 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//���� ����
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			//�ּҺ�� ���� ������ dp �迭
			int [] dp = new int[n];
			char [] house = new char[n];
			//�� ���� ����, �ʷ�, �Ķ����� ĥ�� �� �ҿ�Ǵ� ��� 
			int [] R = new int[n];
			int [] G = new int[n];
			int [] B = new int[n];
			for(int i=0;i<n;i++) {
				//��� ����� 1000���� ����
				R[i]=sc.nextInt();
				G[i]=sc.nextInt();
				B[i]=sc.nextInt();
			}
			int min = Integer.MAX_VALUE;
			int k=0;
			while(k<3) {
				if(k==0) {
					dp[0]=R[0];
					house[0]='R';
				}else if(k==1) {
					dp[0]=G[0];
					house[0]='G';
				}else {
					dp[0]=B[0];
					house[0]='B';
				}
				//�� ��°���� dp ����
				for(int i=1;i<n;i++) {
					if(house[i-1]=='R') {
						dp[i]=Math.min(dp[i-1]+G[i], dp[i-1]+B[i]);
						if(dp[i]==dp[i-1]+G[i]) {
							house[i]='G';
						}else if(dp[i]==dp[i-1]+B[i]) {
							house[i]='B';
						}
					}else if(house[i-1]=='B') {
						dp[i]=Math.min(dp[i-1]+R[i], dp[i-1]+G[i]);
						if(dp[i]==dp[i-1]+R[i]) {
							house[i]='R';
						}else if(dp[i]==dp[i-1]+G[i]) {
							house[i]='G';
						}
					}else {
						dp[i]=Math.min(dp[i-1]+B[i], dp[i-1]+R[i]);
						if(dp[i]==dp[i-1]+B[i]) {
							house[i]='B';
						}else if(dp[i]==dp[i-1]+R[i]) {
							house[i]='R';
						}
					}
				}
				if(min>dp[n-1]) {
					min=dp[n-1];
				}
				k++;
			}
			System.out.println(min);
		}
	}
}
