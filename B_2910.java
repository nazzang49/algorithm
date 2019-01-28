package test_190128;

import java.util.Scanner;

//�Էµ� �� �迭�� �������� �����ϱ�
public class B_2910 {

	static int [] arr;
	
	public static void quick(int left, int right) {
		int l = left;
		int r = right;
		//�߰� �ε��� �ڿ����� ���ذ����� ����
		int mid=(l+r)/2;
		while(l<=r) {
			//���� �κ��� �߰������� ũ��(���������� �����ϸ�)
			while(arr[l]>arr[mid]) l++;
			//������ �κ��� �߰������� ������(���������� �����ϸ�)
			while(arr[r]<arr[mid]) r--;
			
			//���ǿ� �������� �ʴ� ��� ���� �� �ε��� �̵�
			if(l<=r) {
				int tmp = arr[l];
				arr[l]=arr[r];
				arr[r]=tmp;
				l++;
				r--;
			}
		}
		//1/2�� ������ ���̸� �κ� ���� ����
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
			//�Է����� �־����� �� �迭
			arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//���� ����(�� ����)
			quick(0,arr.length-1);
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
