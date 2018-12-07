package solution;

import java.util.Scanner;

//1 or 2 ���� ���̸� ���� ���簢���� Ȱ���Ͽ� ���� ���̰� 2, ���� ���̰� n�� ���簢���� ���� ä�� �� Ȱ���� �� �ִ� ��� ��� ���ϱ�
public class Q23 {

	static int cnt = 0;
	
	//DFS Ž�� �ݺ��ϸ� ���� ���� �����ϴ� ���� Ƚ�� ����
	public static void dfs(int n, int sum) {
		if(sum==n) {
			//����� �� ī��Ʈ+1
			cnt++;
		}else if(sum<n){
			for(int i=0;i<2;i++) {
				if(i==0) {
					dfs(n,sum+1);
				}else {
					dfs(n,sum+2);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=60000) {
			dfs(n,0);
			System.out.println(cnt%1000000007);
		}
	}
}
