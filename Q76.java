package solution;

import java.util.Scanner;

//고양이가 입력한 문자열이 있을 때, 입력값으로 주어진 알파벳의 개수에 만족하는 가장 긴 부분 문자열 길이 구하기 
public class Q76 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//주어지는 알파벳 개수
		int n = sc.nextInt();
		String str = sc.next();
		int length = 0;
		int max = 0;
		int cnt = 0;
		//특정 알파벳의 등장 여부 검사
		int [] alpha = new int[26];
		
		for(int i=0;i<str.length()-1;i++) {
			alpha[str.charAt(i)-'a']++;
			cnt++;
			length++;
			for(int j=i+1;j<str.length();j++) {
				if(cnt<=n) {
					//이미 등장한 알파벳이면
					if(alpha[str.charAt(j)-'a']!=0) {
						length++;
					}
					//새로 등장한 알파벳이면(cnt+1)
					else {
						alpha[str.charAt(i)-'a']++;
						cnt++;
						if(cnt!=n) {
							length++;	
						}
					}					
				}else {
					//최대길이 비교
					if(max<=length) {
						max=length;
					}
					//초기화
					length=0;
					cnt=0;
					alpha = new int[26];
					break;
				}
			}
		}
		System.out.println(max);
	}
}
