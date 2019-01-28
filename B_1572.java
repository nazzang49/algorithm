package test_190128;

import java.util.Scanner;

//세준이가 온도를 재기 시작한 n초 동안의 온도 현황이 주어질 때, k초 마다 이전 온도 값들의 중앙값 전체 합 출력하기 
public class B_1572 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//전체 수열
		int n = sc.nextInt();
		//k초 동안의 부분 수열
		int k = sc.nextInt();
		
		if(n<=250000&&k<=5000&&n>=k) {
			int [] arr = new int[n];
			//전체 수열 입력
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int sum = 0;
			int cri = 0;
			//부분 수열의 길이가 짝수이면
			if(k%2==0) {
				cri = k/2-1;
			}
			//부분 수열의 길이가 홀수이면
			else {
				cri = k/2;
			}
			for(int i=cri;i<arr.length-k/2;i++) {
				sum+=arr[i];
			}
			System.out.println(sum);
		}
	}
}
