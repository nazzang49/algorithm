package test_190201;

import java.util.Scanner;

//TV의 대각선 길이, 높이 비율, 너비 비율이 입력으로 주어질 때, 실제  높이와 너비 출력하기
public class B_1297 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt(); //9
		int k = sc.nextInt(); //16
		
		//너비 비율 > 높이 비율 (가로 > 세로)
		if(n<=1000&&m<=99&&k<=100&&m<=k) {
			float height = (float)(n/Math.sqrt(1+Math.pow(k, 2)/Math.pow(m, 2)));
			float width = height*(k/(float)m);
			System.out.println((int)height);
			System.out.println((int)width);
		}
	}
}
