package test_190328;

import java.util.Scanner;

//설탕을 Nkg 배달해야 할 때, 필요한 봉지의 최소 갯수 구하기(조합이 불가능한 경우 -1 출력)
public class B_2839 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<=5000) {
			if(n%5==0) System.out.println(n/5);
			else {
				int cnt = Integer.MAX_VALUE;
				int fiveCnt = 0;
				while(5*fiveCnt<=n) {
					int tmp = (n-5*fiveCnt);
					if(tmp%3==0) cnt = Math.min(cnt, fiveCnt+tmp/3);
					fiveCnt++;
				}
				if(cnt==Integer.MAX_VALUE) System.out.println(-1);
				else System.out.println(cnt);
			}
		}	
	}
}
