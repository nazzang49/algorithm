package test_190117;

import java.util.Scanner;

//�Ϲ� �¼�, Ŀ�� �¼��� ���� ������ ���ڿ��� �־��� �� �� ������ ���� �� �ִ� �� Ȧ���� ���� ���ϱ�
public class B_2810 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=50) {
			String str = sc.next();
			//�Ϲ��¼��� ����
			int s = 0;
			//Ŀ���¼��� ����
			int l = 0;
			
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='S') {
					s++;
				}else {
					l++;
				}
			}
			System.out.println(s+l/2+1);
		}
	}
}
