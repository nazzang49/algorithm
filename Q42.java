package solution;

import java.util.Scanner;

//�ڿ��� n�� �־��� �� n���� ũ��, ������ ��ȯ �� 1�� ������ ���� �� �� ���� ���� �� ���ϱ�
public class Q42 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000000) {
			//������  ǥ��
			String str = Integer.toBinaryString(n);
			//���������� 1�� ����
			int cnt = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='1') {
					cnt++;
				}
			}
			int answer = 0;
			for(int i=n+1;i<1000000;i++) {
				str=Integer.toBinaryString(i);
				answer=0;
				for(int j=0;j<str.length();j++) {
					if(str.charAt(j)=='1') {
						answer++;
					}
				}
				if(cnt==answer) {
					answer=i;
					break;
				}
			}
			System.out.println(answer);
		}
	}
}
