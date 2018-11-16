package test_181116;

import java.util.Scanner;

//주어진 범위 내에서 거의 소수(어떤 소수의 n제곱)의 개수 구하기
public class B_1456 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long cnt = 0;
		
		if(1<=a&&a<=b&&b<=Math.pow(10, 14)) {
			for(long i=a;i<=b;i++) {
				boolean flag = false;
				for(long j=2;j<=i/2;j++) {
					if(i%j==0) {
						flag=true;
						break;
					}
				}
				//소수이면
				if(!flag&&i!=1) {
					long tmp = i;
					for(long j=2;(long)Math.pow(tmp, j)<=b;j++) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
