package test_190128;

import java.util.Scanner;

//A를 B번 곱한 수를 C로 나눈 나머지 출력하기(재귀함수로 탐색 시간을 줄이는 것이 포인트)
public class B_1629 {

	public static long mul(long a, long b, long c) {
		a%=c;
		if(b==0) {
			return 1;
		}else if(b%2==0) {
			return mul(a*a,b/2,c)%c;
		}else {
			return a*mul(a*a,(b-1)/2,c)%c;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		System.out.println(mul(a,b,c));
		
	}
}
