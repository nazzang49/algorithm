package test_190122;

import java.util.Scanner;

//�Էµ� �ܾ ���� ������ ���ĺ����� ��ġ�� �ε��� ����ϱ�
public class B_10809 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<100) {
			int [] alpha = new int[26];
			//�迭 �ʱ�ȭ
			for(int i=0;i<alpha.length;i++) {
				alpha[i]=-1;
			}
			//Ž�� ����
			for(int i=0;i<str.length();i++) {
				//ó�� �����ϴ� ��쿡�� �ε��� ����
				if(alpha[str.charAt(i)-'a']==-1) {
					alpha[str.charAt(i)-'a']=i;
				}
			}
			//���� ���
			for(int i=0;i<alpha.length;i++) {
				System.out.print(alpha[i]+" ");
			}
		}
	}
}
