package solution;

import java.math.BigInteger;
import java.util.Scanner;

//nCk(���װ��)�� ������� 1000000007�� ���� ������ ���ϱ�
public class Q127 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�ʱⰪ ����(���ڿ��� �ڿ��� ���)
		BigInteger big1 = new BigInteger("1");
		BigInteger big2 = new BigInteger("1");
		BigInteger big3 = new BigInteger("1000000007");
		
		String n = sc.next();
		String k = sc.next();
		
		int int_k = Integer.parseInt(k);
		int int_n = 0;
		
		BigInteger big_n = new BigInteger(n);
		BigInteger big_k = new BigInteger(k);
		
		for(long i=0;i<int_k;i++) {
			int_n = Integer.parseInt(n);
			int_n-=i;
			n = String.valueOf(int_n);
			big_n = new BigInteger(n);
			big1 = big1.multiply(big_n);
		}
		for(long i=1;i<=int_k;i++) {
			k = String.valueOf(i);
			big_k = new BigInteger(k);
			big2 = big2.multiply(big_k);
		}
		big1 = big1.divide(big2);
		System.out.println(big1.mod(big3));
	}
}
