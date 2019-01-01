package solution;

import java.util.Scanner;

//AX + BY = D(A와 B의 최대공약수)가 성립하는 X, Y, D 출력하기(유클리드 확장 공식)
public class Q114 {

	public static int GCD(int a, int b) {
		if(b>a) {
			int tmp = a;
			a=b;
			b=tmp;
		}
		//삼항연산(큰 수를 작은 수로 나눴을 때 나머지가 없어지는 순간의 작은 수가 최대공약수)
		return a%b==0? b:GCD(a%b,b);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = GCD(a,b);
		
		int x = 0;
		int y = 0;
		
		while(true) {
			y=(gcd-a*x)/b;
			if(a*x+b*y==gcd) {
				break;
			}
			x--;
		}
		System.out.println(x);
		System.out.println(y);
		System.out.println(gcd);
	}
}
