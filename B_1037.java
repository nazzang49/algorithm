package test_190201;

import java.util.Arrays;
import java.util.Scanner;

//N�� ��� ��� A�� �־��� ��, N�� ���ϴ� ���α׷� �ۼ��ϱ�
public class B_1037 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//�ִ� ��� ���� = 50
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
