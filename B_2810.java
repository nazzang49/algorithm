package test_181106;

import java.util.Scanner;

//��Ȧ���� ���� �� �ִ� �ڸ� ���ϱ�
public class B_2810 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		if(1<=n&&n<=50) {
			String str = sc.next();
			
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='S') {
					cnt++;
				}else if(str.charAt(i)=='L') {
					cnt++;
					i++;
				}
			}
			System.out.println(cnt+1);
		}	
	}
}
