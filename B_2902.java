package test_190128;

import java.util.Scanner;

//�� ������ ���ڿ��� �־����� ��, ���� ���ڿ��� �ٲٴ� ���α׷� �ۼ��ϱ�
public class B_2902 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<=100) {
			String ans = "";
			ans+=str.charAt(0);
			//Ž�� ����
			for(int i=1;i<str.length()-1;i++) {
				//������ ���� ���ڴ� ���� ���ڿ��� �߰�
				if(str.charAt(i)=='-') {
					ans+=str.charAt(i+1);
				}
			}
			System.out.println(ans);
		}
	}
}
