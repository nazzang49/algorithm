package test_181119;

import java.util.Scanner;

//1���� �Էµ� �ڿ��������� ���� Ȱ�ڷ� ǥ���� ��, �ʿ��� Ȱ���� ���� ���ϱ�
public class B_1951 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//�ʿ��� Ȱ�� ����
		int cnt = 0;
		
		if(1<=n&&n<=2000000000) {
			for(int i=1;i<=n;i++) {
				String str = String.valueOf(i);
				for(int j=0;j<str.length();j++) {
					cnt++;
				}
			}
			System.out.println(cnt%1234567);
		}
	}
}
