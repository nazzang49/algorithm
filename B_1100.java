package test_190121;

import java.util.Scanner;

//����� �������� �����ư��� ĥ���� 8x8 ũ���� ü���ǰ� �� ���� �ִ� ���� ��ġ�� �־��� ��, ��� ���� �ִ� ���� ����� ����ϱ�
public class B_1100 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		int k = 0;
		while(k<8) {
			//¦����° ���� ¦����° ĭ Ž��
			//Ȧ����° ���� Ȧ����° ĭ Ž��
			String str = sc.next();
			if(k%2==0) {
				for(int i=0;i<str.length();i++) {
					if(i%2==0&&str.charAt(i)=='F') {
						cnt++;
					}
				}
			}else {
				for(int i=0;i<str.length();i++) {
					if(i%2==1&&str.charAt(i)=='F') {
						cnt++;
					}
				}
			}
			k++;
		}
		System.out.println(cnt);
	}
}
