package test_181114;

import java.util.Scanner;

//유진수(어떤 수를 10진수로 표현한 뒤 그 수를 두 부분으로 나눴을 때 앞 부분 자리 수 곱 = 뒷 부분 자리 수 곱) 판별하기
public class B_1356 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=2147483647) {
			String str = String.valueOf(n);
			//탐색해야할 경우의 수 = 입력값의 자리 수 - 1
			for(int i=0;i<str.length()-1;i++) {
				//앞 부분 수
				String str1 = "";
				//뒷 부분 수
				String str2 = "";
				
				//앞 부분 추출
				for(int j=0;j<=i;j++) {
					str1+=str.charAt(j);
				}
				//뒷 부분 추출
				for(int j=i+1;j<str.length();j++) {
					str2+=str.charAt(j);
				}
				//앞 부분 수의 각 자리 수 곱
				long num1 = 1;
				//뒷 부분 수의 각 자리 수 곱
				long num2 = 1;
				
				for(int j=0;j<str1.length();j++) {
					num1*=str1.charAt(j)-'0';
				}
				for(int j=0;j<str2.length();j++) {
					num2*=str2.charAt(j)-'0';
				}
				//유진수가 되는 하나의 경우라도 있다면
				if(num1==num2) {
					System.out.println("YES");
					System.exit(0);
				}
			}
			//유진수가 되는 하나의 경우도 없다면
			System.out.println("NO");
			System.exit(0);
		}
	}
}
