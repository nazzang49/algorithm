package test_190201;

import java.util.Arrays;
import java.util.Scanner;

//N의 모든 약수 A가 주어질 때, N을 구하는 프로그램 작성하기
public class B_1037 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//최대 약수 갯수 = 50
		if(t<=50) {
			int [] A = new int[t];
			for(int i=0;i<A.length;i++) {
				A[i]=sc.nextInt();
			}
			Arrays.sort(A);
			System.out.println(A[0]*A[A.length-1]);
		}
	}
}
