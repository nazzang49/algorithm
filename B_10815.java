package test_190122;

import java.util.Arrays;
import java.util.Scanner;

//현재 가지고 있는 n개의 카드, 입력으로 주어지는 m개의 카드를 서로 비교하여 가지고 있는 카드면 1을, 아니라면 0을 출력하기
public class B_10815 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=500000&&1<=m&&m<=500000) {
			int [] A = new int[n];
			int [] B = new int[m];
			//카드 입력
			for(int i=0;i<A.length;i++) {
				A[i]=sc.nextInt();
			}
			//가지고 있는 카드를 오름차순 정렬
			Arrays.sort(A);
			for(int i=0;i<B.length;i++) {
				//찾고자 하는 숫자
				int tmp = sc.nextInt();
				
				int left = 0;
				int right = A.length-1;
				int mid = 0;
				while(left<=right) {
					mid = (left+right)/2;
					//찾고자 하는 수가 중간값보다 크면
					if(tmp>A[mid]) {
						left=mid+1;
					}
					//찾고자 하는 수가 중간값보다 작으면
					else if(tmp<A[mid]) {
						right=mid-1;
					}
					//찾고자 하는 수가 나오면
					else {
						B[i]=1;
						break;
					}
				}
			}
			//정답 출력
			for(int i=0;i<B.length;i++) {
				System.out.print(B[i]+" ");
			}
		}
	}
}
