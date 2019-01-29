package test_190129;

import java.util.Scanner;

//초콜릿의 크기가 nxm으로 주어질 때, 그것을 조각내어 1x1 크기로 만들 수 있는 최소 쪼갬 횟수 구하기
public class B_2163 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=300&&m<=300) {
			System.out.println(n*m-1);
		}
	}
}
