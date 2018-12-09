package solution;

import java.util.Scanner;

//��� 2���� �迭, �ش� �迭�� ��� ���ڰ� �־��� �� 1������ �̷���� ���簢�� ���� �߿� ���� �ִ밪 ���ϱ�
public class Q24 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		if(1<=r&&r<=1000&&1<=c&&c<=1000) {
			int [][] map = new int[r][c];
			int [][] dp = new int[r][c];
			//�Է�
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					int tmp = sc.nextInt();
					if(tmp==0||tmp==1) {
						map[i][j]=tmp;
					}
				}
			}
			//Ž��
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					int min = 0;
					if(map[i][j]==1) {
						if(i==0||j==0) {
							dp[i][j]=1;
						}else {
							//����, ���� ��(�밢��), ���� ���� ������ �� �ּҰ� ����
							min = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
							dp[i][j]=min+1;
						}
						max = Math.max(max, dp[i][j]);
					}
				}
			}
			System.out.println(max*max);
		}
	}
}
