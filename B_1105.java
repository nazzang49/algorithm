package test_181118;

import java.util.Scanner;

//�� ���� �Է°��� �־��� ��, �� �� ���̿��� 8�� ���� ���� ����ִ� ���� 8 ���� ���ϱ�
public class B_1105 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//8�� ����
		int cnt = 0;
		//���� ���� 8�� ����
		int min = Integer.MAX_VALUE;
		
		if(1<=n&&n<=2000000000&&n<=m&&m<=2000000000) {
			for(int i=n;i<=m;i++) {
				String str = String.valueOf(i);
				for(int j=0;j<str.length();j++) {
					if(str.charAt(j)=='8') {
						cnt++;
					}
				}
				//8�� �ϳ��� ���� ���� ���
				if(cnt==0) {
					continue;
				}
				//���� ���� 8�� ������ ���������� 8 �������� �� ���� ���
				if(cnt<min) {
					min=cnt;
				}
				cnt=0;
			}
			System.out.println(min);
		}
	}
}
