package test_190323;

//선분할, 후병합(합치는 순간 정렬 수행)
public class MergeSort {

	//정렬을 위해 사용할 단계별 임시 배열
	static int [] sorted = new int[8];
	
	//m=시작 mid=중간 n=끝
	public static void sort(int [] A, int m, int mid, int n) {
		//세 개의 인덱스 필요
		//i=왼쪽 부분배열의 인덱스
		int i = m;
		//j=오른쪽 부분배열의 인덱스
		int j = mid+1;
		//k=합쳐질 배열의 인덱스(가장 처음 들어갈 인덱스 값 = m)
		int k = m;
		//작은 순서대로 배열에 삽입(왼쪽 부분 배열과 오른쪽 부분 배열의 값 비교)
		while(i<=mid&&j<=n) {
			if(A[i]<=A[j]) {
				sorted[k]=A[i];
				i++;
			}else {
				sorted[k]=A[j];
				j++;
			}
			k++;
		}
		//i>mid = 왼쪽 부분 배열의 값이 먼저 모두 입력되면(남은 오른쪽도 따라서 입력)
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
		//실제 배열로 합치는 과정
		for(int t=m;t<=n;t++) {
			A[t]=sorted[t];
		}
	}
	
	public static void merge(int [] A, int m, int n) {
		//크기가 1보다 큰 경우만 고려
		if(m<n) {
			int mid = (m+n)/2;
			//먼저 반으로 모두 분할하고 나중에 합침
			//왼쪽
			merge(A, m, mid);
			//오른쪽
			merge(A, mid+1, n);
			//정렬+합침
			sort(A, m, mid, n);
		}
	}
	
	public static void main(String[] args) {
		int [] ans = {7,6,5,8,3,5,9,1};
		
		//결과 출력(자바에서 배열은 객체로 인식하기 때문에 정렬 메소드가 void형이어도 전역변수와 같이 정렬 결과가 반영됨)
		merge(ans,0,ans.length-1);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
