package test_190118;

import java.util.Scanner;

//Ư�� �ڿ����� �ԷµǾ��� ��, �ش� ������ ū �Ӹ���� �� �� ���� ���� �� ����ϱ�
public class B_1334 {

	public static boolean result(int n) {
		String str = String.valueOf(n);
		for(int i=0;i<str.length();i++) {
			//���ʰ� ������ ���ڰ� �ٸ���(�Ӹ������ �� �� ������ false ��ȯ)
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		
		if(n.length()<=50) {
			int start = Integer.parseInt(n);
			while(true) {
				boolean flag = result(start);
				if(flag) {
					System.out.println(start);
					break;
				}
				start++;
			}
		}
	}
}
