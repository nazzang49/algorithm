package test_190117;

import java.util.Scanner;

//문자열을 1~n칸씩 뒤집거나 뒤집지 않을 때, 최종적으로 사전 순에서 가장 앞에 위치 하는 문자열 출력하기
public class B_1464 {

	static int n;
	static String ans = "";
	
	//뒤집거나 뒤집지 않는 두가지 경우 존재
	public static void dfs(int count, String str) {
		if(count==n-1) {
			//ans와 str의 알파벳 순서 비교
			for(int i=0;i<ans.length();i++) {
				if(ans.charAt(i)<str.charAt(i)) {
					break;
				}else if(ans.charAt(i)>str.charAt(i)) {
					ans=str;
					break;
				}
			}
		}else {
			count++;
			//뒤집지 않는 경우
			dfs(count,str);
			char [] arr = str.toCharArray();
			//자리 바꾸기
			for(int i=0;i<=count/2;i++) {
				char tmp = arr[i];
				arr[i]=arr[count-i];
				arr[count-i]=tmp;
			}
			dfs(count,new String(arr));
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<=10000) {
			n=str.length();
			ans=str;
			dfs(0,str);
			System.out.println(ans);
		}
	}
}
