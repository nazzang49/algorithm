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
				//����־ ���� ó�� �ڸ��� ')'�� �ԷµǾ�� �Ѵٸ�, �̹� NO�� �Ͱ� ��������
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
		//nextLine()�� ����ؾ� ����Ű ���� �� �ٹٲ� �߻�
		int n = Integer.parseInt(sc.nextLine());
		String [] strArr = new String [n];
		
		//��ȣ ���ڿ� �Է�
		for(int i=0;i<n;i++) {
			strArr[i]=sc.nextLine();
		}
		
		for(int i=0;i<strArr.length;i++) {
			System.out.println(cal(strArr[i]));
		}
	}
}
