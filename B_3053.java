package test_181103;

import java.util.Scanner;

//�Ϲ����� ���� ���̿� �ý� �����п����� ���� ���̸� �Բ� ���ϴ� �ҽ�
public class B_3053 {
	
	//����, ���, ���� ������ ���� ����
	static final double pi = 3.14159265359;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		if(1<=r&&r<=10000) {
			//�Ϲ����� ���� ����
			double general = r*r*pi;
			//�ý� ������ ���� ����(=������ ����)
			double taxi = r*r*2;
			
			System.out.printf("%.6f",general);
			System.out.println();
			System.out.printf("%.6f",taxi);
			
		}
	}
}
