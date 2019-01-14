package test_190114;

import java.util.Scanner;

//서버에 문제가 생겨 특정 패턴과 일치하는 문자열의 출력에 문제가 생긴 경우, 입력으로 주어지는 파일명이 주어진 패턴과 일치하는지 판명하는 프로그램 작성하기
public class B_9996 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			//주어지는 패턴 문자열
			String pat = sc.next();
			String [] ans = new String[n];
			for(int i=0;i<n;i++) {
				//패턴 문자열과 비교할 입력 문자열
				String str = sc.next();
				boolean flag = false;
				for(int j=0;j<str.length();j++) {
					if(pat.charAt(j)=='*') {
						break;
					}
					//별표(임의의 문자열이 들어갈 자리)가 나오기 전 문자열의 각 자리 비교(앞에서부터)
					else if(str.charAt(j)!=pat.charAt(j)) {
						flag=true;
						break;
					}
				}
				//앞쪽 문자열 통과 시
				if(!flag) {
					for(int j=pat.length()-1;j>=0;j--) {
						if(pat.charAt(j)=='*') {
							break;
						}
						//별표(임의의 문자열이 들어갈 자리)가 나오기 전 문자열의 각 자리 비교(뒤에서부터)
						else if(str.charAt(j+str.length()-pat.length())!=pat.charAt(j)) {
							flag=true;
							break;
						}
					}
					//뒤쪽 문자열도 통과 시
					if(!flag) {
						ans[i]="DA";
						continue;
					}
				}
				ans[i]="NE";
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
