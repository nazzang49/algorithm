package test_181106;

import java.util.Scanner;

//Ư�� ���� �޽����� �ۼ��ϴµ� �ɸ��� �ð� ���ϱ�
public class B_2037 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int w = sc.nextInt();
		int seconds = 2;
		
		if(1<=p&&p<=1000&&1<=w&&w<=1000) {
			String tmp = sc.next();
			if(tmp.length()<1000) {
				for(int i=1;i<tmp.length();i++) {
					//���� ���� = ���� ������ ���
					if(tmp.charAt(i-1)==tmp.charAt(i)-1) {
						seconds+=10;
					}
				}
			}
		}
	}
}
