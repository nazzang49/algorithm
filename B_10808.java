package test_190121;

import java.util.Scanner;

//�ܾ �־��� ��, �ܾ ���� �� ���ĺ��� ������ �������� ��� ����ϱ�
public class B_10808 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<100) {
			int [] alpha = new int[26];
			for(int i=0;i<str.length();i++) {
				alpha[str.charAt(i)-'a']++;
			}
			//���� ���
			for(int i=0;i<alpha.length;i++) {
				System.out.print(alpha[i]+" ");
			}
		}	
	}
}
