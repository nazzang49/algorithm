package solution;

import java.util.Scanner;

//�ﰢ�� ����� Ʈ�� ������ �迭�� �־��� ��, ��� ��� �� �� ���� �ִ밪�� ��� ����ϱ�
public class Q28 {

	static int max = Integer.MIN_VALUE;
	static int [][] dp;
	
	public static void result(int [][] tree) {
		for(int i=1;i<tree.length;i++) {
			for(int j=0;j<tree[i].length;j++) {
				//���� ����
				if(j==0) {
					dp[i][0]=dp[i-1][0]+tree[i][0];
				}
				//���� ������
				else if(j==i) {
					dp[i][j]=dp[i-1][j-1]+tree[i][j];
				}
				//�� �� ���� ���
				else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+tree[i][j];
				}
			}
		}
		int result = 0;
		for(int i=0;i<dp[tree.length-1].length;i++) {
			result=dp[tree.length-1][i];
			if(max<=result) {
				max=result;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int level = sc.nextInt();
		
		if(1<=level&&level<=50) {
			int [][] tree = new int[level][level];
			dp = new int[level][level];
			
			//�Է�
			for(int i=0;i<tree.length;i++) {
				for(int j=0;j<=i;j++) {
					int tmp = sc.nextInt();
					if(0<=tmp&&tmp<=9999) {
						tree[i][j]=tmp;
						if(i==0||j==0) {
							dp[i][j]=tmp;
						}
					}
				}
			}
			//Ž��
			result(tree);
			System.out.println(max);
		}
	}
}
