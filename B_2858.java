package test_181114;

import java.util.Scanner;

//���� �ڸ� Ÿ���� ������, �� �� Ÿ���� �������� ä�� ��, �־����� �������� ���� ������ ���� ���簢�� ���� ũ�� ���ϱ�
public class B_2858 {

	public static void main(String[] args) {

		Scanner	sc = new Scanner(System.in);
		int r = sc.nextInt();
		int b = sc.nextInt();
		int l = 0;
		int w = 0;
		
		if(8<=r&&r<=5000&&1<=b&&b<=2000000) {
			//���� Ÿ���� Ȧ���� ���(�� ���� ���̽� ����)
			if(b%2!=0) {
				l=(b+2);
				w=3;
			}
			//���� Ÿ���� ¦���� ���(�� ���� ���̽� ����)
			else {
				if((b+2)*2+2==r) {
					l=(b+2);
					w=3;	
				}else if((b/2+2)*2+4==r) {
					l=(b/2+2);
					w=4;
				}
			}
			System.out.print(l+" "+w);
		}
	}
}
