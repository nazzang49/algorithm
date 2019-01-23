package test_190123;

import java.util.Arrays;
import java.util.Scanner;

//�ڿ����� ����� �迭 A�� B�� �־��� �� A���� ��迭�Ͽ� ���� �ε����� ���ڳ��� ���� ������ ��� ���� �� ���� �� �ִ� �ּҰ� ���ϱ�
public class B_1026 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//�Է� �޴� �迭�� ���̴� �ִ� 50
		if(1<=n&&n<=50) {
			int [] A = new int[n];
			int [] B = new int[n];
			
			//�ڿ��� �Է�
			for(int i=0;i<n;i++) {
				A[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				B[i]=sc.nextInt();
			}
			//�迭 A �������� ����
			Arrays.sort(A);
			//B�迭������ �ִ밪 �����ϱ�
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
