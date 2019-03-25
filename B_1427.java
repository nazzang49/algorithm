package test_190325;

import java.util.Scanner;

//입력으로 주어진 수의 각 자릿수를 내림차순 정렬하기
public class B_1427 {

	static int [] sorted;
	
	//정복
	public static void sort(int [] A, int m, int mid, int n) {
		int i = m;
		int j = mid+1;
		int k = m;
		while(i<=mid&&j<=n) {
			if(A[i]<=A[j]) {
				sorted[k]=A[j];
				j++;
			}else {
				sorted[k]=A[i];
				i++;
			}
			k++;
		}
		if(i>mid) {
			for(int t=j;t<=n;t++) {
				sorted[k]=A[t];
				k++;
			}
		}else {
			for(int t=i;t<=mid;t++) {
				sorted[k]=A[t];
				k++;
			}
		}
		for(int t=m;t<=n;t++) {
			A[t]=sorted[t];
		}
	}
	
	//분할
	public static void merge(int [] A, int m, int n) {
		if(m<n) {
			int mid = (m+n)/2;
			merge(A,m,mid);
			merge(A,mid+1,n);
			sort(A,m,mid,n);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//int형 범위만 입력 가능
		if(str.length()<=1000000000) {
			int [] arr = new int[str.length()];
			sorted = new int[str.length()];
			for(int i=0;i<str.length();i++) {
				arr[i]=str.charAt(i)-'0';
			}
			
			//병합 정렬(내림차순)
			merge(arr,0,arr.length-1);
			
			//결과 출력
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]);
			}
		}
	}
}
