package solution;

import java.util.Scanner;

//3�� ��� �ڿ��� n�� �־��� ��, �ش� �ڿ����� 3�� ��� 3�� ���ڷ� ǥ���ϴ� ����� �� ���ϱ�
public class Q84 {

	static int n;
	//����� �� ����
	static int cnt = 0;
	
	public static void dfs(int sum, int count) {
		if(sum==n&&count==3) {
			cnt++;
		}else if(sum<n&&count<3) {
			count++;
			for(int i=1;i<=n/3;i++) {
				sum+=i*3;
				dfs(sum, count);
				sum-=i*3;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		//3�� ��� n
		if(3<=n&&n<=3000&&n%3==0) {
			for(int i=1;i<=n/3;i++) {
				dfs(i*3,1);
			}
			System.out.println(cnt);
		}
	}
}
