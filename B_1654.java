package test_190329;

import java.util.Arrays;
import java.util.Scanner;

//필요한 N개 랜선을 얻기 위해 정할 수 있는 1개 랜선의 최대 길이 구하기
public class B_1654 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//이미 가지고 있는 랜선 갯수
		int n = sc.nextInt();
		//얻고자 하는 랜선 총 갯수
		int k = sc.nextInt();
		
		if(n<=10000&&k<=1000000) {
			long [] lan = new long[n];
			//현재 보유 중인 랜선들의 길이 입력
			for(int i=0;i<lan.length;i++) {
				lan[i]=sc.nextInt();
			}
			//오름차순 정렬
			Arrays.sort(lan);
			//이분 탐색
			long left = 1;
			long right = lan[lan.length-1];
			long mid = 0;
			long sum = 0;
			long ans = 0;
			while(left<=right) {
				mid = (left+right)/2;
				sum = 0;
				for(int i=0;i<lan.length;i++) {
					sum+=lan[i]/mid;
				}
				//현재 랜선 갯수 >= 얻고자 하는 랜선 갯수 = 길이 증가
				if(sum>=k) {
					left=mid+1;
					ans = Math.max(ans, mid);
				}
				//현재 랜선 갯수 < 얻고자 하는 랜선 갯수 = 길이 감소
				else right=mid-1;
			}
			System.out.println(ans);
		}
	}
}
