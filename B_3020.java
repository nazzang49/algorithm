package test_190123;

import java.util.Arrays;
import java.util.Scanner;

//종유석과 석순의 높이 n개, 동굴의 높이 h가 주어질 때 개똥벌레가 장애물을 부수는 갯수의 최소값과 해당 구간의 갯수 동시 출력하기
public class B_3020 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		
		if(2<=n&&n<=200000&&2<=h&&h<=500000) {
			//석순(바닥에서 자라는)과 종유석(천장에서 자라는)의 높이 입력
			int [] s = new int[h+2];
			int [] j = new int[h+2];
			
			//높이별 석순, 종유석 갯수
			for(int i=0;i<n/2;i++) {
				s[sc.nextInt()]++;
				j[sc.nextInt()]++;
			}
			
			//특정 높이를 지나는 석순, 종유석 갯수
			for(int i=h;i>=0;i--) {
				s[i]=s[i]+s[i+1];
				j[i]=j[i]+j[i+1];
			}
			
			int ans = 1;
			int min = Integer.MAX_VALUE;
			//각 높이별 구간 비교
			for(int i=1;i<=h;i++) {
				int result = s[i]+j[h-i+1];
				if(min>result) {
					min=result;
				}else if(min==result) {
					ans++;
				}
			}
			System.out.println(min);
			System.out.println(ans);
		}
	}
}
