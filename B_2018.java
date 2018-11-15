package test_181115;

import java.util.Scanner;

//어떠한 자연수 입력값이 주어졌을 때, 연속된 자연수의 합으로 해당 자연수를 표현할 수 있는 경우의 수 구하기
public class B_2018 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//경우의 수 저장할 변수(자기 자신은 반드시 가능하므로 1로 초기화)
		int cnt = 1;
		
		if(1<=n&&n<=10000000) {
			for(int i=1;i<=n/2+1;i++) {
				int sum = 0;
				sum+=i;
				for(int j=i+1;j<=n/2+1;j++) {
					sum+=j;
					if(sum==n) {
						cnt++;
						break;
					}else if(sum>n) {
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
