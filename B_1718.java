package test_190118;

import java.util.Scanner;

//��, ��ȣȭ Ű, ��ȣȭ ��Ģ�� �־��� �� ��ȣȭ�� ���� ����ϱ�
public class B_1718 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//��
		String str = sc.nextLine();
		//��ȣȭŰ
		String pw = sc.next();
		
		if(str.length()<=30000) {
			String ans = "";
			for(int i=0;i<str.length();i++) {
				//������ �״�� ���� ����
				if(str.charAt(i)==' ') {
					ans+=' ';
				}
				//������ �ƴ� ���(���ĺ��� ���)
				else {
					//��ȣȭŰ���� ���° ���ĺ����� ����
					int idx = pw.charAt(i%pw.length())-96;
					System.out.println(idx);
					//��ȣȭ�� ���ڰ� ���ĺ� ������ �����(a���� �۾�����)
					if(str.charAt(i)-idx<97) {
						ans+=(char)(str.charAt(i)-idx-97+123);
					}else {
						System.out.println((char)(str.charAt(i)-idx));
						ans+=(char)(str.charAt(i)-idx);
					}
				}
			}
			System.out.println(ans);
		}
	}
}
