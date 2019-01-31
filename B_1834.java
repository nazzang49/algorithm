package test_190131;

import java.util.Scanner;

//n으로 나누었을 때, 몫과 나머지가 같은 모든 숫자들의 합 출력하기
public class B_1834 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		if(n<=2000000) {
			long sum = 0;
			//몫이 n보다 작은 구간에서만 조건 만족 가능
			for(long i=1;i<n;i++) {
				sum+=n*i+i;
			}
			System.out.println(sum);
		}
	}
}
