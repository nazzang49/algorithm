package test_190201;

import java.util.Scanner;

//�Ѽ��� ���� ��ġ�� x,y�� ��, (0,0)�� (w,h)�� ���� ���������� ������ ���簢���� ��輱���� ���� �Ÿ��� �ּڰ� ���ϱ�
public class B_1085 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		if(w<=1000&&h<=1000&&x<=w-1&&y<=h-1) {
			int garo = Math.abs(w-x);
			int sero = Math.abs(h-y);
			
			System.out.println(Math.min(garo, Math.min(sero, Math.min(x, y))));
		}
	}
}
