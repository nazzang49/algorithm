package test_190116;

import java.util.Scanner;

//A�� B�� �̷���� ���ڿ��� �־��� ��, �� ���ڸ� �ϳ��� ������ ���� �� ���� �������� �ʴ� "���� �ܾ�"�� ���� ����ϱ�
public class B_3986 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		
		if(1<=n&&n<=100) {
			//���ڿ� �Է�
			for(int i=0;i<n;i++) {
				String str = sc.next();
				boolean flag = false;
				int cnt = 0;
				for(int j=1;j<str.length()-1;j++) {
					cnt=0;
					if(str.charAt(j)!=str.charAt(j-1)) {
						cnt++;
					}
					if(str.charAt(j)!=str.charAt(j+1)) {
						cnt++;
					}
					if(cnt==2) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
