package solution;

import java.util.Scanner;

//2019�� 1�� 1��(ȭ����)���� 100000����� �����Ǵ� 13���� �ݿ��� �� ���ϱ�
//(��¥ ���� ����) 7�� �������� ��, �������� 1�̸� ȭ���� -> ��, �ݿ����� �������� 4
public class Q79 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�Է��� ����
		int n = sc.nextInt();
		int cnt = 0;
		
		if(2019<=n&&n<=100000) {
			int date = 13;
			
			//���� �ݺ�
			for(int i=2019;i<=n;i++) {
				//���� �� �ݺ�(�ſ� 13���� �� �ѹ�)
				for(int j=1;j<=12;j++) {
					if(j==1||j==3||j==5||j==7||j==8||j==10||j==12) {
						//�ſ� 13���� �ݿ������� Ȯ��
						if(date%7==4) {
							cnt++;
						}
						date+=31;
					}else if(j==4||j==6||j==9||j==11) {
						//�ſ� 13���� �ݿ������� Ȯ��
						if(date%7==4) {
							cnt++;
						}
						date+=30;
					}
					//2������ ���, ���� Ȯ��
					else {
						//�ſ� 13���� �ݿ������� Ȯ��
						if(date%7==4) {
							cnt++;
						}
						//400�̳� 4�� ����������, 100�� ����� �ƴ� ������ ��� ����
						if(i%400==0||(i%4==0&&i%100!=0)) {
							date+=29;
						}else {
							date+=28;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
