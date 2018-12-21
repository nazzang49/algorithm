package solution;

import java.util.Scanner;

//구하고자 하는 두 수의 최대공약수(GCD), 최소공배수(LCM)이 주어질 때 역으로 두 수 구하기(답이 여러개인 경우 합이 최소가 되는 쌍)
public class Q75 {

	//최대공약수 구하는 메소드
	public static int GCD(int left, int right) {
		if(right>left) {
			int tmp = left;
			left = right;
			right = tmp;
		}
		//삼항연산자 활용(어느 한쪽이 다른 한쪽에 의해 처음으로 나눠지는 순간 그 다른 한쪽이 최대공약수가 된다)
		return left%right==0 ? right : GCD(right, left%right);
	}
	
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int gcd = sc.nextInt();
		int lcm = sc.nextInt();
		int tmp = lcm/gcd;
		
		int aa = 0;
		int bb = 0;
		for(int i=1;i*i<tmp;i++) {
			if(tmp%i==0) {
				if(GCD(i,tmp/i)==1) {
					aa=i;
					bb=tmp/i;
				}
			}
		}
		System.out.println(gcd*aa);
		System.out.println(gcd*bb);
	}
}
