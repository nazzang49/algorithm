package solution;

import java.util.Scanner;

//�׸��� ��, �׸��� ����, �׸��� ����, �׸��� �ȸ� �� �ִ� �ּ� ���� �κ��� �־��� �� �� �Ǹ� ������ �ִ밡 �Ǵ� ��� ���ϱ�
public class Q70 {

	static int n;
	static int s;
	static int [] height;
	static int [] price;
	static int max = Integer.MIN_VALUE;
	
	public static void dfs(int start, int sum) {
		for(int i=start+1;i<n;i++) {
			//���� ���� �׸��� �ּ� ���� ���̺��� ū�� üũ
			if(height[i]-height[start]>=s) {
				sum+=price[i];
				dfs(i,sum);
				sum-=price[i];
			}
		}
		if(sum>=max) {
			max=sum;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
	
		if(1<=n&&n<=300000) {
			height = new int[n];
			price = new int[n];
			//�Է�
			for(int i=0;i<n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(1<=tmp1&&tmp1<=20000000&&s<=tmp1&&1<=tmp2&&tmp2<=1000) {
					height[i]=tmp1;
					price[i]=tmp2;
				}
			}
			//�������� ����
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					if(height[i]>=height[j]) {
						int tmp1 = height[i];
						int tmp2 = price[i];
						height[i]=height[j];
						price[i]=price[j];
						height[j]=tmp1;
						price[j]=tmp2;
					}
				}
			}
			//Ž��
			for(int i=0;i<n;i++) {
				dfs(i,price[i]);
			}
			System.out.println(max);
		}
	}
}
