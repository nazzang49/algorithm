package test_190131;

import java.util.Scanner;

//n���� �������� ��, ��� �������� ���� ��� ���ڵ��� �� ����ϱ�
public class B_1834 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		if(n<=2000000) {
			long sum = 0;
			//���� n���� ���� ���������� ���� ���� ����
			for(long i=1;i<n;i++) {
				sum+=n*i+i;
			}
			System.out.println(sum);
		}
	}
}
