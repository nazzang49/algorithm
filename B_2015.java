package test_190125;

import java.util.Scanner;

//��� ������ �迭�� �־��� ��, �κ����� �Է°� k�� �Ǵ� ��� ����� �� ����ϱ�
public class B_2015 {

	static int [] A;
	
	public static int result(int n, int k) {
		int cnt = 0;
		for(int i=0;i<A.length;i++) {
			int sum = 0;
			boolean flag = false;
			for(int j=i;j<i+n&&i+n<=A.length;j++) {
				flag = true;
				sum+=A[j];
			}
			//�κ����� ���� ���� ���� cnt ����
			if(sum==k&&flag) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;
		
		if(1<=n&&n<=200000&&k<=Math.abs(2000000000)) {
			A = new int[n];
			//�迭 �Է�
			for(int i=0;i<n;i++) {
				A[i]=sc.nextInt();
			}
			for(int i=1;i<=n;i++) {
				cnt+=result(i,k);
			}
			System.out.println(cnt);
		}
	}
}
