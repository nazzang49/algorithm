package test_181109;

import java.math.BigInteger;
import java.util.Scanner;

//조합의 결과 구하기(long 자료형을 초과할 수 있으므로 BigInteger 자료형 활용)
public class B_2407 {
	
	static BigInteger factorial(int n) {
		BigInteger ans =BigInteger.valueOf(1);
		for(int i=1;i<=n;i++)
			ans = ans.multiply(BigInteger.valueOf(i));
		return ans;
	}
	
	static BigInteger combination(int n, int r) {
		BigInteger per = null;
		BigInteger fac = null;
		per = permutation(n,r);
		fac = factorial(n-r);
		return per.divide(fac);
	}
	
	static BigInteger permutation(int n, int r) {
		BigInteger ans = BigInteger.valueOf(1);
		for(int i=n;i>r;i--)
			ans = ans.multiply(BigInteger.valueOf(i));
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(combination(sc.nextInt(), sc.nextInt()));
	}
}
