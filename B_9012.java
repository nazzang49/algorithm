package test;

import java.util.Scanner;
import java.util.Stack;

public class B_9012 {

	public static String cal(String str) {
		Stack<Character> vps = new Stack<>();
		
		for(int j=0;j<str.length();j++) {
			if(str.charAt(j)=='(') {
				vps.push(str.charAt(j));
			}else {
				if(!vps.isEmpty()) {
					vps.pop();
				//비어있어서 가장 처음 자리에 ')'가 입력되어야 한다면, 이미 NO인 것과 마찬가지
				}else {
					return "NO";
				}
			}
		}
		
		if(vps.isEmpty()) {
			return "YES";
		}else {
			return "NO";	
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//nextLine()을 사용해야 엔터키 쳤을 때 줄바꿈 발생
		int n = Integer.parseInt(sc.nextLine());
		String [] strArr = new String [n];
		
		//괄호 문자열 입력
		for(int i=0;i<n;i++) {
			strArr[i]=sc.nextLine();
		}
		
		for(int i=0;i<strArr.length;i++) {
			System.out.println(cal(strArr[i]));
		}
	}
}
