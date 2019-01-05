package solution;

import java.util.Scanner;

//문장으로 이루어진 문자열이 주어질 때, 해당 문장 내 쓰인 단어의 개수 출력하기
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
