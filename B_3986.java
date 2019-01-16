package test_190116;

import java.util.Scanner;

//A와 B로 이루어진 문자열이 주어질 때, 각 문자를 하나의 쌍으로 이을 때 선이 교차하지 않는 "좋은 단어"의 갯수 출력하기
public class B_3986 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		
		if(1<=n&&n<=100) {
			//문자열 입력
			for(int i=0;i<n;i++) {
				String str = sc.next();
				boolean flag = false;
				int cnt = 0;
				for(int j=1;j<str.length()-1;j++) {
					cnt=0;
					if(str.charAt(j)!=str.charAt(j-1)) {
						cnt++;
					}
					if(str.charAt(j)!=str.charAt(j+1)) {
						cnt++;
					}
					if(cnt==2) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
