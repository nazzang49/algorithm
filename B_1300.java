package test_190123;

import java.util.Scanner;

//nxn ����� �� �ε��������� �� i*j�� 1���� �迭�� �������� ��, k��° �ڿ��� ���ϱ�
public class B_1300 {

	static int n;
	static int k;
	
	public static boolean result(int mid) {
		int cnt = 0;
		//��� ���� ����(i���� ��� ���� �ִ� ���� i��� => i�࿡�� mid���� �۰ų� ���� ��� ���� ����)
		for(int i=1;i<=n;i++) {
			cnt+=Math.min(n, mid/i);
		}
		
		return cnt>=k? true : false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(n<=Math.pow(10, 5)&&k<=Math.min(Math.pow(10, 9),n*n)) {
			int left = 1;
			int right = 1000000000;
			int mid = 0;
			
			int ans = Integer.MAX_VALUE;
			while(left<=right) {
				mid = (left+right)/2;
				if(result(mid)) {
					right=mid-1;
					ans = Math.min(ans,mid);
				}else {
					left=mid+1;
				}
			}
			System.out.println(ans);
		}	
	}
}
