package test_181114;

import java.util.Scanner;

//가장 자리 타일은 빨간색, 그 외 타일은 갈색으로 채울 때, 주어지는 빨간색과 갈색 개수를 보고 직사각형 방의 크기 구하기
public class B_2858 {

	public static void main(String[] args) {

		Scanner	sc = new Scanner(System.in);
		int r = sc.nextInt();
		int b = sc.nextInt();
		int l = 0;
		int w = 0;
		
		if(8<=r&&r<=5000&&1<=b&&b<=2000000) {
			//갈색 타일이 홀수인 경우(한 가지 케이스 존재)
			if(b%2!=0) {
				l=(b+2);
				w=3;
			}
			//갈색 타일이 짝수인 경우(두 가지 케이스 존재)
			else {
				if((b+2)*2+2==r) {
					l=(b+2);
					w=3;	
				}else if((b/2+2)*2+4==r) {
					l=(b/2+2);
					w=4;
				}
			}
			System.out.print(l+" "+w);
		}
	}
}
