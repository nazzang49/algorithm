package test_181116;

import java.util.Scanner;

//X와 K가 주어졌을 때, X+Y = X|Y를 만족하는 Y 중 K번째로 작은 수 구하기
public class B_1322 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long y = 0;
		
		if(1<=n&&n<=2000000000&&1<=k&&k<=2000000000) {
			int cnt = 0;
			while(cnt<k) {
				for(long i=y+1;i<y+Math.pow(10, 10);i++) {
					if((n+i)==(n|i)) {
						y=i;
						cnt++;
						break;
					}
				}
			}
			System.out.println(y);
		}
	}
}
