package test_190125;

import java.util.Scanner;

//�Է����� �־��� ũ�ξ�Ƽ�ƾ��� ���� ������ ����, �� ���� ũ�ξ�Ƽ�� ���ĺ����� ����ϴ� ���α׷� �ۼ��ϱ�
public class B_2941 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int cnt = 0;
		
		//�ܾ��� ���� �ִ� = 100
		if(str.length()<=100) {
			//�ܾ� Ž��
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='-') {
					continue;
				}else if(str.charAt(i)=='=') {
					if(i-2>=0&&str.substring(i-2, i).equals("dz")) {
						cnt--;
					}
					continue;
				}else if(str.charAt(i)=='j') {
					if(i-1>=0&&(str.charAt(i-1)=='l'||str.charAt(i-1)=='n')) {
						continue;
					}
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
