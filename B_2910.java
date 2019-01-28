package test_190128;

import java.util.Scanner;

//입력된 빈도 배열을 내림차순 정렬하기
public class B_2910 {

	static int [] arr;
	
	public static void quick(int left, int right) {
		int l = left;
		int r = right;
		//중간 인덱스 자연수를 기준값으로 설정
		int mid=(l+r)/2;
		while(l<=r) {
			//왼쪽 부분이 중간값보다 크면(내림차순에 부합하면)
			while(arr[l]>arr[mid]) l++;
			//오른쪽 부분이 중간값보다 작으면(내림차순에 부합하면)
			while(arr[r]<arr[mid]) r--;
			
			//조건에 부합하지 않는 경우 스왑 및 인덱스 이동
			if(l<=r) {
				int tmp = arr[l];
				arr[l]=arr[r];
				arr[r]=tmp;
				l++;
				r--;
			}
		}
		//1/2씩 범위를 줄이며 부분 정렬 실행
		if(l<right) {
			quick(l,right);
		}
		if(r>left) {
			quick(left,r);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=c&&c<=1000000000) {
			//입력으로 주어지는 빈도 배열
			arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//정렬 실행(퀵 정렬)
			quick(0,arr.length-1);
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
