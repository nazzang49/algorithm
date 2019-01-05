package solution;

import java.util.Scanner;

//네 자연수 a,b,c,d가 주어질 때, (a와 b를 붙인 숫자 + c와 d를 붙인 숫자) 구하기
public class Q132 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		if(1<=a&&a<=1000000&&1<=b&&b<=1000000&&1<=c&&c<=1000000&&1<=d&&d<=1000000) {
			String a_str = String.valueOf(a);
			String b_str = String.valueOf(b);
			String c_str = String.valueOf(c);
			String d_str = String.valueOf(d);
			
			a_str+=b_str;
			c_str+=d_str;
			
			System.out.println(Integer.parseInt(a_str)+Integer.parseInt(c_str));
		}
	}
}
