package test_181113;

import java.util.Scanner;

//두 개의 자연수를 합하여 입력된 값과 같아지는 경우의 수 구하기
public class B_1940 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] arr = new int[n];
		int cnt = 0;
		
		if(1<=n&&n<=15000&&1<=m&&m<=10000000) {
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//선택정렬 방식과 동일한 탐색
			for(int i=0;i<arr.length-1;i++) {
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]+arr[j]==m) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
