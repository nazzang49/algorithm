package solution;

import java.util.Scanner;

//1900�� 1�� 1���� �������� ��, 1901�� 1�� 1�Ϻ��� ������� �ſ� 1���� �Ͽ����� ����� �� ���ϱ�
public class Q52 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//���� �������� �־��� �Է°�
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		//�ſ� 1���� �Ͽ����� ��� ��
		int cnt = 0;
		//�ϼ��� ������ ����(1900�� 1�� 1���� 1�� ��´�)
		int date = 1;
		
		//���� �ݺ�(1900�� ~ ����)
		for(int i=1900;i<=year;i++) {
			//�� �ݺ�(1�� ~ 12��)
			for(int j=1;j<=12;j++) {
				//+31
				if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
					if(date%7==0) {
						cnt++;
					}
					date+=31;
				}
				//+30
				else if(i==4||i==6||i==9||i==11){
					if(date%7==0) {
						cnt++;
					}
					date+=30;
				}
				//2������ ���� ���
				else {
					if(date%7==0) {
						cnt++;
					}
					if(i%4==0&&i%400==0) {
						date+=29;
					}else {
						date+=28;
					}
				}
			}
		}
	}
}
