package test_190130;

import java.util.Scanner;

//힙 정렬(힙 구조 생성 - 오름차순 정렬)
public class HeapSort {

	//완전 이진 트리 기준
	static int [] A;
	
	//힙 구조 생성(최대힙)
	public static void makeHeap() {
		for(int i=1;i<A.length;i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				//자식 노드에 더 큰 값이 있으면 부모 노드와 스왑(스왑 할 때마다 루트 노드부터 재정렬)
				if(A[root]<A[c]) {
					int tmp = A[root];
					A[root]=A[c];
					A[c]=tmp;
				}
				c = root;
			}while(c>0);
		}
	}
	
	//힙 구조 정렬
	public static void sortHeap() {
		//최대값을 트리의 가장 뒤로 이동
		for(int i=A.length-1;i>=0;i--) {
			int tmp = A[0];
			A[0]=A[i];
			A[i]=tmp;
			int c = 1;
			int root = 0;
			do {
				c=2*root+1;
				//자식 노드 중 더 큰 값을 최상단으로 이동
				if(c<i-1&&A[c]<A[c+1]) {
					c++;
				}
				//자식 > 부모 (스왑)
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
		//최초 정렬되지 않은 트리 입력
		for(int i=0;i<A.length;i++) A[i]=sc.nextInt();
		makeHeap();
		sortHeap();
		//정렬된 결과 출력
		for(int i=0;i<A.length;i++) System.out.print(A[i]+" ");
	}
}
