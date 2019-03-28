package test_190328;

import java.util.Arrays;
import java.util.Scanner;

//각 지방에서 요청하는 예산, 미리 배정된 총 예산이 주어질 때, 가능한 최대의 예산을 활용하도록 하는 상한값 구하기
public class B_2512 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<=10000) {
			int [] arr = new int[n];
			//요청 예산 입력
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//가용할 수 있는 총 예산
			int limit = sc.nextInt();
			//오름차순 정렬
			Arrays.sort(arr);
			//이분 탐색
			int left = 1;
			int right = arr[arr.length-1];
			long sum = 0;
			int mid = 0;
			while(left<=right) {
				mid = (left+right)/2;
				sum = 0;
				for(int i=0;i<arr.length;i++) {
					if(arr[i]>mid) sum+=mid;
					else sum+=arr[i];
				}
				if(sum>limit) {
					right=mid-1;
				}else if(sum<limit) {
					left=mid+1;
				}else {
					right=mid;
					break;
				}
			}
			System.out.println(right);
		}	
	}
}
