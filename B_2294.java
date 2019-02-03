package test_190203;

import java.util.Arrays;
import java.util.Scanner;

//���� ���ų� �ٸ� ������ ��ġ�� n�� �־��� ��, ������ �������� �� ���� k���� �ǵ��� �ϴ� ���� ��� ���� �ּҰ� ���ϱ�
public class B_2294 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=100&&k<=1000) {
			//������ ��ġ �Է�
			int [] coin = new int[n];
			for(int i=0;i<n;i++) {
				coin[i]=sc.nextInt();
			}
			//DP ����
			int [] dp = new int[k+1];
			Arrays.fill(dp, 1000001);
			dp[0]=0;
			//�� �������� ���� ������ ��ġ�� �ش��ϸ� ��� ���� ����
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
