package test_181103;

import java.util.Scanner;

//소음 문제를 해결하기 위한 선생님의 특단
public class B_2935 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String op = sc.next();
		int k = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10, 99)&&1<=k&&k<=Math.pow(10, 99)&&
				n%10==0&&k%10==0) {
			if(op.equals("*")) {
				System.out.println(n*k);
			}else if(op.equals("+")) {
				System.out.println(n+k);
			}else {
				System.out.println("연산자의 종류는 덧셈, 곱셈만 가능합니다.");
				System.exit(0);
			}
		}
	}
}
