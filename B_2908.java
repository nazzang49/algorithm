package test_190122;

import java.util.Scanner;

//두 개의 자연수가 문자로 주어질 때, 두 수를 거꾸로 뒤집은 수 중 큰 수 출력하기
public class B_2908 {

	public static int result(String a, String b) {
		StringBuffer newA = new StringBuffer();
		StringBuffer newB = new StringBuffer();
		
		for(int i=a.length()-1;i>=0;i--) {
			newA.append(a.charAt(i));
			newB.append(b.charAt(i));
		}
		
		int A = Integer.parseInt(newA.toString());
		int B = Integer.parseInt(newB.toString());
		
		//삼항 연산자 활용
		return A>B? A:B;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		//입력되는 자연수는 세자리 수이며, 서로 다름
		if(a!=b&&a.length()==3&&b.length()==3) {
			System.out.println(result(a,b));
		}
	}
}
