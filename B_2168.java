package test_181116;

import java.util.Scanner;

//���簢�� ���鿡 1X1 ũ���� Ÿ���� ���̰� ���鿡 �밢�� ���� �׾��� �� �밢���� ������ Ÿ���� ���� ���ϱ�
//�������Լ��� �����Ͽ� ��Ģ�� ã��
public class B_2168 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//������ ����
		int cnt = 0;
		//���� ���簢���� ���α��� ����ϱ� ���� ����
		int x = 0;
		
		if(1<=n&&n<=1000000000&&1<=m&&m<=1000000000) {
			//�־��� �� ���� ��������� ���
			if(n%m==0||m%n==0) {
				if(n>m) {
					cnt=n;
				}else {
					cnt=m;
				}
			}
			//�־��� �� ���� ������谡 �ƴ� ���
			//�� �� �� ��� ������ �Ҽ��� �� ������ �ݺ�
			else {
				System.out.println("���´�");
				//��� ���Ǹ� ���� ����̰� 1���� Ŀ������ ����
				if(n>m) {
					System.out.println("���´�1");
					int tmp = n;
					n=m;
					m=tmp;
				}
				x=n;
				for(int i=2;i<=m/2;i++) {
					System.out.println("���´�2");
					if(m%i==0&&n%i==0) {
						m=m/i;
						n=n/i;
						i=1;
					}
				}
				cnt=(m+n-1)*(x/n);
				System.out.println("���´�3");
			}
			System.out.println(cnt);
		}
	}
}
