package test_190129;

import java.util.Scanner;

//���ݸ��� ũ�Ⱑ nxm���� �־��� ��, �װ��� �������� 1x1 ũ��� ���� �� �ִ� �ּ� �ɰ� Ƚ�� ���ϱ�
public class B_2163 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=300&&m<=300) {
			System.out.println(n*m-1);
		}
	}
}
