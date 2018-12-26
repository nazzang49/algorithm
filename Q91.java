package solution;

import java.util.Scanner;

//�־��� ���ڸ� ������ �Ҽ��� ���ո����� ǥ���� �� �ִ� ����� �� ���ϱ�
public class Q91 {

	//������ �����ϴ� ����� ��
	static int cnt = 0;
	static int n;

	//�Ҽ����� �Ǻ��ϴ� �޼ҵ�
	public static boolean sosoo(int n) {
		boolean flag = false;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				flag=true;
				break;
			}
		}
		//�Ҽ����
		if(!flag) {
			return true;
		}
		return false;
	}
	
	//n�� ���� �����鼭 �Ҽ��� ������ �����ϸ� Ž��
	public static void dfs(int now, int sum) {
		if(sum==n) {
			cnt++;
		}else if(sum<n) {
			int i=now;
			boolean flag = false;
			while(i>=2) {
				flag = sosoo(i);
				if(flag) {
					sum+=i;
					dfs(i,sum);
					sum-=i;
				}
				i--;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(2<=n&&n<=40000) {
			int [] dp = new int[n];
			int i=n;
			boolean flag = false;
			while(i>=2) {
				flag = sosoo(i);
				if(flag) {
					dfs(i,i);
				}
				i--;
			}
			System.out.println((int)cnt%123456789);
		}
	}
}
