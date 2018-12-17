package solution;

import java.util.Scanner;

//n의 크기에 따라 "수박" 문자열을 반복해서 출력하는 프로그램 구현하기
public class Q48 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=10000) {
			String str = "";
			for(int i=0;i<n;i++) {
				if(i%2==0) {
					str+="수";
				}else {
					str+="박";
				}
			}
			System.out.println(str);
		}
	}
}
