package test_181116;

import java.util.Scanner;

//��Ź�� �ѷ� ���� ¦������ ����� �� �Ǽ��� �� �� ���� ���� �������� �ʰ� �����ϴ� ����� ��
public class B_1670 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		if(1<=n&&n<=10000) {
			if(n==2) {
				cnt=1;
			}else if(n==4) {
				cnt=2;
			}else {
				//������ ������� �Ǽ��ϴ� ���(��or��)
				cnt+=2;
				//����+���ֺ��� ������� �Ǽ��ϴ� ���
				cnt+=n/2;		
			}
			System.out.println(cnt%987654321);
		}
	}
}
