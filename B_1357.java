package test_190128;

import java.util.Scanner;

//�� ���� ������ ���ڳ����� ���� ������ ��� ����ϱ�
public class B_1357 {

	public static int rev(int n) {
		String str = String.valueOf(n);
		String tmp = "";
		for(int i=str.length()-1;i>=0;i--) {
			tmp+=str.charAt(i);
		}
		return Integer.parseInt(tmp);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=1000&&m<=1000) {
			System.out.println(rev(rev(n)+rev(m)));
		}
	}
}
