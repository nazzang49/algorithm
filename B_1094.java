package test_190327;

import java.util.Scanner;

//64cm ������ ���븦 ������ ���� ��, �ش� ���븦 ���Ƿ� �߶� xcm�� ���븦 ������� �Ѵٸ� �ڸ��� Ƚ�� ���ϱ�
public class B_1094 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=64) {
			int cnt = 0;
			String str = Integer.toBinaryString(n);
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='1') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
