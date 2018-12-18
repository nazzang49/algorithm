package solution;

import java.math.BigInteger;
import java.util.Scanner;

//2의 n승에 해당하는 자연수의 각 자리수를 더한 합 구하기
public class Q58 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		BigInteger bint = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		
		for(long i=1;i<=n;i++) {
			bint = bint.multiply(two);
		}
	
		String str = bint.toString();	
		int sum = 0;
		for(int i=0;i<str.length();i++) {
			sum+=str.charAt(i)-'0';
		}
		System.out.println(sum);
	}
}
