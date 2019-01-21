package test_190121;

import java.util.Scanner;

//찾고자 하는 문자열과 n개의 반지 문자열이 주어질 때, 해당 반지에 찾고자 하는 문자열이 포함되었는지 확인하는 프로그램 작성하기
public class B_5555 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = sc.nextInt();
		int cnt = 0;
		
		if(1<=n&&n<=100) {
			int k = 0;
			while(k<n) {
				String ring = sc.next();
				for(int i=0;i<ring.length();i++) {
					if(ring.charAt(i)==str.charAt(0)) {
						if(i+str.length()<=ring.length()
								&&ring.substring(i, i+str.length()).equals(str)) {
							cnt++;
							break;
						}
						//부분 문자열의 범위가 반지 문자열의 범위를 벗어나면(다시 앞 인덱스부터 탐색)
						else if(i+str.length()>ring.length()) {
							String tmp = ring.substring(i,ring.length());
							int limit = str.length()-tmp.length();
							for(int j=0;j<limit;j++) {
								tmp+=ring.charAt(j);
							}
							if(tmp.equals(str)) {
								cnt++;
								break;
							}
						}
					}
				}
				k++;
			}
			System.out.println(cnt);
		}
	}
}
