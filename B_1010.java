package test_190115;

import java.util.Scanner;

//���ʰ� ������ ������ ������ �帣�� ����, n���� ����Ʈ�� m���� ����Ʈ�� �մ� n���� �ٸ��� �Ǽ��� �� ���� �� �ִ� ����� �� ���ϱ�(�ٸ������� ��ĥ �� ����)
//n�� m�� ���� ���� �ִ� ���ʰ� ������ ����Ʈ�� �����ϴ� ���� �ֿ�
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
		    
			//n=m�� ��, 1���� �ٸ� ���� �� ����
			//���ƾ��ϴ� �ٸ��� ������ n, �����ִ� ����Ʈ ������ m�̶�� n=m�� ���� �� ����� ���� �ݵ�� 1
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
