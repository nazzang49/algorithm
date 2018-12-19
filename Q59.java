package solution;

import java.util.Scanner;

//�Է°��� �� �� �̻��� �ڿ��� ������ ��Ÿ���� ��� ����� ���� ���Ͻÿ�
public class Q59 {

	static int n;
	static int cnt = 0;
	
	public static void dfs(int end, int sum) {
		if(sum==n) {
			cnt++;
		}else if(sum<n) {
			for(int i=end;i>=1;i--) {
				sum+=i;
				dfs(i,sum);
				//�� ���� �ݺ��� ���� �ʱ�ȭ �۾�
				sum-=i;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=50) {
			for(int i=1;i<n;i++) {
				dfs(i,i);
			}
			System.out.println(cnt);
		}
	}
}
