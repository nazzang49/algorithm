package test_190130;

import java.util.Scanner;

//�� ����(�� ���� ���� - �������� ����)
public class HeapSort {

	//���� ���� Ʈ�� ����
	static int [] A;
	
	//�� ���� ����(�ִ���)
	public static void makeHeap() {
		for(int i=1;i<A.length;i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				//�ڽ� ��忡 �� ū ���� ������ �θ� ���� ����(���� �� ������ ��Ʈ ������ ������)
				if(A[root]<A[c]) {
					int tmp = A[root];
					A[root]=A[c];
					A[c]=tmp;
				}
				c = root;
			}while(c>0);
		}
	}
	
	//�� ���� ����
	public static void sortHeap() {
		//�ִ밪�� Ʈ���� ���� �ڷ� �̵�
		for(int i=A.length-1;i>=0;i--) {
			int tmp = A[0];
			A[0]=A[i];
			A[i]=tmp;
			int c = 1;
			int root = 0;
			do {
				c=2*root+1;
				//�ڽ� ��� �� �� ū ���� �ֻ������ �̵�
				if(c<i-1&&A[c]<A[c+1]) {
					c++;
				}
				//�ڽ� > �θ� (����)
				if(c<i&&A[root]<A[c]) {
					int temp = A[root];
					A[root]=A[c];
					A[c]=temp;
				}
				root = c;
			}while(c<i);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		A = new int[10];
		//���� ���ĵ��� ���� Ʈ�� �Է�
		for(int i=0;i<A.length;i++) A[i]=sc.nextInt();
		makeHeap();
		sortHeap();
		//���ĵ� ��� ���
		for(int i=0;i<A.length;i++) System.out.print(A[i]+" ");
	}
}
