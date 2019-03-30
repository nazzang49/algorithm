package test_190330;

import java.util.Scanner;

//N보다 작거나 같은 모든 소수를 찾는 에라토스테네스의 체 구현하고, k번째 지워지는 수 구하기
public class B_2960 {

	public static void find(int n, int k) {
		int cnt = 0;
		int [] d = new int[n+1];
		//배열 초기화
		for(int i=2;i<=n;i++) {
			d[i]=i;
		}
		//에라토스테네스의 체 활용
		for(int i=2;i<=n/2;i++) {
			if(d[i]==0) continue;
			for(int j=1;i*j<=n;j++) {
				if(d[i*j]==0) continue;
				cnt++;
				if(cnt==k) {
					System.out.println(d[i*j]);
					System.exit(0);
				}
				d[i*j]=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=1000&&k<n) {
			find(n,k);
		}	
	}
}
