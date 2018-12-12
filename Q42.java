package solution;

import java.util.Scanner;

//자연수 n이 주어질 때 n보다 크고, 이진수 변환 시 1의 개수가 같은 수 중 가장 작은 수 구하기
public class Q42 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000000) {
			//이진수  표현
			String str = Integer.toBinaryString(n);
			//이진수에서 1의 개수
			int cnt = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='1') {
					cnt++;
				}
			}
			int answer = 0;
			for(int i=n+1;i<1000000;i++) {
				str=Integer.toBinaryString(i);
				answer=0;
				for(int j=0;j<str.length();j++) {
					if(str.charAt(j)=='1') {
						answer++;
					}
				}
				if(cnt==answer) {
					answer=i;
					break;
				}
			}
			System.out.println(answer);
		}
	}
}
