package test_190118;

import java.util.Scanner;

//문자열의 길이가 입력될 때, 알파벳 대문자를 조합하여 만들 수 있는 가장 빠른 ideal string 출력하기
public class B_1352 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//알파벳 대문자를 기준으로 탐색
		if(1<=n&&n<=100) {
			String tmp = "";
			int idx = n/2;
			if(n%2!=0) {
				idx++;
			}
			//문자열의 중간길이 이전까지 먼저 알파벳 순서대로 채워준다
			for(int i=0;i<idx;i++) {
				tmp+=(char)(65+i);
			}
			//마지막 인덱스부터 순서대로 개수만큼 채워진 문자 반복해서 늘려준다
			for(int i=tmp.length()-1;i>=0;i--) {
				for(int j=0;j<i;j++) {
					tmp+=tmp.charAt(i);
				}
			}
			if(tmp.length()!=n) {
				System.out.println(-1);
				System.exit(0);
			}else {
				System.out.println(tmp);
			}
		}
	}
}
