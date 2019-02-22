package test_181116;

import java.util.Scanner;

//원탁에 둘러 앉은 짝수명의 사람들 간 악수를 할 때 서로 팔이 교차하지 않고 이행하는 경우의 수
public class B_1670 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		if(1<=n&&n<=10000) {
			if(n==2) {
				cnt=1;
			}else if(n==4) {
				cnt=2;
			}else {
				//인접한 사람끼리 악수하는 경우(오or왼)
				cnt+=2;
				//인접+마주보는 사람끼리 악수하는 경우
				cnt+=n/2;		
			}
			System.out.println(cnt%987654321);
		}
	}
}
