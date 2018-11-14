package test_181107;

import java.util.Scanner;

//콘센트 플러그가 하나밖에 없을 때 가지고 있는 멀티탭을 활용하여 최대로 플러그를 확보할 수 있는 방법
public class B_2010 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//최종 확보한 플러그 개수 저장
		int cnt = 1;
		
		//멀티탭 연결할 때마다 플러그 개수는 -1 and +tmp
		if(1<=n&&n<=500000) {
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<1000) {
					cnt+=tmp;
					cnt-=1;
				}
			}
			System.out.println(cnt);
		}
	}
}
