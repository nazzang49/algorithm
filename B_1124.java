package test_181115;

import java.util.Scanner;

//언더프라임(자연수 X를 소인수분해 했을 때, 출현하는 소수의 개수가 소수인 수) 구하기
public class B_1124 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//소수의 개수 저장할 변수
		int cnt = 0;
		//정답 개수 저장할 변수
		int answer = 0;
		
		if(2<=n&&n<=100000&&2<=m&&m<=100000&&n<=m) {
			for(int i=n;i<=m;i++) {
				int tmp = i;
				//마지막 소수가 등장할 때까지 반복 수행
				for(int j=2;j<=tmp/2;j++) {
					if(tmp%j==0) {
						tmp=tmp/j;
						cnt++;
						//반복문의 시작을 다시 2로 조정하기 위한 조치
						j=1;
					}
				}
				//마지막 등장하는 소수 1개 가산
				cnt++;
				boolean flag = false;
				for(int j=2;j<=cnt/2;j++) {
					if(cnt%j==0) {
						flag=true;
						break;
					}
				}
				//cnt의 개수가 소수이고 본 수 = 소수 아닌 경우 ex)2,3,5,7 등
				if(!flag&&!(cnt==1)) {
					answer++;
				}
				cnt=0;
			}
			System.out.println(answer);
		}
	}
}
