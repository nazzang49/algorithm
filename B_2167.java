package test_190129;

import java.util.Scanner;

//2���� �迭�� �־��� ��, i��j������ x��y������ �迭�� ����Ǿ� �ִ� ������ ���� ���ϴ� ���α׷� �ۼ��ϱ�
public class B_2167 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=300&&m<=300) {
			int [][] map = new int[n+1][m+1];
			//�ڿ��� �Է�
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int k = sc.nextInt();
			int [] ans = new int[k];
			while(k>0) {
				//�ΰ��� ����Ʈ �Է�
				int a = sc.nextInt();
				int b = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int i=a;i<=x;i++) {
					for(int j=b;j<=y;j++) {
						ans[3-k]+=map[i][j];
					}
				}
				k--;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
