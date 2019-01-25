package test_190125;

import java.util.Arrays;
import java.util.Scanner;

//문자열 S의 모든 접미사를 사전순으로 재배열하여 출력하기
public class B_11656 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<=1000) {
			//접미사 갯수 = 문자열의 길이
			String [] ans = new String[str.length()];
			
			for(int i=0;i<str.length();i++) {
				ans[i]=str.substring(i, str.length());
			}
			
			Arrays.sort(ans);
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
