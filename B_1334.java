package test_190118;

import java.util.Scanner;

//특정 자연수가 입력되었을 때, 해당 수보다 큰 팰린드롬 수 중 가장 작은 값 출력하기
public class B_1334 {

	public static boolean result(int n) {
		String str = String.valueOf(n);
		for(int i=0;i<str.length();i++) {
			//앞쪽과 뒤쪽의 숫자가 다르면(팰린드롬이 될 수 없으면 false 반환)
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		
		if(n.length()<=50) {
			int start = Integer.parseInt(n);
			while(true) {
				boolean flag = result(start);
				if(flag) {
					System.out.println(start);
					break;
				}
				start++;
			}
		}
	}
}
