package test_190122;

import java.util.Arrays;
import java.util.Scanner;

//���� ������ �ִ� n���� ī��, �Է����� �־����� m���� ī�带 ���� ���Ͽ� ������ �ִ� ī��� 1��, �ƴ϶�� 0�� ����ϱ�
public class B_10815 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=500000&&1<=m&&m<=500000) {
			int [] A = new int[n];
			int [] B = new int[m];
			//ī�� �Է�
			for(int i=0;i<A.length;i++) {
				A[i]=sc.nextInt();
			}
			//������ �ִ� ī�带 �������� ����
			Arrays.sort(A);
			for(int i=0;i<B.length;i++) {
				//ã���� �ϴ� ����
				int tmp = sc.nextInt();
				
				int left = 0;
				int right = A.length-1;
				int mid = 0;
				while(left<=right) {
					mid = (left+right)/2;
					//ã���� �ϴ� ���� �߰������� ũ��
					if(tmp>A[mid]) {
						left=mid+1;
					}
					//ã���� �ϴ� ���� �߰������� ������
					else if(tmp<A[mid]) {
						right=mid-1;
					}
					//ã���� �ϴ� ���� ������
					else {
						B[i]=1;
						break;
					}
				}
			}
			//���� ���
			for(int i=0;i<B.length;i++) {
				System.out.print(B[i]+" ");
			}
		}
	}
}
