package solution;

import java.util.Scanner;

//�������� �̷���� ���ڿ��� �־��� ��, �ش� ���� �� ���� �ܾ��� ���� ����ϱ�
public class Q133 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if(1<=str.length()&&str.length()<=1000000) {
			int cnt = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)==' ') {
					cnt++;
				}
			}
			System.out.println(cnt+1);
		}
	}
}
