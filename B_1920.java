package test_190328;

import java.util.Arrays;
import java.util.Scanner;

//N개의 정수가 주어질 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램 작성하기
public class B_1920 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//데이터 양이 많을 수도 있기 때문에 이분탐색이 적합
		if(n<=100000) {
			int [] arr = new int[n];
			//정수 입력
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//오름차순 정렬
			Arrays.sort(arr);
			int m = sc.nextInt();
			int [] ans = new int[m];
			for(int i=0;i<m;i++) {
				//찾고자 하는 수 입력
				int find = sc.nextInt();
				//이분탐색 실행
				int left = 0;
				int right = arr.length-1;
				int mid = 0;
				while(left<=right) {
					mid = (left+right)/2;
					//찾고자 하는 수가 배열의 왼쪽에 있으면
					if(arr[mid]>find) {
						right=mid-1;
					}
					//찾고자 하는 수가 배열의 오른쪽에 있으면
					else if(arr[mid]<find) {
						left=mid+1;
					}
					//찾고자 하는 수가 등장하면
					else {
						ans[i]=1;
						break;
					}
				}
			}
			//정답 출력
			for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
		}	
	}
}
