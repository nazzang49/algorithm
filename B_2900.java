package test_190125;

import java.util.Scanner;

//�迭�� ũ�� n, �Լ� ȣ�� Ƚ�� k, �迭�� ������ Ȯ�� Ƚ�� q, Ȯ�� ���̽����� �������� �־��� l�� r�� �־��� ��, �� �������� ��� ����ϱ�
public class B_2900 {

	static int [] A;
	
	public static void something(int jump) {
		int i = 0;
		while(i<A.length) {
			A[i]=A[i]+1;
			i=i+jump;
		}
	}
	
	public static int sum(int l, int r) {
		int sum = 0;
		for(int i=l;i<=r;i++) {
			sum+=A[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10, 6)&&1<=k&&k<=Math.pow(10, 6)) {
			A = new int[n];
			//�Լ� ȣ�� �� ������ ���� �Է�
			for(int i=0;i<k;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<n) {
					something(tmp);
				}
			}
			int q = sc.nextInt();
			int [] ans = new int[q];
			for(int i=0;i<q;i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				ans[i]=sum(l,r);
			}
			//���� ���
			for(int i=0;i<q;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
