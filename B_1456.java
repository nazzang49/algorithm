package test_181116;

import java.util.Scanner;

//�־��� ���� ������ ���� �Ҽ�(� �Ҽ��� n����)�� ���� ���ϱ�
public class B_1456 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long cnt = 0;
		
		if(1<=a&&a<=b&&b<=Math.pow(10, 14)) {
			for(long i=a;i<=b;i++) {
				boolean flag = false;
				for(long j=2;j<=i/2;j++) {
					if(i%j==0) {
						flag=true;
						break;
					}
				}
				//�Ҽ��̸�
				if(!flag&&i!=1) {
					long tmp = i;
					for(long j=2;(long)Math.pow(tmp, j)<=b;j++) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
