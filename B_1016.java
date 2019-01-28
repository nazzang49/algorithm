package test_190128;

import java.util.Scanner;

//어떤 수 X가 1보다 큰 정수의 제곱수로 나누어 떨어지지 않는 수의 갯수를 주어진 구간 내에서 구하기
public class B_1016 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		
		long k = 1;
		long cnt = 0;
		//탐색 실행
		for(long i=min;i<=max;i++) {
			//구간 내 제곱수인 것만 추출(구간 내 존재하면 그 다음 제곱수로 이동)
			if(k*k==i) {
				cnt++;
				k++;
			}
		}
		System.out.println(max-min-cnt+1);
	}
}
