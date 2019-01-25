package test_190125;

import java.util.Scanner;

//배열의 크기 n, 함수 호출 횟수 k, 배열의 구간합 확인 횟수 q, 확인 케이스마다 구간으로 주어질 l과 r이 주어질 때, 각 구간합의 결과 출력하기
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
			//함수 호출 시 전달할 인자 입력
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
			//정답 출력
			for(int i=0;i<q;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
