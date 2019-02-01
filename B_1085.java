package test_190201;

import java.util.Scanner;

//한수의 현재 위치가 x,y일 때, (0,0)과 (w,h)를 양쪽 꼭짓점으로 가지는 직사각형의 경계선으로 가는 거리의 최솟값 구하기
public class B_1085 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		if(w<=1000&&h<=1000&&x<=w-1&&y<=h-1) {
			int garo = Math.abs(w-x);
			int sero = Math.abs(h-y);
			
			System.out.println(Math.min(garo, Math.min(sero, Math.min(x, y))));
		}
	}
}
