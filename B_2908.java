package test_190122;

import java.util.Scanner;

//�� ���� �ڿ����� ���ڷ� �־��� ��, �� ���� �Ųٷ� ������ �� �� ū �� ����ϱ�
public class B_2908 {

	public static int result(String a, String b) {
		StringBuffer newA = new StringBuffer();
		StringBuffer newB = new StringBuffer();
		
		for(int i=a.length()-1;i>=0;i--) {
			newA.append(a.charAt(i));
			newB.append(b.charAt(i));
		}
		
		int A = Integer.parseInt(newA.toString());
		int B = Integer.parseInt(newB.toString());
		
		//���� ������ Ȱ��
		return A>B? A:B;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		//�ԷµǴ� �ڿ����� ���ڸ� ���̸�, ���� �ٸ�
		if(a!=b&&a.length()==3&&b.length()==3) {
			System.out.println(result(a,b));
		}
	}
}
