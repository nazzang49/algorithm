package test_181114;

import java.util.Scanner;

//00���� �̷���� Ÿ��(00�� �ϳ��� 0���� ����)�� 1�� �̷���� Ÿ���� �����Ͽ� ���� �� �ִ� ���� ������ ���� ���ϱ�
//������ ��Ģ = �Ǻ���ġ
public class B_1904 {

	public static int fibonacci(int n) {
		if(n==0) {
			return 1;
		}else if(n==1) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//���� ������ ���� ���� ����
		int cnt = 0;
		
		if(1<=n&&n<=1000000) {
			cnt = fibonacci(n);
			System.out.println(cnt%15746);
		}
		
	}

}
