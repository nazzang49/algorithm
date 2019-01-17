package test_190117;

import java.util.Scanner;

//일반 좌석, 커플 좌석에 대한 정보가 문자열로 주어질 때 양 옆으로 놓을 수 있는 컵 홀더의 개수 구하기
public class B_2810 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=50) {
			String str = sc.next();
			//일반좌석의 갯수
			int s = 0;
			//커플좌석의 갯수
			int l = 0;
			
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='S') {
					s++;
				}else {
					l++;
				}
			}
			System.out.println(s+l/2+1);
		}
	}
}
