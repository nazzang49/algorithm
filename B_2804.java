package test_190121;

import java.util.Scanner;

//두 단어 A,B가 주어질 때 A를 가로, B를 세로로 놓는 크로스워드 출력하기
public class B_2804 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int row = 0;
		int col = 0;
		if(a.length()<=30&&b.length()<=30) {
			for(int i=0;i<a.length();i++) {
				boolean flag = false;
				for(int j=0;j<b.length();j++) {
					if(a.charAt(i)==b.charAt(j)) {
						flag = true;
						col=i;
						row=j;
						break;
					}
				}
				if(flag) {
					break;
				}
			}
		}
		//정답 출력하기
		for(int i=0;i<b.length();i++) {
			if(i==row) {
				for(int j=0;j<a.length();j++) {
					System.out.print(a.charAt(j));
				}
				System.out.println();
			}else {
				for(int j=0;j<a.length();j++) {
					if(j==col) {
						System.out.print(b.charAt(i));
					}else {
						System.out.print('.');
					}
				}
				System.out.println();
			}
		}
	}
}
