package test_190201;

import java.util.Scanner;

//TV�� �밢�� ����, ���� ����, �ʺ� ������ �Է����� �־��� ��, ����  ���̿� �ʺ� ����ϱ�
public class B_1297 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt(); //9
		int k = sc.nextInt(); //16
		
		//�ʺ� ���� > ���� ���� (���� > ����)
		if(n<=1000&&m<=99&&k<=100&&m<=k) {
			float height = (float)(n/Math.sqrt(1+Math.pow(k, 2)/Math.pow(m, 2)));
			float width = height*(k/(float)m);
			System.out.println((int)height);
			System.out.println((int)width);
		}
	}
}
