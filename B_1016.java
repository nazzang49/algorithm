package test_190128;

import java.util.Scanner;

//� �� X�� 1���� ū ������ �������� ������ �������� �ʴ� ���� ������ �־��� ���� ������ ���ϱ�
public class B_1016 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		
		long k = 1;
		long cnt = 0;
		//Ž�� ����
		for(long i=min;i<=max;i++) {
			//���� �� �������� �͸� ����(���� �� �����ϸ� �� ���� �������� �̵�)
			if(k*k==i) {
				cnt++;
				k++;
			}
		}
		System.out.println(max-min-cnt+1);
	}
}
