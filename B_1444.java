package test_190121;

import java.util.Scanner;

//�� �� �ؼ��Ͽ� �ߺ����� ���� ���ĺ��� �� ���� ���ϱ�
public class B_1444 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int cnt = 0;
		
		//�Է����� �־����� ������ �ִ� ���̴� 3000��
		if(n.length()<=3000) {
			//���ο� ���ĺ� ���°� �����ϸ� �迭�� �� +1 ����
			int [] alpha = new int[58];
			//�� ���ھ� ���ο� ���ĺ� �������� Ȯ��
			for(int i=0;i<n.length()-1;i++) {
				if(alpha[n.charAt(i)-'A']==0) {
					//������ ���ĺ��� ��Ģ�� �����ϴ���(�ҹ���-�빮�� ����)
					if(Math.abs(n.charAt(i)-n.charAt(i+1))==32) {
						alpha[n.charAt(i)-'A']++;
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
