package test_181118;

import java.util.Scanner;

//두 개의 입력값이 주어질 때, 두 수 사이에서 8이 가장 적게 들어있는 수의 8 개수 구하기
public class B_1105 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//8의 개수
		int cnt = 0;
		//가장 적은 8의 개수
		int min = Integer.MAX_VALUE;
		
		if(1<=n&&n<=2000000000&&n<=m&&m<=2000000000) {
			for(int i=n;i<=m;i++) {
				String str = String.valueOf(i);
				for(int j=0;j<str.length();j++) {
					if(str.charAt(j)=='8') {
						cnt++;
					}
				}
				//8이 하나도 없는 수일 경우
				if(cnt==0) {
					continue;
				}
				//현재 수의 8의 개수가 이전까지의 8 개수보다 더 적을 경우
				if(cnt<min) {
					min=cnt;
				}
				cnt=0;
			}
			System.out.println(min);
		}
	}
}
