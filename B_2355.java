package test_190131;

import java.util.Scanner;

//A와 B 사이에 있는 수들의 합 구하기
public class B_2355 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		
		if(Integer.MIN_VALUE<=A&&A<=Integer.MAX_VALUE&&Integer.MIN_VALUE<=B&&B<=Integer.MAX_VALUE) {
			long sum = 0;
			//범위 설정을 위해 A=작은 수, B=큰 수
			if(A>B) {
				long tmp = A;
				A=B;
				B=tmp;
			}
			sum=B*(B+1)/2-A*(A-1)/2;
			System.out.println(sum);
			sc.close();
		}
	}
}
