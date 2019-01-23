package test_190123;

import java.util.Arrays;
import java.util.Scanner;

//자연수가 저장된 배열 A와 B가 주어질 때 A만을 재배열하여 같은 인덱스의 숫자끼리 곱한 값들을 모두 더할 시 얻을 수 있는 최소값 구하기
public class B_1026 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//입력 받는 배열의 길이는 최대 50
		if(1<=n&&n<=50) {
			int [] A = new int[n];
			int [] B = new int[n];
			
			//자연수 입력
			for(int i=0;i<n;i++) {
				A[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				B[i]=sc.nextInt();
			}
			//배열 A 오름차순 정렬
			Arrays.sort(A);
			//B배열에서의 최대값 추출하기
			int max = B[0];
			for(int i=1;i<n;i++) {
				if(B[i]>max) {
					max=B[i];
				}
			}
			int sum = 0;
			int idx = 0;
			while(max>=1) {
				for(int i=0;i<n;i++) {
					if(max==B[i]) {
						sum+=A[idx]*B[i];
						idx++;
					}
				}
				max--;
			}
			System.out.println(sum);
		}
	}
}
